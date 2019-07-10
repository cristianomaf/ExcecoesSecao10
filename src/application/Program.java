package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException { //propaga a exececao para o programa 
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // formatacao de datas
		
		System.out.print("Numero do Quarto: ");
		int numeroQuarto = scan.nextInt();
		
		System.out.print("Data de chegada: ");
		Date chegada = sdf.parse(scan.next());  //tratar a exececao ou propagar a excecao utilizando a clausula throws
		System.out.print("Data Saida: ");
		Date saida = sdf.parse(scan.next());
		
		//solucao muito ruim pois insere as verificacoes dentro do programa principal sem tratas excecoes
		
		// validaçao na hora de criar o objeto continua no programa principal pois nao temos como fazer isso com o contrutor da classe
		if(!saida.after(chegada)) { // verifica se saida é depois da chegada
			System.out.println("Erro na reserva : Data da saida antes da data de chegada ");
		}else {
			Reserva reserva1 = new Reserva(numeroQuarto, chegada, saida); // instancia a reserga
			System.out.println("Reserva "+ reserva1);
			
			System.out.println();
			// ATUALIZACAO DA RESERVA
		
			System.out.println("Entre com a data pra atualizar a reserva ");
			System.out.print("nova Data de chegada : ");
			chegada = sdf.parse(scan.next());  
			System.out.print("nova Data de Saida: ");
			saida = sdf.parse(scan.next());
			
			//mudanca aqui ao chamar o metodo atualizaDatas que agora retorna String armazenamos a string em uma String erro criada aqui
			String erro = reserva1.atualizaDatas(chegada, saida); // chama o metodo que atualiza datas
			if (erro != null){	 //caso erro seja diferente de vazio isso quer dizer que recebeu uma mensagem de erro na validacao
				System.out.println("Erro na atualização de reservas: " + erro);
			}else {	// caso nao tenha erro mostramos a reserva atualizada
			System.out.println("Reserva: " +reserva1);
			}
				
			}
			
			
		scan.close();
		}	
		
	}

