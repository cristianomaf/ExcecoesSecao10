package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numeroQuarto;
	private Date chegada;
	private Date saida;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy)");

	// construtor da classe
	public Reserva() {

	}

	public Reserva(Integer numeroQuarto, Date chegada, Date saida) {
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

	public String atualizaDatas(Date chegada, Date saida) { // metodo agora retorna uma string

		// **** alteração 1 solucao ruim ainda mas passando a validacao para dentro do
		// metodo de atualizacao de datas tirando do programa principal

		Date agora = new Date(); // criamos uma data nova que recebe a data Atual.

		if (chegada.before(agora) || saida.before(agora)) { // se as datas de chegada ou de saida forem anteriores a
															// data atual nao alteramos a data e imprime o erro
			return "Erro na reserva: Data inferiores a data atual"; // ***return corta o metodo caso passe por aqui
		}
		if (!saida.after(chegada)) {
			return "Erro na reserva : Data da saida antes da data de chegada ";
		}
		// caso nao tiver nenhum erro o metodo atualiza os dados de chegada e saida e
		// retorna null para String indicando que não ocorreu erros.

		this.chegada = chegada;
		this.saida = saida;

		return null;
	}

	@Override
	public String toString() {
		return "Quarto " + numeroQuarto + " Data chegada : " + sdf.format(chegada) + " Data saida : "
				+ sdf.format(saida) + ", " + duracao() + " noites.";
	}

}
