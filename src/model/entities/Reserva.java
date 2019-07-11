package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	private Integer numeroQuarto;
	private Date chegada;
	private Date saida;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy)");

	// construtor da classe
	public Reserva() {

	}
	// aqui no contrutor tambem teremos uma excecao possivel
	public Reserva(Integer numeroQuarto, Date chegada, Date saida) throws DomainException {
		if (!saida.after(chegada)) {
			throw new DomainException("Erro na reserva : Data da saida antes da data de chegada ");
		}
		
		this.numeroQuarto = numeroQuarto;
		this.chegada = chegada;
		this.saida = saida;
	}

	// getters e setters
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

	// nao teremos metodo set para chegada e saida pois nao sera modificado
	// diretamente apenas por meio do metodo atualizaDatas()

	public long duracao() {
		// cria uma variavel long
		long diferenca = saida.getTime() - chegada.getTime(); // calcula a diferenca em milisegundos das duas datas
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS); // converte para dias

	}

	public void atualizaDatas(Date chegada, Date saida) throws DomainException { // propagando a excecao
		Date agora = new Date(); // criamos uma data nova que recebe a data Atual.

		if (chegada.before(agora) || saida.before(agora)) { // se as datas de chegada ou de saida forem anteriores a
															// data atual nao alteramos a data  e lancamos uma excecao
			throw new DomainException("Erro na reserva: Data inferiores a data atual");   // instancia uma excecao
		}
		if (!saida.after(chegada)) {
			throw new DomainException("Erro na reserva : Data da saida antes da data de chegada ");
		}
		this.chegada = chegada;
		this.saida = saida;		
	}

	@Override
	public String toString() {
		return "Quarto " + numeroQuarto + " Data chegada : " + sdf.format(chegada) + " Data saida : "
				+ sdf.format(saida) + ", " + duracao() + " noites.";
	}

}
