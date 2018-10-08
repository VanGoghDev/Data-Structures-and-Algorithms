package ru.firsov.kirill.lesson3;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 08.10.2018.
 */
public class Stack {
    private char[] stack;
    private int head;

    public Stack(int size) {
        this.stack = new char[size];
        this.head = -1;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return head == stack.length - 1;
    }

    public boolean insert(char i) {
        if (isFull())
            return false;
        stack[++head] = i;
        return true;
    }

    public char remove() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return stack[head--];
    }

    public char peek() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return stack[head];
    }
}