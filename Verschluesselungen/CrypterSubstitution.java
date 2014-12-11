package de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CrypterSubstitution implements Crypter {

	private String key;

	protected CrypterSubstitution(String key) {
		this.key = key;
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) < 'A' || message.charAt(i) > 'Z') {
				throw new CrypterException("Verschluesselung nicht möglich");
			}
		}
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < message.length(); i++) {

			result.append(key.charAt((int)(message.charAt(i)-65))); 
		}
		return result.toString();
	}


	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> result = new LinkedList<String>();
		for(String text : messages) {
			result.add(encrypt(text));
		}
		return result;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {

		for(int i = 0; i < cypherText.length(); i++) {
			if(cypherText.charAt(i) < 'A' || cypherText.charAt(i) > 'Z') {
				throw new CrypterException("Entschluesselung nicht möglich");
			}
		}
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer result = new StringBuffer();
		for(int j = 0; j < cypherText.length(); j++) {
			char s = (cypherText.charAt(j));
			result.append(alphabet.charAt(entschluesseln(s)));		
		}
		return result.toString();
	}

	private int entschluesseln(char gesucht) {
		for(int j = 0; j < key.length(); j++) {
			if(gesucht == key.charAt(j)) {
				return j;
			}
		}
		return 0;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		List<String> result = new LinkedList<String>();
		for(String text : cypherTexte) {
			result.add(decrypt(text));
		}
		return result;
	}

}
