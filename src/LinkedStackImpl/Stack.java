package LinkedStackImpl;

import java.util.EmptyStackException;

public interface Stack<T> {
    boolean isEmpty();
    void push(T element);
    T pop() throws EmptyStackException;
}
