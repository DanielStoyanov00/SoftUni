package _01JarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private Deque<T> deque;

    public Jar(){
        this.deque = new ArrayDeque<>();
    }

    public void add(T element){
        this.deque.push(element);
    }

    public T remove(){
        return this.deque.pop();
    }


}
