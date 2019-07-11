package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) { 
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // formatacao de datas

		
		//Programa com excecoes tratadas
		try {	
		System.out.print("Numero do Quarto: ");
		int numeroQuarto = scan.nextInt();

		System.out.print("Data de chegada: ");
		Date chegada = sdf.parse(scan.next()); // tratar a exececao 
		System.out.print("Data Saida: ");
		Date saida = sdf.parse(scan.next());

		Reserva reserva1 = new Reserva(numeroQuarto, chegada, saida); // instancia a reserga
		System.out.println("Reserva " + reserva1);

		System.out.println();
		// ATUALIZACAO DA RESERVA

		System.out.println("Entre com a data pra atualizar a reserva ");
		System.out.print("nova Data de chegada : ");
		chegada = sdf.parse(scan.next());
		System.out.print("nova Data de Saida: ");
		saida = sdf.parse(scan.next());

		reserva1.atualizaDatas(chegada, saida);
		System.out.println("Reserva: " + reserva1);
		}
		// primeira excecao ParseException 
		catch(ParseException e){
			System.out.println("Formato de data invalido"); // caso digitem uma data que nao se enquadre no formato criado na linha 14
		}
		//catch(IllegalArgumentException e) { // captura a excecao criada para metodo atualiza datas
		//	System.out.println("Erro na reserva: "+ e.getMessage());  illegal Argument Excepetion é do proprio Java 
		//}
		
		//criando uma excecao personalizada
		catch(DomainException e) {
			System.out.println(e.getMessage());
			
		}
		//capturar erros de outras excecoes quaisquer
		catch(RuntimeException e) {
			System.out.println("Erro inesperado exceção generica RuntimeExcepetion");
		}
		
		
		scan.close();
	}

}
