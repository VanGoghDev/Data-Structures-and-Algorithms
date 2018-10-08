package ru.firsov.kirill.lesson3;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 08.10.2018.
 */
public class PriorityQ {
    private int size;
    private int queue[];
    private int items;

    public PriorityQ(int size) {
        this.size = size;
        this.queue = new int[size];
        items = 0;
    }

    public void insert(int i) {
        int j;

        if (items==0)
            queue[items++] = i;
        else {
            for (j=items-1; j>=0; j--) {
                if (i > queue[j])
                    queue[j+1] = queue[j];
                else
                    break;
            }
            queue[j+1] = i;
            items++;
        }
    }

    public int remove() {
        return queue[--items];
    }

    public int peekMin() {
        return queue[items-1];
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == size;
    }
}
