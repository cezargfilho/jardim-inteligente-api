package br.ucsal.tap2.todolist.model;

public class DadosForm {

	private Integer umidade;

	private Double temperatura;

	private Integer radiacaoSolar;

	private String data; // dd/mm/aaaa

	private String hora; // hh:mm

	private Integer tempoIrrigacao; // tempo em segundos

	public Integer getUmidade() {
		return umidade;
	}

	public Double getTemperatura() {
		return temperatura;
	}

	public Integer getRadiacaoSolar() {
		return radiacaoSolar;
	}

	public String getData() {
		return data;
	}

	public String getHora() {
		return hora;
	}

	public Integer getTempoIrrigacao() {
		return tempoIrrigacao;
	}

}
