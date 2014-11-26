package hs_mannheim.tpe.uib_10.pflichtuebung3;
/** 
 * Interface fuer die Methoden (hier noch abstrakt) des typsicheren Assozitiven Arrays.
 * 
 * */
import java.util.function.*;

public interface AssociativeArray<S, T> {

	public void clear();
	public boolean containsValue(T value);
	public boolean containsKey(S key);
	public T get(S key);
	public boolean isEmpty();
	public void put(S key, T value);
	public void putAll(AssociativeArray<S, T> array);
	public T remove(S key);
	public int size();
	public void update(S key, T value);
	public void forEach(BiConsumer<S, T> consumer);
	public void extractAll(AssociativeArray<S, T> array);
	public AssociativeArray<S, T> map(BiFunction<S, T, T > function);
	

}