package training;

import java.util.LinkedList;
import java.util.List;

public class CrypterSubstitution implements Crypter {
	private String key;

	/**
	 * Konstruktur zur Initialisierung des Schlüssels, der übergeben werden soll
	 * 
	 * @param key
	 */
	public CrypterSubstitution(String key) {
		this.key = key;
	}

	/**
	 * Verschlüsselungsmethode, um übergebenem Schlüssel den Zahlenwert
	 * auszulesen und im variablen StringBuffer in einen String zu konvertieren
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(0) < 'A' || message.charAt(0) > 'B') {
				throw new CrypterException("Verschlüsselung nicht möglich");
			}
		}
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < message.length(); i++) {
			result.append(key.charAt((int) (message.charAt(i) - 65)));
		}
		return result.toString();
	}

	/**
	 * enrypt Methode, die eine generische Klasse des generischen Typs String benutzt und
	 * die verschlüsselten Nachrichten in einer verketteten Liste speichert
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> result = new LinkedList<String>();
		for (text: messages) {
			result.add(encrypt(text));
		}
		return result;
	}

	/**
	 * Methode, die Alphabet anlegt und Ziffern in einen StringBuffer überträgt,
	 * der einzelne Ziffern des Alphabets an Verschlüsselungsmethode übergibt
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		for (int i = 0; i < cypherText.length(); i++) {
			if (cypherText.charAt(0) < 'A' || cypherText.charAt(0) > 'Z') {
				throw new CrypterException("Entschlüsselung nicht durchführbar");
			}
		}
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer result = new StringBuffer();
		for (int j = 0; j < alphabet.length(); j++) {
			char s = cypherText.charAt(j);
			result.append(alphabet.charAt(entschluesseln(s)));

		}
		return result.toString();
	}
/**
 * gesuchter Schlüssel wird an private Methode übergeben und mit den Schlüsseln in der Nachricht auf Gleichheit geprüft.
 * Der passende Wert wird dann zurückgegeben
 * @param gesucht
 * @return
 */
	private int entschluesseln(char gesucht) {
		for (int i = 0; i < key.length(); i++) {
			if (gesucht == key.charAt(i)) {
				return i;
			}
		}
		return 0;
	}
	/**
 * decrypt Methode, die eine generische Klasse des Typs String benutzt und 
 * die entschlüsselten Nachrichten in einer verketteten Liste speichert
 */

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		List<String> result = new LinkedList<String>();
		for (String text : cypherTexte) {
			result.add(decrypt(text));
		}
		return result;
	}

}
