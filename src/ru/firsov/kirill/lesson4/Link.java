package ru.firsov.kirill.lesson4;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 11.10.2018.
 */
public class Link<T> {
    public T data;
    public Link next;
    public Link previous;

    public Link(T d) {
        data = d;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
