package ru.firsov.kirill.lesson7;

public class Queue {
    private int size;
    private int[] queArray;
    private int front;
    private int rear;

    public Queue(int size) {
        queArray = new int[size];
        front = 0;
        rear = -1;
        this.size = size;
    }

    public void insert(int j) {
        if (rear == size - 1)
            rear = -1;
        queArray[++rear] = j;
    }

    public int remove() {
        int temp = queArray[front++];
        if (front == size)
            front = 0;
        return temp;
    }

    public boolean isEmpty() {
        return ((rear+1==front) || (front+size-1==rear));
    }

    public int peek() {
        return queArray[front];
    }
}
