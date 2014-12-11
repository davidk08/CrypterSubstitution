package de.hs_mannheim.tpe.uib_10.pflichtuebung4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen.Crypter;
import de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen.CrypterException;
import de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen.CrypterFactory;

public class IterableCrypter implements Iterable<String> {

	private List<String> list;
	private Crypter cryptIn;
	private Crypter cryptOut;
	private IterableCrypter iterableCrypt;

	public IterableCrypter(List<String> liste, Crypter cryptIn) throws CrypterException {
		this.list = liste;
		this.cryptIn = cryptIn;
	}

	public IterableCrypter(IterableCrypter iterableCrypt, Crypter cryptOut) throws CrypterException {
		this.iterableCrypt = iterableCrypt;
		this.cryptOut = cryptOut;
	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			private int pos = 0;

			@Override
			public boolean hasNext() {
				return (pos < list.size());
			}

			@Override
			public String next() {
				try {
					return iterableCrypt.cryptOut.encrypt(cryptIn.encrypt(list.get(pos++)));
					

				}
				catch (CrypterException e) {
					System.out.println(e.getMessage());
				}
				return null;

			}};
	}










	public List<String> encrypt(List<String> list, Crypter crypt) throws CrypterException {

		List<String> result = new LinkedList<String>();
		for(String text: list){
			result.add(crypt.encrypt(text));
		}
		return result;
	}

	public IterableCrypter getCrypter(List<String> list) throws CrypterException {
		return new IterableCrypter(list, cryptOut);
	}



}
