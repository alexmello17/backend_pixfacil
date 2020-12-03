package com.pix.api.pixfacil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pix.api.pixfacil.dto.pixfacil.LoginDTO;
import com.pix.api.pixfacil.dto.pixfacil.LojaDTO;
import com.pix.api.pixfacil.dto.pixfacil.ProdutoDTO;
import com.pix.api.pixfacil.dto.pixfacil.RetornoVendaDTO;
import com.pix.api.pixfacil.dto.pixfacil.UsuarioDTO;
import com.pix.api.pixfacil.dto.pixfacil.VendaDTO;
import com.pix.api.pixfacil.entity.Estabelecimento;
import com.pix.api.pixfacil.service.EstabelecimentoService;
import com.pix.api.pixfacil.service.IVenda;
import com.pix.api.pixfacil.service.LojaService;
import com.pix.api.pixfacil.service.ProdutoService;
import com.pix.api.pixfacil.service.UsuarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class PixController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private EstabelecimentoService estabService;

	@Autowired
	private LojaService lojaService;

	@Autowired
	private ProdutoService prodService;

	@Autowired
	private IVenda vendaService;

	@RequestMapping(path = "/autenticar", method = RequestMethod.POST)
	@ApiOperation(value = "Autenticacão em API de backend.")
	public UsuarioDTO login(@ApiParam("Campos Obrigatórios: 'user' e 'pass'.") @RequestBody LoginDTO login) {
		return usuarioService.login(login);
	}

	@RequestMapping(path = "/venda", method = RequestMethod.PUT)
	@ApiOperation(value = "Inclusão de nova venda.")
	public RetornoVendaDTO incluirVenda(@ApiParam("Campos Obrigatórios: 'idLoja', 'idUsuario', 'descValor', "
										+ "'itensVendas', 'itensVendas.idProduto', 'itensVendas.quantidade', "
										+ "'itensVendas.descValor', 'itensVendas.descPercentual'.") 
										@RequestBody VendaDTO venda) {
		return vendaService.incluirVenda(venda);
	}

	@RequestMapping(path = "/usuarios", method = RequestMethod.GET)
	@ApiOperation(value = "Buscar todos os usuários cadastrados.")
	public List<UsuarioDTO> buscarUsuarios() {
		return usuarioService.findAll();
	}

	@RequestMapping(path = "/estabelecimentos/{idEstab}", method = RequestMethod.GET)
	@ApiOperation(value = "Buscar estabelecimento por id.")
	public Estabelecimento buscarEstabelecimentos(@ApiParam("id do Estabelecimento cadastrado.") @PathVariable("idEstab") Long idEstab) {
		return estabService.findById(idEstab);
	}

	@RequestMapping(path = "/lojas/{idEstab}", method = RequestMethod.GET)
	@ApiOperation(value = "Buscar lojas por id do Estabelecimento.")
	public List<LojaDTO> buscarLojasPorEstabelecimento(@ApiParam("id do Estabelecimento cadastrado.") @PathVariable("idEstab") Long idEstab) {
		return lojaService.findLojasEstabelecimento(idEstab);
	}

	@RequestMapping(path = "/produtos", method = RequestMethod.GET)
	@ApiOperation(value = "Buscar produtos por título.")
	public List<ProdutoDTO> buscarProdutosPorTitulo(
			@ApiParam("titulo do produto cadastrado.")  @RequestParam("desc") String desc,
			@ApiParam("id da loja cadastrada em estoque para o produto.") @RequestParam("idLoja") Long idLoja) {
		return prodService.findProdutosByDesc(desc, idLoja);
	}

	@RequestMapping(path = "/produto", method = RequestMethod.GET)
	@ApiOperation(value = "Buscar produtos por codigo de barras.")
	public ProdutoDTO buscarProdutosPorCodBarras(
			@ApiParam("codigo de barras cadastrado.") @RequestParam("codBarras") String codBarras,
			@ApiParam("id da loja cadastrada em estoque para o produto.") @RequestParam("idLoja") Long idLoja) {
		return prodService.findProdutosByCodbar(codBarras, idLoja);
	}
	
	@RequestMapping(path = "/produto/{idProduto}", method = RequestMethod.GET)
	@ApiOperation(value = "Buscar produtos por id do produto.")
	public ProdutoDTO buscarProdutoPorId(@ApiParam("id do produto cadastrado.") @PathVariable("idProduto") Long idUsuario) {
		return prodService.findById(idUsuario);
	}
	
	@RequestMapping(path = "/vendas/{idUsuario}", method = RequestMethod.GET)
	@ApiOperation(value = "Buscar vendas por id do usuário.")
	public List<VendaDTO> buscarVendas(@ApiParam("id do usuário cadastrado.") @PathVariable("idUsuario") Long idUsuario) {
		return vendaService.buscarVendas(idUsuario);
	}
	
	@RequestMapping(path = "/postback", method = RequestMethod.POST)
	public void vendaPostBack(@RequestBody String payGoTransaction) {
//		http://177.19.152.131:30001/pixfacil/v1/postback
		System.out.println(payGoTransaction);
	}
}