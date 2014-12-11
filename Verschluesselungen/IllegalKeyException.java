package de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen;


@SuppressWarnings("serial")
public class IllegalKeyException extends CrypterException {
	
	private String key;
	
	protected IllegalKeyException(String message) {
		super(message);
	}

	protected IllegalKeyException(String message, String key) {	
		super(message);
		this.key = key;
	}
	
	public String getKey() {
		return this.key;
	}
	
	
}
