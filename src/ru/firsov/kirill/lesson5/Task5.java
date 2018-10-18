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

    public static void main(String[] args) {
        System.out.println(powRec(6, -8));
    }
}
