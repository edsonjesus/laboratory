package br.gov.serpro.catalogo.entity;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="fase", discriminatorType=DiscriminatorType.STRING)
@NamedQueries({ @NamedQuery(name = Fase.OBTER_POR_FASE_ANTERIOR, query = "select f from Fase f where (f.faseAnterior.id = :id)") })
public class Fase {
	
	public static final String OBTER_POR_FASE_ANTERIOR = "OBTER_FASE_ANTERIOR";
	
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "fase_seq")
	@SequenceGenerator(name = "fase_seq", sequenceName = "fase_id_seq", allocationSize=1)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private FaseEnum fase;	
	
	private String codigoReferencia;
	
	@ManyToOne
	private OrigemDemanda origemReferencia;
	
	private String objetivo;

	private Date dataRealizacao;
	
	private String unidadeGestora;
	
	@NotNull
	@Enumerated(STRING)
	private Situacao situacao;
	
	private String situacaoJustificativa;

	private Date dataFinalizacao;
	
	private String conclusao;
	
	@Enumerated(EnumType.STRING)
	private FaseEnum proximaFase;
			
	private String proximaFaseJustificativa;

	private String proximaFaseUnidadeGestora;
	
	@ManyToOne
	private User proximaFaseLider;	
	
	private Integer proximaFaseCiclo;
	
	@OneToOne
	private Fase faseAnterior;
	

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FaseEnum getFase() {
		return fase;
	}

	public void setFase(FaseEnum fase) {
		this.fase = fase;
	}

	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}



	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Date getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(Date dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}


	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public String getSituacaoJustificativa() {
		return situacaoJustificativa;
	}

	public void setSituacaoJustificativa(String situacaoJustificativa) {
		this.situacaoJustificativa = situacaoJustificativa;
	}

	public Date getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public FaseEnum getProximaFase() {
		return proximaFase;
	}

	public void setProximaFase(FaseEnum proximaFase) {
		this.proximaFase = proximaFase;
	}

	public String getProximaFaseJustificativa() {
		return proximaFaseJustificativa;
	}

	public void setProximaFaseJustificativa(String proximaFaseJustificativa) {
		this.proximaFaseJustificativa = proximaFaseJustificativa;
	}

	

	public User getProximaFaseLider() {
		return proximaFaseLider;
	}

	public void setProximaFaseLider(User proximaFaseGestor) {
		this.proximaFaseLider = proximaFaseGestor;
	}

	public Integer getProximaFaseCiclo() {
		return proximaFaseCiclo;
	}

	public void setProximaFaseCiclo(Integer proximaFaseCiclo) {
		this.proximaFaseCiclo = proximaFaseCiclo;
	}

	public Fase getFaseAnterior() {
		return faseAnterior;
	}

	public void setFaseAnterior(Fase faseAnterior) {
		this.faseAnterior = faseAnterior;
	}
	
	public OrigemDemanda getOrigemReferencia() {
		return origemReferencia;
	}

	public void setOrigemReferencia(OrigemDemanda origemReferencia) {
		this.origemReferencia = origemReferencia;
	}

	public String getConclusao() {
		return conclusao;
	}

	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}

	public String getProximaFaseUnidadeGestora() {
		return proximaFaseUnidadeGestora;
	}

	public void setProximaFaseUnidadeGestora(String proximaFaseUnidadeGestora) {
		this.proximaFaseUnidadeGestora = proximaFaseUnidadeGestora;
	}

	public String getUnidadeGestora() {
		return unidadeGestora;
	}

	public void setUnidadeGestora(String unidadeGestora) {
		this.unidadeGestora = unidadeGestora;
	}

	
	
}
