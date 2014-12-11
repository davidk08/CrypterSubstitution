package de.hs_mannheim.tpe.uib_10.pflichtuebung4.Verschluesselungen;

import java.util.List;

/**
 * Grundlegendes Interface, um Verschluesselung durchzufuehren. Mit
 * Hilfe dieses Interfaces kann man Nachrichten verschluesseln ( ̈uber die
 * {@link #encrypt(String)} Methode) und wieder entschluesseln ( ̈uber die
 * {@link #decrypt(String)} Methode).
 *
 * Der Eingabetext ({@literal message}) darf nur aus den Groß-Buchstaben A-Z
 * bestehen. Kleinbuchstaben werden in Großbuchstaben umgewandelt, alle anderen
 * Zeichen werden ohne Rueckmeldung entfernt (einschließlich der Leerzeichen). *
 * Zwischen den beiden Methoden muss bei gleichem Schluessel {@code key} * folgendes gelten:
 * {@code text.equals(decrypt(encrypt(text)) == true}.
 *
 * @author Thomas Smits
 */
public interface Crypter {
	/**
	 * Verschluesselt den gegebenen Text mit dem angegebenen Schluessel. *
	 * @param message Nachricht, die Verschluesselt werden soll. *
	 * @return verschlueusselter Text.
	 * @throws CrypterException Wird geworfen, wenn Probleme mit der
	 * Verschluesselung auftreten. */
	public String encrypt(String message)
			throws CrypterException;
	
	/**
	 * Verschluesselt den gegebenen Text mit dem angegebenen Schluessel. *
	 * @param messages Nachrichten, die Verschluesselt werden soll. *
	 * @return verschluesselte Texte.
	 * @throws CrypterException Wird geworfen, wenn Probleme mit der
	 * Verschluesselung auftreten. */
	public List<String> encrypt(List<String> messages)
			throws CrypterException;
	/**
	 * Entschluesselt den gegebenen Text mit dem angegebenen Schluessel. *
	 * @param cypherText Nachricht, die entschluesselt werden soll. *
	 * @return entschluesselter Text.
	 * @throws CrypterException Wird geworfen, wenn Probleme mit der
	 * Verschluesselung auftreten. */
	public String decrypt(String cypherText)
			throws CrypterException;
	/**
	 * Entschluesselt den gegebenen Text mit dem angegebenen Schluessel. *
	 * @param cypherTexte Nachrichten, die entschluesselt werden soll. *
	 * @return entschluesselte Texte.
	 * @throws CrypterException Wird geworfen, wenn Probleme mit der
	 * Verschluesselung auftreten. */
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException;
}