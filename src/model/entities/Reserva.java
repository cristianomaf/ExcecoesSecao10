package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numeroQuarto;
	private Date chegada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy)");
	//construtor da classe
	public Reserva() {
		
	}

	public Reserva(Integer numeroQuarto, Date chegada, Date saida) {
		this.numeroQuarto = numeroQuarto;
		this.chegada = chegada;
		this.saida = saida;
	}

	//getters e setters
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getChegada() {
		return chegada;
	}

	public Date getSaida() {
		return saida;
	}

	// nao teremos metodo set para chegada e saida pois nao sera modificado diretamente apenas por meio do metodo atualizaDatas()
	
	public long duracao() {
		//cria uma variavel long
		long diferenca = saida.getTime() - chegada.getTime();  // calcula a diferenca em milisegundos das duas datas
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);  // converte para dias
		
	}
	
	public void atualizaDatas(Date chegada, Date saida) {
		this.chegada = chegada;
		this.saida = saida;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numeroQuarto
				+ " Data chegada : "
				+ sdf.format(chegada)
				+" Data saida : "
				+sdf.format(saida)
				+", "
				+duracao()
				+" noites.";
	}

	
	
	

}
