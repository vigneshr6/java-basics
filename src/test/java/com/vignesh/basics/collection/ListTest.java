package com.vignesh.basics.collection;

import com.vignesh.basics.model.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ListIterator;

import static com.vignesh.basics.collection.CollectionTestUtil.getPersonArrayList;

public class ListTest {
    @Test
    public void testListCRUD() {
        ArrayList<Person> personArrayList = getPersonArrayList();
        System.out.println(Arrays.toString(personArrayList.toArray(Person[]::new)));
        Person g = personArrayList.get(2);
        System.out.println(g.hashCode());
        Person v = personArrayList.get(3);
        Person v2 = new Person(v.getFirstName(), "Palani", v.getAge());
        personArrayList.add(3, v2);
        personArrayList.remove(g);
        personArrayList.remove(0);
        System.out.println(Arrays.toString(personArrayList.toArray(Person[]::new)));
    }

    @Test
    public void testIterator() {
        ArrayList<Person> personArrayList = getPersonArrayList();
        Collections.sort(personArrayList);
        ListIterator<Person> reverseIt = personArrayList.listIterator(personArrayList.size());
        while (reverseIt.hasPrevious()) {
            System.out.println(reverseIt.previous());
        }
    }
}
