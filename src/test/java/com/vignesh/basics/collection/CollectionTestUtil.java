package com.vignesh.basics.collection;

import com.vignesh.basics.model.Person;

import java.util.ArrayList;
import java.util.LinkedList;

public class CollectionTestUtil {
    private static ArrayList<Person> personList = new ArrayList<>() {{
        add(new Person("Vignesh", "R", 27));
        add(new Person("Divya", "R", 25));
        add(new Person("Gayathri", "P", 20));
        add(new Person("Varun", "P", 19));
    }};

    public static ArrayList<Person> getPersonArrayList() {
        return personList;
    }

    public static LinkedList<Person> getPersonLinkedList() {
        return new LinkedList<>(personList);
    }
}
