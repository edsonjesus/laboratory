package br.gov.serpro.catalogo.entity;

import javax.persistence.Entity;

@Entity
public class Internalizacao extends Fase {

	public Internalizacao() {
		this.setFase(FaseEnum.INTERNALIZACAO);
		//this.setProximaFase(FaseEnum.SUSTENTACAO);
	}

	// Restricoes de uso
	private Integer restricao;
	private String restricaoQuemPode;
	private String restricaoJustificativa;

	// Aquisições para a internalização
	private Integer aquisicaoNecessaria;
	private String aquisicaoItens;
	private String aquisicaoResultado;
	
	// capacitacoes
	private Integer capacitacao;
	private String capacitacaoNecessarias;
	private String capacitacaoRealizadas;
	
	// capacitacoes
	private Integer analiseDeRiscos;
	private String analiseDeRiscosJustificativa;
	
	public Integer getRestricao() {
		return restricao;
	}
	public void setRestricao(Integer restricao) {
		this.restricao = restricao;
	}
	public String getRestricaoQuemPode() {
		return restricaoQuemPode;
	}
	public void setRestricaoQuemPode(String restricaoQuemPode) {
		this.restricaoQuemPode = restricaoQuemPode;
	}
	public String getRestricaoJustificativa() {
		return restricaoJustificativa;
	}
	public void setRestricaoJustificativa(String restricaoJustificativa) {
		this.restricaoJustificativa = restricaoJustificativa;
	}
	public Integer getAquisicaoNecessaria() {
		return aquisicaoNecessaria;
	}
	public void setAquisicaoNecessaria(Integer aquisicaoNecessaria) {
		this.aquisicaoNecessaria = aquisicaoNecessaria;
	}
	public String getAquisicaoItens() {
		return aquisicaoItens;
	}
	public void setAquisicaoItens(String aquisicaoItens) {
		this.aquisicaoItens = aquisicaoItens;
	}
	public String getAquisicaoResultado() {
		return aquisicaoResultado;
	}
	public void setAquisicaoResultado(String aquisicaoResultado) {
		this.aquisicaoResultado = aquisicaoResultado;
	}

	public Integer getCapacitacao() {
		return capacitacao;
	}
	public void setCapacitacao(Integer capacitacao) {
		this.capacitacao = capacitacao;
	}
	public String getCapacitacaoNecessarias() {
		return capacitacaoNecessarias;
	}
	public void setCapacitacaoNecessarias(String capacitacaoNecessarias) {
		this.capacitacaoNecessarias = capacitacaoNecessarias;
	}
	public String getCapacitacaoRealizadas() {
		return capacitacaoRealizadas;
	}
	public void setCapacitacaoRealizadas(String capacitacaoRealizadas) {
		this.capacitacaoRealizadas = capacitacaoRealizadas;
	}
	public Integer getAnaliseDeRiscos() {
		return analiseDeRiscos;
	}
	public void setAnaliseDeRiscos(Integer analiseDeRiscos) {
		this.analiseDeRiscos = analiseDeRiscos;
	}
	public String getAnaliseDeRiscosJustificativa() {
		return analiseDeRiscosJustificativa;
	}
	public void setAnaliseDeRiscosJustificativa(String analiseDeRiscosJustificativa) {
		this.analiseDeRiscosJustificativa = analiseDeRiscosJustificativa;
	}
	
	

}
