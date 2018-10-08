package ru.firsov.kirill.lesson3;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 08.10.2018.
 */
public class Deque {
    int size;
    int head;
    int tail;
    int [] queue;

    public Deque(int size) {
        this.size = size;
        this.queue = new int[size];
    }

    public void insertLeft(int value) {
       queue[head] = value;
       if (--head < 0)
           head = size - 1;
    }

    public void insertRight(int value) {
        if (++tail == size)
            tail = 0;
        queue[tail] = value;
    }

    public int removeLeft() {
        if (++head == size)
            head = 0;
        return queue[head];
    }

    public int removeRight() {
        if (--tail<0)
            tail = size - 1;
        return queue[tail];
    }
}
