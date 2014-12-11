package de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CrypterCaesar implements Crypter {

	private String key;

	protected CrypterCaesar(String key) {
		this.key = key;

	}

	@Override
	public String encrypt(String message) throws CrypterException {
		int verschiebung = ((int)this.key.charAt(0))-64;
		return encrypt(message, verschiebung);
	}

	private String encrypt(String message, int verschiebung) throws CrypterException {
		
		message = message.toUpperCase();
		String result = "";
		for(int i = 0; i < message.length(); i++) {
			result += (char)((message.charAt(i) - 'A' + verschiebung) % 26 + 'A');
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
		int verschiebung = ((int)this.key.charAt(0))-64;
		return decrypt(cypherText, -verschiebung);
	}

	private String decrypt(String message, int verschiebung) throws CrypterException {
	
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) < 'A' || message.charAt(i) > 'Z') {
				throw new CrypterException("Entschluesselung nicht möglich");
			}
		}
		String result = "";
		for(int i = 0; i < message.length(); i++) {

			char a =(char)((message.charAt(i) - 'A'+ verschiebung) % 26 + 'A') ;
			if(a < 65) {
				result += (char)(a+26);
			}
			else { result += (char)a;
			}
		}
		return result;

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
