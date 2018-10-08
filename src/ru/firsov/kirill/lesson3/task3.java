package ru.firsov.kirill.lesson3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 08.10.2018.
 */
public class task3 {
    public static void main(String[] args) throws IOException {
        //************priority queue realization***********************

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

        //************reverse message************************

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter String: ");
        System.out.flush();
        String input = br.readLine();
        //br.close();
        Reverser reverser = new Reverser(input);
        String output = reverser.doReverse();
        System.out.println(output);
    }
}
