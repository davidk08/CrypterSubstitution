package de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementierung der Caesar-Verschlüsselungsmethoden die Klasse CrypterCaesar
 * erbt die Interfaces der Klasse Crypter und implementiert diese in der CaesarKlasse
 * 
 * @author davidkiefer
 *
 */
public class CrypterCaesar implements Crypter {
	private String key;

	/**
	 * Konstruktor, um Key, der dem Crypter übergeben wird, zu initialisieren
	 * 
	 * @param key
	 */
	public CrypterCaesar(String key) {
		this.key = key;
	}

	/**
	 * Methode, die für eine übergebene Nachricht die Verschiebungszahl erzeugt
	 * und eine Ausnahme des Typs "CrypterException" wirft die Rückgabe wird mit
	 * der Nachricht und der Verschiebungsziffer an eine private Methode
	 * übergeben
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		int verschiebung = (int) (this.key.charAt(0) - 64);
		return enrypt(message, verschiebung);
	}

	/**
	 * eine private Methode, die nur innerhalb der Klasse sichtbar ist und
	 * 
	 * nun die einzelnen Zeichen des übergebenen Wortes abarbeitet und um die
	 * Anzahl der Verschiebungsziffer verschiebt die Verschlüsselungsnachricht
	 * wird erzeugt
	 * 
	 * @param message
	 * @param verschiebung
	 * @return
	 */
	private String enrypt(String message, int verschiebung) {
		message = message.toUpperCase();
		String result = "";
		for (int i = 0; i < message.length() - 1; i++) {
			result += (char) ((message.charAt(i) - 'A' + verschiebung) % 26 + 'A');
		}
		return result;
	}

	/**
 * enrypt Methode, die eine generische Klasse des Typs String benutzt und 
 * die verschlüsselten Nachrichten in einer verketteten Liste speichert
 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> result = new LinkedList<String>();
		for (String message : messages) {
			result.add(encrypt(message));
		}
		return result;
	}

	/**
	 * Methode zur Entschlüsselung einer verschlüsselten Nachricht Verschiebung
	 * nun mit negativen Vorzeichen, da Ziffern rückwärts entziffern werden
	 * müssen
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		int verschiebung = (int) this.key.charAt(0) - 64;
		return decrypt(cypherText, -verschiebung);
	}

	/**
	 * Methode decrypt wird an private Methode übergeben mit Verschiebungswert
	 * und nun entschlüsselt zurückgegeben
	 * 
	 * @param cypherText
	 * @param verschiebung
	 * @return
	 */
	private String decrypt(String cypherText, int verschiebung) {
		String result = "";
		for (int i = 0; i < cypherText.length(); i++) {
			char a = (char) ((cypherText.charAt(0) - 'A' + verschiebung) % 26 + 'A');
			if (a < 65) {
				result += (char) (a + 26);

			} else {
				result += (char) a;
			}
		}
		return result;
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
