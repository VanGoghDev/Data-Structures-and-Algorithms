package ru.firsov.kirill.lesson6;

import java.util.Random;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 18.10.2018.
 */
public class Rnd {
    private static final Random random = new Random();

    /**
     * Сгенерировать случайное число
     * @param min минимальное значение случайного числа
     * @param max максимальное значение случайного числа
     * @return результат
     */
    public static int nextInt(int min, int max) {
        return (int) (random.nextFloat() * (max - min) + min);
    }
}
