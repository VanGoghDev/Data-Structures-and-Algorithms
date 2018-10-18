package ru.firsov.kirill.lesson1;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 07.10.2018.
 */
public class Task1 {
    public static void main(String[] args) {
        System.out.println("binary pow: " + binaryPow(2, 3));
        int[] arr = {3, 4, 6, 2, 4, 9};
        System.out.println("min element = " + minElement(arr));
        System.out.println("mean value = " + meanValue(arr));
    }

    /*
       Возведение в степень используя чётность степени
       Позволяет возводить любое число в n-ую степень
       Сложнотсь алгоритма O(log(n))
       Суть метода исходит из ассоциативности операции умножения (a*b)*c=a*(b*c)
       a^n = (a^(n/2))^2 = a^(n/2) * a^(n/2)
       Если степень нечетна, то a^n = a^(n-1)*a
   */
    private static int binaryPow(int a, int n) {
        if(n == 0) {
            return 1;
        } else if (n % 2 == 1) {
            return binaryPow(a, n-1) * a;
        } else {
            int b = binaryPow(a, n/2);
            return b*b;
        }
    }

    /*
        Поиск минимального элемента массива
        С алгоритмом все просто, я неуверен, что нужно описывать его
        Индекс минимального элемента находится за линейное время
        Цикл проходит по всем элементам массива
        Сложность алгоритма O(n)
    */
    private static int minElement(int[] arr) {
        int indexOfMin = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[indexOfMin]) {
                indexOfMin = i;
            }
        }
        return arr[indexOfMin];
    }


    /*
        Поиск среднего арифметического массива
        Суммируем все элементы и делим на их количество
        Сложность алгоритма O(n)
    */
    private static float meanValue(int[] arr) {
        float mean = 0;
        for (int i = 0; i < arr.length; i++) {
            mean += arr[i];
        }
        mean /= arr.length;
        return mean;
    }
}
