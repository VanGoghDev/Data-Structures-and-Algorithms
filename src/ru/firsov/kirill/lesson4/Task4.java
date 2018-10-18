package ru.firsov.kirill.lesson4;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 11.10.2018.
 */
public class Task4 {
    public static void main(String[] args) {
        DoublyLinkedList<Person> personDoublyLink = new DoublyLinkedList<>();
        personDoublyLink.insertFirst(1, new Person(21, "Kirill"));
        personDoublyLink.insertFirst(2, new Person(20, "Andrew"));
        personDoublyLink.insertFirst(1, new Person(22, "Vadim"));

        personDoublyLink.insertLast(3, new Person(40, "Mikhail"));
        personDoublyLink.insertLast(4, new Person(34, "Kim"));

        personDoublyLink.display();

        personDoublyLink.deleteFirst();
        personDoublyLink.display();

        personDoublyLink.deleteKey(3);
        personDoublyLink.display();

        personDoublyLink.insertAfter(2, 1, new Person(21, "Egor"));
        personDoublyLink.display();

    }
}
