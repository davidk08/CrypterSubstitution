package de.hs_mannheim.tpe.uib_10.pflichtuebung4.Iteration;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen.Crypter;
import de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen.CrypterException;

public class IterableCrypter implements Iterable<String> {

	private List<String> list;
	private Crypter crypt;


	public IterableCrypter(List<String> liste, Crypter cryptIn) throws CrypterException {
		this.list = liste;
		this.crypt = cryptIn;
	}

	public IterableCrypter(Iterable<String> iterableCrypt, Crypter cryptIn) throws CrypterException {
			list = new LinkedList<String>();
            for (String str : iterableCrypt) {
                list.add(str);
            }
            this.crypt = cryptIn;
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
					return crypt.encrypt(list.get(pos++));
				}
				catch (CrypterException e) {
					System.out.println(e.getMessage());
				}
				return null;

			}};
	}
}