package main.java.com.souza.stock;

import java.util.Arrays;

public class List<T> {
    private T[] elements;
    private int size;

    public List(int capacity){
        this.elements = (T[]) new Object[capacity];
        this.size = 0;
    }

    public List () {
        this(10);
    }

    public boolean add(T element) {
        this.expand();
        if(this.size < this.elements.length) {
            this.elements[this.size] = element;
            this.size++;
            return true;
        }
        return false;
    }

    public T searchBy (int position) {
        if(!(position >= 0 && position < this.size)) {
            System.out.println("Invalid position!");
        }
        return this.elements[position];
    }

    public void removeBy(int position) {
        if(!(position >= 0 && position < this.size)) {
            System.out.println("Invalid position!");
        }

        for (int i=position; i<this.size-1; i++){
            this.elements[i] = this.elements[i+1];
        }
        this.size--;
    }

    public void expand() {
        if(this.size == this.elements.length) {
            T[] newElements = (T[]) new Object[this.elements.length * 2];
            for(int i = 0; i < this.elements.length; i++) {
                newElements[i] = this.elements[i];
            }

            this.elements = newElements;
        }
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i=0; i<this.size-1; i++){
            s.append(this.elements[i]);
            s.append(", ");
        }

        if (this.size>0){
            s.append(this.elements[this.size-1]);
        }

        s.append("]");

        return s.toString();
    }
}
