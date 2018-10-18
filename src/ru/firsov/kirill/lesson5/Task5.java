package ru.firsov.kirill.lesson5;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 18.10.2018.
 */
public class Task5 {

    // возведение числа в степень рекурсивным подходом
    private static float powRec(int x, int y) {
        if (y < 0) {
            return powRec(x, y + 1) / x;
        }
        return (y == 0) ? 1 : powRec(x, y -1) * x;
    }

    // задача о Ханойской башни
    public static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1)
            System.out.println("Disk 1 from " + from + " to " + to);
        else {
            doTowers(topN-1, from, to, inter);
            System.out.println("Disk " + topN + " from " + from + " to " + to);
            doTowers(topN-1, inter, from, to);
        }

    }

    public static void main(String[] args) {
        //print power result
        System.out.println(powRec(6, -8));

        //do Hanoi tower algorithm
        int nDisk = 3;
        doTowers(nDisk, 'A', 'B', 'C');
    }
}
