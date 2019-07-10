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
			
			// verificar os casos que nao podemos atualizar fazendo isso direto no programa principal o que é solucao muito ruim
			Date agora = new Date(); //criamos uma data nova que recebe a data Atual.
			
			if(chegada.before(agora) || saida.before(agora)) { //se as datas de chegada ou de saida forem anteriores a data atual nao alteramos a data e imprime o erro
			System.out.println("Erro na reserva: Data inferiores a data atual");	
			}else if(!saida.after(chegada)) {
				System.out.println("Erro na reserva : Data da saida antes da data de chegada ");			
			}else
				reserva1.atualizaDatas(chegada, saida); // chama o metodo que atualiza datas
				
				System.out.println("Reserva: " +reserva1);
				
			}
			
			
		scan.close();
		}	
		
	}

