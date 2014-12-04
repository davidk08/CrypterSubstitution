package de.hs_mannheim.tpe.uib_10.pflichtuebung4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CrypterCaesar implements Crypter {
	
	private String key;
	
	public CrypterCaesar(String key) {
		this.key = key;
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		int verschiebung = ((int)this.key.charAt(0))-64;
		return encrypt(message, verschiebung);
	}
	
	private String encrypt(String message, int verschiebung) {
		message = message.toUpperCase();
		String result = "";
		for(int i = 0; i < message.length(); i++) {
			result += (char)((message.charAt(i) - 65 + verschiebung) % 26 + 65);
		}
		return result;
	}
 
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> result = new LinkedList<String>(); 
		for(String message: messages) {
			result.add(encrypt(message));
		}
		return result;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		int verschiebung = ((int)this.key.charAt(0)-64)*(-1);
		return encrypt(cypherText, verschiebung);
	}


	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		List<String> result = new LinkedList<String>();
		for(String text: cypherTexte){
			result.add(decrypt(text));
		}
		return result;
	}

}
