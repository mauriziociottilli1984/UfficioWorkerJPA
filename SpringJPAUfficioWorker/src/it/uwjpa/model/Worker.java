package it.uwjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "worker")
public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "eta")
	private int eta;
	@Column(name = "isJunior")
	private boolean isJunior;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ufficio_id", nullable = false)
	private Ufficio ufficio;

	public Worker() {

	}

	public Worker(String nome, String cognome, int eta) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.isJunior = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public boolean getJunior(){
		return this.isJunior;
	}

	public void setJunior(boolean isJunior) {
		this.isJunior = isJunior;
	}

	public Ufficio getUfficio() {
		return this.ufficio;
	}

	public void setUfficio(Ufficio ufficio) {
		this.ufficio = ufficio;
	}

	@Override
	public String toString() {
		return "Worker [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", isJunior="
				+ isJunior + ", ufficio=" + ufficio + "]";
	}

}
