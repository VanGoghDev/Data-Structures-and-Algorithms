package ru.firsov.kirill.lesson3;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 08.10.2018.
 */
public class task3 {
    public static void main(String[] args) {
        PriorityQ priorityQ = new PriorityQ(5);
        priorityQ.insert(4);
        priorityQ.insert(3);
        priorityQ.insert(30);
        priorityQ.insert(10);
        priorityQ.insert(1);

        while(!priorityQ.isEmpty()) {
            int item = priorityQ.remove();
            System.out.println(item + " ");
        }
    }
}
