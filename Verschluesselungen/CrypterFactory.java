package de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen;


public class CrypterFactory {
	

	public static Crypter createCrypter(String key, Verschluesselung crypt) 
			throws CrypterException {

		switch(crypt) {

		case CAESAR: if(key.length() != 1 || (key.charAt(0) < 'A' || key.charAt(0) > 'Z')) {
			throw new IllegalKeyException("Ungültiger Schlüssel: ", key);
		}
		else{ 
			return new CrypterCaesar(key); 
		}

		case SUBSTITUTION: if(key.length() != 26) {
			throw new IllegalKeyException("Ungültiger Schlüssel: ", key);
		}
		else { 
			for (int i = 0; i < key.length(); i++) {

				if (key.charAt(i) < 'A' || key.charAt(i) > 'Z') {
					throw new IllegalKeyException("Ungültiger Schlüssel: ", key);
				}
			}
			return new CrypterSubstitution(key);
		}

		case XOR: 
			for (int i = 0; i < key.length(); i++) {
				if (key.charAt(i) < 'A' || key.charAt(i) > 'Z') {
					throw new IllegalKeyException("Ungültiger Schlüssel: ", key);
				}
			}
			return new CrypterXOR(key);

		case NULL: return new CrypterNull();

		case REVERSE: 
			for (int i = 0; i < key.length(); i++) {
				if (key.charAt(i) < 'A' || key.charAt(i) > 'Z') {
					throw new IllegalKeyException("Ungültiger Schlüssel: ", key);
				}
			}
			return new CrypterReverse();

		default: throw new CrypterException("Verschluesselung fehlerhaft"); 

		}

	}	
}


