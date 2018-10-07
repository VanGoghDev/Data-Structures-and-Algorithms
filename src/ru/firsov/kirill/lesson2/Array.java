package ru.firsov.kirill.lesson2;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 07.10.2018.
 */
public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        isSorted = false;
    }

    public Array(int size) {
        this();
        this.size = 0;
        this.arr = new int[size];
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public int length() {
        return size;
    }

    public int get(int index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set(int index, int value) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
        isSorted = false;
    }

    public void append(int value) {
        if (size >= arr.length) {
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
        arr[size++] = value;
        isSorted = false;
    }

    /**
     * Deletes the last value in array
     */
    boolean delete() {
        if (size == 0) return false;
        size--;
        return true;
    }

    boolean delete(int index) { // by index
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        System.arraycopy(arr, index + 1, arr, index, size - 1 - index);
        size --;
        return true;
    }

    boolean deleteAll(int value) { // by value
        int j;
        for (j = 0; j < size; j++) {
            if (value == arr[j]) {
                System.arraycopy(arr, j + 1, arr, j, size - 1 - j);
                size--;
            }
        }
        return true;
    }

    void deleteAll() { // clear array
        this.size = 0;
        arr = new int[size];
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder b = new StringBuilder("[");
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == size - 1)
                return b.append("]").toString();
            b.append(", ");
        }
    }

    /**
     * Search
     */
    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("Try the 'find' method");
        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            // n >> k == n / 2 ^ k
            m = (l + r) >> 1; // 8 = 00001000 >> 1 = 00000100 = 4
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    /**
     * Sort
     */
    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //Сложность алгоритма: О(n^2)
    public void sortBubble() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
            }
        }
        isSorted = true;
    }

    //Сложность алгоритма: О(n^2)
    public void betterSortBubble() {
        int tale = size - 1;
        int k = size -1; // будем запоминать где сортируем, чтобы лишний раз не бегать по элементам
        int boundsLowUnsorted = size - 1;
        int boundsUpUnsorted = size - 1;

        do {
            //проход с конца на перед
            for (int i=tale; i>0; i--) {
                if (arr[i-1] > arr[i]) {
                    swap(i-1, i);
                    k = i;
                }
            }

            boundsLowUnsorted = k + 1;

            //проход с переда в конец
            for (int i=1; i<=boundsUpUnsorted; i++) {
                if (arr[i-1] > arr[i]) {
                    swap(i-1, i);
                    k = i;
                }
            }

            boundsUpUnsorted = k -1;
        } while (boundsLowUnsorted < boundsUpUnsorted);
    }

    //Сложность алгоритма: О(n^2)
    public void sortSelect() {
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++) {
                if (arr[rem] < arr[cMin])
                    cMin = rem;
            }
            swap(flag, cMin);
        }
        isSorted = true;
    }

    //Сложность алгоритма: О(n^2)
    public void sortInsert() {
        int in;
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
    }
}
