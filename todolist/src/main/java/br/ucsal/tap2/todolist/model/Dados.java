package br.ucsal.tap2.todolist.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.ucsal.tap2.todolist.cripto.AES;

@Entity
public class Dados {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false)
	private Integer umidade;

	@Column(nullable = false)
	private Double temperatura;

	@Column(name = "radiacao", nullable = false)
	private Integer radiacaoSolar;

	@Column(nullable = false)
	private String data; // dd/mm/aaaa

	@Column(nullable = false)
	private String hora; // mm:ss

	@Column(nullable = false)
	private Integer tempoIrrigacao = 0; // tempo em segundos

	public Dados() {
	}

	public Dados(Integer umidade, Double temperatura, Integer radiacaoSolar, String data, String hora,
			Integer tempoIrrigacao) {
		this.umidade = umidade;
		this.temperatura = temperatura;
		this.radiacaoSolar = radiacaoSolar;
		this.data = data;
		this.hora = hora;
		this.tempoIrrigacao = tempoIrrigacao;
	}

	public Dados(DadosForm form) {
		this.umidade = Integer.parseInt(form.getUmidade());
		this.temperatura = Double.parseDouble(form.getTemperatura());
		this.radiacaoSolar = Integer.parseInt(form.getRadiacaoSolar());
		this.data = form.getData();
		this.hora = form.getHora();
		this.tempoIrrigacao = Integer.parseInt(form.getTempoIrrigacao());
	}

	public Dados(DadosForm form, String secretKey) {
		this.umidade = Integer.parseInt(AES.decrypt(form.getUmidade(), secretKey));
		this.temperatura = Double.parseDouble(AES.decrypt(form.getTemperatura(), secretKey));
		this.radiacaoSolar = Integer.parseInt(AES.decrypt(form.getRadiacaoSolar(), secretKey));

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		this.data = dtf.format(now);
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
		this.hora = dtf2.format(now);
		this.tempoIrrigacao = Integer.parseInt(AES.decrypt(form.getTempoIrrigacao(), secretKey));
	}

	public Integer getUmidade() {
		return umidade;
	}

	public void setUmidade(Integer umidade) {
		this.umidade = umidade;
	}

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public Integer getRadiacaoSolar() {
		return radiacaoSolar;
	}

	public void setRadiacaoSolar(Integer radiacaoSolar) {
		this.radiacaoSolar = radiacaoSolar;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Long getId() {
		return id;
	}

	public Integer getTempoIrrigacao() {
		return tempoIrrigacao;
	}

	public void setTempoIrrigacao(Integer tempoIrrigacao) {
		this.tempoIrrigacao = tempoIrrigacao;
	}

}
