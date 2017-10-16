package ArrayBag;


/**
 *
 * @author casgu
 */
public interface BagInterface<T> {
    public int getCurrentSize();
    
    public boolean add();
    public boolean add(T item);
    
    public boolean isEmpty();
    
    public T remove();
    public boolean remove(T item);
    
    public int getFrequencyOf(T item);
    public boolean contains(T item);
    public T[] toArray();
}
