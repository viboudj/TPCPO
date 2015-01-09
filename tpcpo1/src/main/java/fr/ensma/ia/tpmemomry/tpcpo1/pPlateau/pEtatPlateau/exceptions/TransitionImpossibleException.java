package fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.exceptions;

public class TransitionImpossibleException extends RuntimeException {
	
	private String message;
	
	public TransitionImpossibleException(){
		super();
		message = "error";
	}
	
	public TransitionImpossibleException(String mess) {
		message = mess;
	}
	
	@Override
	public String getMessage() {
		return message + " : " + super.getMessage();
	}

	private static final long serialVersionUID = 1L;
	
}
