package br.com.andreia.apistock.exception;

public class NegException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public NegException (String message) {
		super(message);
	}
}


