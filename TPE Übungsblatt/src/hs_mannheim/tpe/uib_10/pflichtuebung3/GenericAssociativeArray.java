package hs_mannheim.tpe.uib_10.pflichtuebung3;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * Generische Klagsse um ein typsicherers assoziatives Array zu erstellen.
 * Die Klasse arbeitet auf einem Objekt des Typs BinaryTree.
 * Die Klasse implementiert das Interface AssociativeArray.
 * 
 **/
public class GenericAssociativeArray<S, T> implements AssociativeArray<S, T>{

	BinaryTree<S, T> tree;

	/**
	 * Konstruktor zur Erstellung eines neuen binaeren Baums.
	 */
	public GenericAssociativeArray() {

		this.tree = new BinaryTree<S, T>();

	}
	
	/**
	 * Methode zur Leerung des assoziativen Arrays.
	 */
	public void clear() {
		this.tree.clear();
	}

	/**
	 * Ueberprueft ob der uebergebene Wert im assoziativen Array vorkommt.
	 * Liefert True falls dies der Fall ist, false falls nicht.
	 * 
	 * @return das Ergebnis als Wahrheitswert: true falls enthalten, false wenn nicht
	 */
	public boolean containsValue(T value) {
		return this.tree.containsValue(value);

	}

	/**
	 * Ueberprueft, ob der uebergebene Schluessel im assoziativen Array vorkommt.
	 * Liefert True falls dies der Fall ist, false falls nicht.
	 * 
	 * @return as Ergebnis als Wahrheitswert: true falls enthalten, false wenn nicht
	 */
	public boolean containsKey(S key) {
		return this.tree.containsKey(key);
	}

	/**
	 * Gibt den passenden Wert zu einem uebergebenen Schluessel zurueck.
	 * 
	 * @return der passende Wert zum uebergebenen Schluessel
	 */
	public T get(S key) {
		return this.tree.get(key);
	}

	/**
	 * Ueberprueft, ob das assoziative Array leer ist.
	 * 
	 * @return true falls leer, false falls Objekte im Array vorhanden
	 */
	public boolean isEmpty() {
		return this.tree.isEmpty();
	}

	/**
	 * Speichert den uebergebenen Schluessel und Wert im assoziativen Array.
	 */
	public void put(S key, T value) {
		this.tree.add(key, value);
	}

	/**
	 * Fuegt alle Schluessel-Wert Paare des uebergebenen assoziativen Array zum
	 * aktuellen assoziativen Array hinzu.
	 */
	public void putAll(AssociativeArray<S, T> array) {
		BiConsumer<S, T> consumer = (key, val) -> this.put(key, val);
		array.forEach(consumer);
	}

	/**
	 * Entfernt das Schluessel-Wert Paar des uebergebenen Schluessels aus dem
	 * assoziativen Array und liefert den Wert zurueck
	 * 
	 * @return der Wert des geloeschten Paares
	 */
	public T remove(S key) {
		return this.tree.remove(key);
	}

	/**
	 * Gibt die Anzahl der Schluessel-Wert Paare zurueck.
	 */
	public int size() {
		return this.tree.size();
	}

	/**
	 * Aktualisiert den Wert des uebergebenen Schluessels mit dem uebergebenen
	 * Wert.
	 */
	public void update(S key, T value) {
		this.tree.update(key, value);

	}

	/**
	 * Fuehrt den uebergebenen BiComsumer fuer alle Schluessel-Wert Paare
	 * des assoziativen Arrays aus.
	 */
	public void forEach(BiConsumer<S, T> consumer) {
		this.tree.forEach(consumer);

	}
	/** 
	 * Methode um alle Schluessel-Wert Paare des aktuellen Arrays
	 * an das uebergebene Array hinzuzufuegen.
	 * 
	 * @param array Array zu dem die Paare hinzugefuegt werden
	 * */
	public void extractAll(AssociativeArray<S, T> array) {
		array.putAll(this);		
	}
	/**
	 * Methode, die die uebergebene BiFunction für alle Schlüssel-Wert-Paare des 
	 * assoziativen Arrays ausfuehrt und damit ein neues assoziatives Array erzeugt, 
	 * welches die veraenderten Werte auf die alten Schluessel abbildet.
	 * 
	 * @param die uebergebene generische BiFunction
	 * @return das neue assoziative Array
	 * */
	public AssociativeArray<S, T> map(
			BiFunction<S, T, T> function) {
		AssociativeArray<S,T> array = new GenericAssociativeArray<S,T>();
		BiConsumer<S,T> consumer = (key,value) -> array.put(key, function.apply(key, value));
		this.forEach(consumer);
		return array;

	}

	/**
	 * Prueft, ob zwei assoziative Arrays gleich sind. Gibt true zurueck,
	 * falls dies der Fall ist, false falls nicht.
	 * 
	 * @return true falls gleich, false falls verschieden
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericAssociativeArray <S,T> array = (GenericAssociativeArray<S,T>) obj;

		return this.tree.equals(array.tree);
	}

	private int hash = 1;
	
	/**
	 * Methode den Hashwert eines Objektes zu erzeugen.
	 * 
	 * @return der Hashwert
	 * */
	@Override
	public int hashCode() {
		this.hash = 1;
		BiConsumer<S,T> consumer = (key, value) -> (this.hash+=key.hashCode() + 2*value.hashCode());
		forEach(consumer);
		return hash;
	}

	/**
	 * Methode um ein assoziatives Array als String auszugeben.
	 * 
	 * return das assoziative Array als String
	 **/
	@Override
	public String toString() {
		final StringBuffer result = new StringBuffer("{");
		BiConsumer<S,T> consumer = (key, value) -> (result.append(key.toString() + "=" + value.toString() + ", "));
		forEach(consumer);
		result.delete(result.length()-2, result.length());
		result.append("}");
		return result.toString();
	}

}