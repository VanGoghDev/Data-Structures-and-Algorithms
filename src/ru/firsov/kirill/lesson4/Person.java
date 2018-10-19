package ru.firsov.kirill.lesson4;

import java.util.Objects;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 11.10.2018.
 */
public class Person {

    public int id;
    private int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public String toString() {
        return String.format("(A: %d, N: %s)", age, name);
    }
}
