
package stacks;

/**
 *
 * @author casgu
 */
public interface StacksInterface<T> {
    T pop() throws Exception;
    T peek() throws Exception;
    void push(T item);
    boolean isEmpty();
    void clear();
    
}
