package com.vignesh.basics.collection;

import com.vignesh.basics.model.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.vignesh.basics.collection.CollectionTestUtil.getPersonArrayList;

public class StreamTest {
    @Test
    public void testIntStream() {
        ArrayList<Person> personArrayList = getPersonArrayList();
//        IntStream ageIntStream = personArrayList.stream().mapToInt(Person::getAge);
        System.out.println("max : "+personArrayList.stream().mapToInt(Person::getAge).max().getAsInt());
        System.out.println("min : "+personArrayList.stream().mapToInt(Person::getAge).min().getAsInt());
        System.out.println("sum : "+personArrayList.stream().mapToInt(Person::getAge));
        System.out.println("sorted : "+ Arrays.toString(personArrayList.stream().mapToInt(Person::getAge).sorted().toArray()));
    }

}
