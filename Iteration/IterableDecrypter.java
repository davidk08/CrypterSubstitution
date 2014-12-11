package de.hs_mannheim.tpe.uib_10.pflichtuebung4.Iteration;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen.Crypter;
import de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen.CrypterException;


public class IterableDecrypter implements Iterable<String> {

	private List<String> list;
	private Crypter crypt;


	public IterableDecrypter(List<String> liste, Crypter crypt) throws CrypterException {
		this.list = liste;
		this.crypt = crypt;
	}

	public IterableDecrypter(Iterable<String> iterableCrypt, Crypter crypt) throws CrypterException {
			list = new LinkedList<String>();
            for (String text : iterableCrypt) {
                list.add(text);
            }
            this.crypt = crypt;
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
					return crypt.decrypt(list.get(pos++));
				}
				catch (CrypterException e) {
					System.out.println(e.getMessage());
				}
				return null;

			}};
	}
}
