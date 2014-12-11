package de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen;

@SuppressWarnings("serial")
public class CrypterException extends Exception {

	private String message;

	
	protected CrypterException(String message) {
		this.message = message;
	}


	public String getMessage() {
		return this.message;
	}

}	