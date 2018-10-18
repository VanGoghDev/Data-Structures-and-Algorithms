package ru.firsov.kirill.lesson2;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 07.10.2018.
 */
public class Task2 {
    public static void main(String[] args) {
        Array arr = new Array(1, 2, 5, 1, 8, 4, 9);
        //arr.delete(0);
        System.out.println(arr);
        arr.deleteAll(1);
        System.out.println(arr);
        //arr.deleteAll();
        //System.out.println(arr);
        arr.betterSortBubble();
        System.out.println(arr);
    }
}
