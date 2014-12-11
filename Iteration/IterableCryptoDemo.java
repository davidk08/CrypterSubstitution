package de.hs_mannheim.tpe.uib_10.pflichtuebung4.Iteration;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen.Crypter;
import de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen.CrypterException;
import de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen.CrypterFactory;
import de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen.Verschluesselung;

public class IterableCryptoDemo {

	public static void main(String[] args) throws CrypterException {

		Crypter caesar = CrypterFactory.createCrypter("U", Verschluesselung.CAESAR);
		Crypter xor = CrypterFactory.createCrypter("TPEISTCOOL", Verschluesselung.XOR);

		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");

		IterableCrypter iterableCrypter = new IterableCrypter(
				new IterableCrypter(liste, caesar),
				xor);
	
					
		for (String cypherText : iterableCrypter) {
			System.out.println(cypherText);
		} 
		System.out.println("------------------------------------------------");
		
		List<String> liste2 = Arrays.asList("MT_G", "P^J", "NTL", "[JKF");
		
		IterableDecrypter iterableDecrypter = new IterableDecrypter(
				new IterableDecrypter(liste2, xor),
				caesar);
		
		for(String message : iterableDecrypter) {
			System.out.println(message);
		}
	}
}



