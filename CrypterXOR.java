package de.hs_mannheim.tpe.uib_10.pflichtuebung4;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class CrypterXOR implements Crypter {

	private String key;

	public CrypterXOR(String key) {
		this.key = key;
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		message = message.toUpperCase();
		key = key.toUpperCase();
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < message.length(); i++) {
			result.append(add(message.charAt(i), key.charAt((i % key.length()))));
		}
		return result.toString();
	}

	private char add(char message, char key) {
		int a = charToValue(message);
		int b = charToValue(key);

		String aBin = Integer.toBinaryString(a);
		String bBin = Integer.toBinaryString(b);
		while(aBin.length() < 5) {
			aBin = "0" + aBin;
		}
		
		while(bBin.length() < 5) {
			bBin = "0" + bBin;
		}

		StringBuffer result = new StringBuffer();
		for(int i = 0; i < 5; i++) {
			if(aBin.charAt(i) == bBin.charAt(i)) {
				result.append("0");
				
			}
			else{
				result.append("1");
			}
		}
		int dezValue = Integer.parseInt(result.toString(), 2);
		char[] zeichen = {'@', 'A','B','C','D','E','F','G','H','I','J','K','L',
				'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z', 
				'[', '\\',']','^','_'};
		return zeichen[dezValue];
	}

	private int charToValue(char a) {

		String alphabet = ("@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_");
		for(int i = 0; i < alphabet.length(); i++) {
			if(a == alphabet.charAt(i)) {
				return (i);
			}
		}
		return 0;
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
		return encrypt(cypherText);
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
