package ru.firsov.kirill.lesson6;

import ru.firsov.kirill.lesson4.Person;

import java.util.List;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 18.10.2018.
 */
public class Task6 {

    private static Tree trees[];
    private final static int TREES_COUNT = 20;

    public static void main(String[] args) {
        trees = new Tree[TREES_COUNT];
        for (int i = 0; i < TREES_COUNT ; i++) {
            trees[i] = new Tree();
            for (int j = 0; j <= 11; j++) {
                Person p = new Person();
                p.id = Rnd.nextInt(0, 100);
                trees[i].insert(p);
            }
            trees[i].displayTree();
        }
    }
    // в моем случае получилось, что несбалансированных деревьев получилось гораздо больше чем сбалансированных
}
