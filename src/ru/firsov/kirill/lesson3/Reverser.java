package ru.firsov.kirill.lesson3;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 08.10.2018.
 */
public class Reverser {
    private String input;
    private String output;

    public Reverser(String input) {
        this.input = input;
    }

    public String doReverse() {
        Stack stack = new Stack(input.length());
        for (int i = 0; i < input.length(); i++) {
            stack.insert(input.charAt(i));
        }
        output = "";
        while (!stack.isEmpty()) {
            char ch = stack.remove();
            output += ch;
        }
        return output;
    }
}
