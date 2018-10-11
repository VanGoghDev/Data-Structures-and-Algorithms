package ru.firsov.kirill.lesson4;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 11.10.2018.
 */
public class DoublyLink<T> {

    public class Link {
        public T data;
        public int key;
        public Link next;
        public Link previous;
        public Link(int key, T data) { this.data = data; this.key = key;}
        @Override
        public String toString() { return data.toString(); }

    }

    private Link first;
    private Link last;

    public DoublyLink() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int key, T data) {
        Link newLink = new Link(key, data);
        if (isEmpty()) {
            last = newLink;
        } else first.previous = newLink;
        newLink.next = first;
        first = newLink;
    }

    public boolean insertAfter(int key, T data) {
        Link current = first;
        while (current.key != key) {
            current = current.next;
            if (current == null) return false;
        }
        Link newLink = new Link(key, data);
        if (current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }

    public boolean insertLast(int key, T data) {
        Link newLink = new Link(key, data);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
        return true;
    }

    public Link deleteFirst() {
        Link temp = first;
        if (first.next == null) last = null;
        else
            first.next.previous = null;
        first = first.next;
        return temp;
    }

    public Link deleteLast() {
        Link temp = last;
        if (first.next == null) first = null;
        else
            last.previous.next = null;
        last = last.previous;
        return temp;
    }

    public Link deleteKey(int key) {
        Link current = first;
        while (current.key != key) {
            current = current.next;
            if (current == null) return null;
        }
        if (current == last) {
            last = current.previous;
        } else current.next.previous = current.previous;
        if (current == first) {
            first = current.next;
        } else current.previous.next = current.next;

        return current;
    }
}
