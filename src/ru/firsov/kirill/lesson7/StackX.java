package ru.firsov.kirill.lesson7;

public class StackX {
    private int[] stack;
    private int head;

    public StackX(int size) {
        this.stack = new int[size];
        this.head = -1;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return head == stack.length - 1;
    }

    public boolean push(int i) {
        if (isFull())
            return false;
        stack[++head] = i;
        return true;
    }

    public int pop() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return stack[head--];
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return stack[head];
    }
}
