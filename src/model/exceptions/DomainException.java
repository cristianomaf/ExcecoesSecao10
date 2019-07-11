package model.exceptions;
//excecao personalizada ela pode ser uma extensao da Exception ou da Runtime Excpetion
//Runtime nao obriga tratamento a Excepetion sim
public class DomainException extends Exception {
	private static final long serialVersionUID = 1L; //classe serializable precisa ter versao
	
	//contrutor da excecao
	public DomainException(String msg) {
		super(msg);
	}
	

}
