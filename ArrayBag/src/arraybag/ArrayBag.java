/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraybag;


/*
 *
 * @author etcharn1
 */
public class ArrayBag<T> implements BagInterface<T> 
{

    public static final int DEFAULT_SIZE = 25;
    private T[] bag;
    private int currentSize;
    
    public ArrayBag()
    {
        this(DEFAULT_SIZE);
    }
    
    public ArrayBag(int initialSize )
    {
        bag = (T[])new Object[initialSize];
        currentSize = 0;
    }
    
    @Override
    public int getCurrentSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean add(T item) {
        boolean added = false;
        if ( currentSize < bag.length )
        {
            bag[currentSize] = item;
            currentSize++;
            added =  true;
        }
        return added;
    }

    @Override
    public T remove() {
        T item = null;
        if ( !isEmpty() )
        {
            item = bag[currentSize - 1];
            bag[currentSize - 1] = null;
            currentSize--;
        }
        return item;
    }

    @Override
    public boolean remove(T item) {
        boolean removed = false;
        int currentIndex = 0;
        while ( !removed && currentIndex < currentSize)
        {
            if ( bag[currentIndex].equals( item ) )
                {
                    removed = true;
                    bag[currentIndex] = remove();
                }
            currentIndex++;
        }
        
        return removed;
    }
    //TODO
    @Override
    public int getFrequencyOf(T item) {
        int frequency = 0;
        int loopCounter = 0;
        int currentIndex = 0;
        
        while((currentIndex < currentSize) && (bag[currentIndex] != null)){
            if(bag[currentIndex].equals(item)){
                frequency++;
            }
            loopCounter++;
            currentIndex++;
        }
        
        return frequency;
    }//end int getFrequencyOf(T item)
    
    
    @Override
    public boolean contains(T item) {
        boolean found = false;
        int currentIndex = 0;
        while (currentIndex < currentSize){
            if ( bag[currentIndex].equals( item ) ){
                    found = true;
            }//end if
            currentIndex++;
        }//end while

        return found;
    }//end boolean contains (T item)

    @Override
    public T[] toArray() {
        //cast is safe because new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[currentSize];
        for(int index = 0; index < currentSize; index++){
            result[index] = bag[index];
        }//end for
        return result;
    }//end T[] toArray()
    
    

}
