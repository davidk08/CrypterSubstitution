package de.hs_mannheim.tpe.uib_10.pflichtuebung4;

import java.util.List;

public class CrypterNull implements Crypter {

	@Override
	public String encrypt(String message) throws CrypterException {
		return message;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		return messages;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		return cypherText;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		return cypherTexte;
	}

}
