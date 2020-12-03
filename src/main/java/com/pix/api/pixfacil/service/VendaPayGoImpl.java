package com.pix.api.pixfacil.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.pix.api.pixfacil.dao.EstoqueRepository;
import com.pix.api.pixfacil.dao.ProdutoRepository;
import com.pix.api.pixfacil.dao.TxIdRepository;
import com.pix.api.pixfacil.dao.VendaRepository;
import com.pix.api.pixfacil.dto.paygo.KeyEnum;
import com.pix.api.pixfacil.dto.paygo.PayGoTransaction;
import com.pix.api.pixfacil.dto.paygo.Payment;
import com.pix.api.pixfacil.dto.paygo.Pix;
import com.pix.api.pixfacil.dto.pixfacil.ItensVendaDTO;
import com.pix.api.pixfacil.dto.pixfacil.RetornoVendaDTO;
import com.pix.api.pixfacil.dto.pixfacil.VendaDTO;
import com.pix.api.pixfacil.entity.Estoque;
import com.pix.api.pixfacil.entity.ItensVenda;
import com.pix.api.pixfacil.entity.Produto;
import com.pix.api.pixfacil.entity.StatusCob;
import com.pix.api.pixfacil.entity.StatusVenda;
import com.pix.api.pixfacil.entity.Txid;
import com.pix.api.pixfacil.entity.Usuario;
import com.pix.api.pixfacil.entity.Venda;
import com.pix.api.pixfacil.exception.EstoqueInsuficienteException;
import com.pix.api.pixfacil.exception.IntegracaoPayGoException;
import com.pix.api.pixfacil.exception.ProdutoNotFoundException;
import com.pix.api.pixfacil.exception.ValidaCampoDescValor;
import com.pix.api.pixfacil.exception.ValidaCampoIdLoja;
import com.pix.api.pixfacil.exception.ValidaCampoIdUsuario;
import com.pix.api.pixfacil.exception.ValidaCampoItenDescPercentual;
import com.pix.api.pixfacil.exception.ValidaCampoItenDescValor;
import com.pix.api.pixfacil.exception.ValidaCampoItensIdProd;
import com.pix.api.pixfacil.exception.ValidaCampoItensQuant;
import com.pix.api.pixfacil.exception.ValidaCampoItensVenda;
import com.pix.api.pixfacil.exception.VendaNaoEfetuadaException;
import com.pix.api.pixfacil.exception.VendaNaoEncontradaException;

public class VendaPayGoImpl implements IVenda {

	@Autowired
	private VendaRepository vendaRepo;

	@Autowired
	private EstoqueRepository estoqueRepo;

	@Autowired
	private TxIdRepository txidRepo;

	@Autowired
	private ProdutoRepository prodRepo;

	@Autowired
	private RestTemplate rTemplate;
	
	private Logger LOG = LoggerFactory.getLogger(VendaPayGoImpl.class);

//	private static final String mockQrCode = "00020101021226990014br.gov.bcb.pix2577hom-h.c6pix.com/qrs1/01h5cdd0sxXtoDpPMPPtFkVkJhoBvUfWrgPfbpkG8sYuDxqNPHjGsZER520400005303986540558.455802BR5904JOHN6009SAO PAULO62290525QRS1-Y9A4KP03AHZKZKGAYFJY63048AEE";

//	public RetornoVendaDTO incluirVenda(VendaDTO venda) {
//		Venda v = new Venda();
//		v.setDatavenda(new Date());
//		v.setIdvenda(1L);
//		v.setTxidBean(new Txid(UUID.randomUUID().toString()));
//		return criarResponse(v, mockQrCode);
//	}
	
	public RetornoVendaDTO incluirVenda(VendaDTO venda) {
		camposValidos(venda);
		
		final List<ItensVenda> lsitItens = new ArrayList<ItensVenda>();
		final Venda v = new Venda();
		final StatusVenda statusV = new StatusVenda();
		final StatusCob statusC = new StatusCob();
		final Usuario u = new Usuario();
		u.setIdUser(venda.getIdUsuario());
		statusV.setIdstatus(1);
		BigDecimal valorTotalVenda = new BigDecimal(0);
		
		//validacao dos itens para consolidaçao do valor total da venda
		for(ItensVendaDTO iv : venda.getItensVendas()) {
			final ItensVenda i = new ItensVenda();

			final Produto p = validarEstoqueProduto(iv, venda.getIdLoja());
			BigDecimal itenVal = p.getValor();
			
			//aplicar descontos
			i.setDescPercentual(iv.getDescPercentual());
			i.setDescValor(iv.getDescValor());
			if(iv.getDescPercentual().compareTo(BigDecimal.ZERO) == 1) {
				itenVal = itenVal.subtract(itenVal.multiply(iv.getDescPercentual().divide(new BigDecimal(100))));
			}else if(iv.getDescValor().compareTo(BigDecimal.ZERO) == 1) {
				itenVal = itenVal.subtract(iv.getDescValor());
			}
			
			i.setQuantidade(iv.getQuantidade());
			itenVal = itenVal.multiply(iv.getQuantidade());
			i.setValorItem(itenVal);
			i.setProduto(p);
			i.setVenda(v);
			
			valorTotalVenda = valorTotalVenda.add(itenVal);
			lsitItens.add(i);
			
		}
		
		//criacao entidade venda
		v.setDatavenda(new Date());
		v.setExpiracao(venda.getExpiracao());
		v.setInfoPagador(venda.getInfoPagador());
		v.setUsuario(u);
		v.setItensVendas(lsitItens);
		v.setDescValor(venda.getDescValor());
		
		//desconto total venda
		if( venda.getDescValor().compareTo(BigDecimal.ZERO) == 1) {
			valorTotalVenda = valorTotalVenda.subtract(venda.getDescValor());
		}
		
		v.setValorTotalVenda(valorTotalVenda);
		
		//chamada pay go
		final PayGoTransaction pgtrans = new PayGoTransaction();
		pgtrans.setReferenceId(String.valueOf(v.getIdvenda()));
		pgtrans.setAmount(String.valueOf(v.getValorTotalVenda()));
		pgtrans.setDescription("VENDA PRODUTOS E SERVICOS");
		pgtrans.setPostBackUrl("http://177.19.152.131:30001/pixfacil/v1/postback");
		final Pix pix = new Pix();
		pix.setProvider("C6BANK");
		final String[] myStringArray = new String[]{KeyEnum.RANDOM_KEY.name()};
		pix.setKey(myStringArray);
		pix.setExpirationDateTime(v.getDatavenda());
		final Payment payment = new Payment();
		payment.setPix(pix);
		pgtrans.setPayment(payment);

		final HttpHeaders headers = new HttpHeaders();
	 	headers.setContentType(MediaType.APPLICATION_JSON);
	 	headers.add("authenticationApi","alex.provider");
	 	headers.add("authenticationKey","E065537FA4D89942CE26");

	 	final HttpEntity<PayGoTransaction> entity = new HttpEntity<>(pgtrans, headers);
		long init = System.currentTimeMillis();

		ResponseEntity<PayGoTransaction> payGoRet = null;
		try {
			payGoRet = rTemplate.exchange("https://apidemo.gate2all.com.br/v1/transactions", HttpMethod.POST, entity, PayGoTransaction.class);
			LOG.info("POST PAYGO CREATE /transactions: "+ (System.currentTimeMillis() - init)+" millis");
		}catch (Exception e) {
			throw new IntegracaoPayGoException();
		}


		PayGoTransaction body = null;		
		if(payGoRet.getBody() !=null) {
			body = payGoRet.getBody();
		}
		
		PayGoTransaction bodyGet = null;
		init = System.currentTimeMillis();
		int tries = 0;
		do {
			ResponseEntity<PayGoTransaction> payGoGetRet = null;
			try {
				payGoGetRet = rTemplate.exchange("https://apidemo.gate2all.com.br/v1/transactions/"+body.getTransactionId(), HttpMethod.GET, entity, PayGoTransaction.class);
			} catch (Exception e) {
				throw new IntegracaoPayGoException();
			}
			bodyGet = validarQRCode(payGoGetRet);
			if(bodyGet!=null) break;
			tries++;
		}while (tries < 100);
		LOG.info("GET PAYGO CONSULT LOOP /transactions: "+ (System.currentTimeMillis() - init) +" millis - Calls: "+tries);
		if(bodyGet ==null) throw new IntegracaoPayGoException();
		
		//save txid
		final Txid txid = new Txid(body.getTransactionId());
		txidRepo.save(txid);
		v.setTxidBean(txid);
		
		//setstatus
		statusC.setIdstatus(bodyGet.getStatus());
		statusV.setIdstatus(2);
		v.setStatusCob(statusC);
		v.setStatusVenda(statusV);
		
		final Venda v2 = vendaRepo.save(v);

		return criarResponse(v2, bodyGet.getPayment().getPix().getQrCode());
	}

	private RetornoVendaDTO criarResponse(Venda v2, String qrCode) {
		RetornoVendaDTO retVenda = null;

		if (v2 != null) {
			retVenda = new RetornoVendaDTO();
			retVenda.setDataVenda(v2.getDatavenda());
			retVenda.setIdVenda(v2.getIdvenda());
			retVenda.setStatus(String.valueOf(v2.getStatusCob().getIdstatus()));
			retVenda.setTxid(v2.getTxidBean().getTxid());
			retVenda.setMsg("Venda: " + v2.getIdvenda() + " TxId: " + v2.getTxidBean().getTxid() + " realizada com sucesso!");
			retVenda.setQrCode(qrCode);
		} else {
			throw new VendaNaoEfetuadaException();
		}
		return retVenda;
	}

	private Produto validarEstoqueProduto(ItensVendaDTO iv, Long idLoja) {
		Produto p = null;
		try {
			p = prodRepo.findById(iv.getIdProduto()).get();
		} catch (NoSuchElementException e) {
			throw new ProdutoNotFoundException();
		}

		Estoque estoque = estoqueRepo.findeByIdProdutoLoja(iv.getIdProduto(), idLoja);
		if (estoque.getQuantidade().compareTo(iv.getQuantidade()) == -1) {
			throw new EstoqueInsuficienteException();
		} else {
			estoque.setQuantidade(estoque.getQuantidade().subtract(iv.getQuantidade()));
			estoqueRepo.save(estoque);
		}

		return p;
	}
	
	private PayGoTransaction validarQRCode(ResponseEntity<PayGoTransaction> entity) {
		if(entity.getBody() !=null) {
			PayGoTransaction body = entity.getBody();
			if(body.getPayment() != null) {
				if(body.getPayment().getPix() != null) {
					if(body.getPayment().getPix().getQrCode() != null) {
						return body;
					}
				}
			}
		}

		return null;
	}

	@Override
	public List<VendaDTO> buscarVendas(Long idUsuario) {
		
		final List<VendaDTO> vendasDTO = new ArrayList<VendaDTO>();
		List<ItensVendaDTO> itensVendaDTO = null;

		VendaDTO dto = null;
		ItensVendaDTO idto = null;
		
		List<Venda> vendas = vendaRepo.findVendasByUsuario(idUsuario);
		if(vendas.iterator().hasNext()) {
			for(Venda v : vendas) {
				dto = new VendaDTO();
				dto.setDescValor(v.getDescValor());
				dto.setExpiracao(v.getExpiracao());
				dto.setIdLoja(v.getUsuario().getEstabelecimento());
				dto.setIdUsuario(v.getUsuario().getIdUser());
				dto.setInfoPagador(v.getInfoPagador());
				dto.setIdVenda(v.getIdvenda());
				dto.setStatus(v.getStatusCob().getIdstatus());
				dto.setValorTotalVenda(v.getValorTotalVenda());
				dto.setDataVenda(v.getDatavenda());
				itensVendaDTO = new ArrayList<ItensVendaDTO>();
				if(v.getItensVendas() != null && !v.getItensVendas().isEmpty()) {
					for(ItensVenda iv : v.getItensVendas()) {
						idto = new ItensVendaDTO();
						idto.setDescPercentual(iv.getDescPercentual());
						idto.setDescValor(iv.getDescValor());
						idto.setIdProduto(iv.getProduto().getIdproduto());
						idto.setDescricao(iv.getProduto().getDescricao());
						idto.setTitulo(iv.getProduto().getTitulo());
						idto.setCodBarras(iv.getProduto().getCodBarras());
						idto.setValor(iv.getProduto().getValor());
						idto.setImgProduto(iv.getProduto().getImgProduto());
						idto.setQuantidade(iv.getQuantidade());
						itensVendaDTO.add(idto);
					}
				}
				
				dto.setItensVendas(itensVendaDTO);
				vendasDTO.add(dto);
			}
		}else {
			throw new VendaNaoEncontradaException();
		}
		
		return vendasDTO;
	}
	
	private void camposValidos(VendaDTO vdto) {
		if(vdto.getIdLoja()==null || vdto.getIdLoja() == 0L)
			throw new ValidaCampoIdLoja();
		
		if(vdto.getIdUsuario()==null || vdto.getIdUsuario() == 0L)
			throw new ValidaCampoIdUsuario();
		
		if(vdto.getDescValor()==null)
			throw new ValidaCampoDescValor();
		
		if(vdto.getItensVendas()==null || vdto.getItensVendas().isEmpty())
			throw new ValidaCampoItensVenda();
		
		for(ItensVendaDTO ivdto : vdto.getItensVendas()) {
			if(ivdto.getIdProduto()==null || ivdto.getIdProduto()==0L)
				throw new ValidaCampoItensIdProd();
			
			if(ivdto.getQuantidade()==null || ivdto.getQuantidade()==BigDecimal.ZERO)
				throw new ValidaCampoItensQuant();
			
			if(ivdto.getDescPercentual()==null)
				throw new ValidaCampoItenDescPercentual();
			
			if(ivdto.getDescValor()==null)
				throw new ValidaCampoItenDescValor();
		}

	}
}
