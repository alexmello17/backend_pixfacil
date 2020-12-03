package com.pix.api.pixfacil.dto.pixfacil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class VendaDTO {
	
	private BigDecimal expiracao;
	private String infoPagador;
	private Long idUsuario;
	private List<ItensVendaDTO> itensVendas;
	private BigDecimal descValor;
	private Long idLoja;
	private Long status;
	private Long idVenda;
	private BigDecimal valorTotalVenda;
	private String dataVenda;

	public BigDecimal getExpiracao() {
		return expiracao;
	}

	public void setExpiracao(BigDecimal expiracao) {
		this.expiracao = expiracao;
	}

	public String getInfoPagador() {
		return infoPagador;
	}

	public void setInfoPagador(String infoPagador) {
		this.infoPagador = infoPagador;
	}

	public List<ItensVendaDTO> getItensVendas() {
		return itensVendas;
	}

	public void setItensVendas(List<ItensVendaDTO> itensVendas) {
		this.itensVendas = itensVendas;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public BigDecimal getDescValor() {
		return descValor;
	}

	public void setDescValor(BigDecimal descValor) {
		this.descValor = descValor;
	}

	public Long getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(Long idLoja) {
		this.idLoja = idLoja;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}

	public BigDecimal getValorTotalVenda() {
		return valorTotalVenda;
	}

	public void setValorTotalVenda(BigDecimal valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
	}

	public String getDataVenda() {
		return dataVenda;
	}
	
	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.dataVenda = sdf.format(dataVenda);
	}
	
}
