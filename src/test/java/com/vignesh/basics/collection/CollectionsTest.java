package com.vignesh.basics.collection;

import com.vignesh.basics.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.vignesh.basics.collection.CollectionTestUtil.getPersonArrayList;

public class CollectionsTest {

    @Test
    public void testBinarySearch() {
        List<Integer> numbers = getPersonArrayList().stream().map(Person::getAge).distinct().sorted().collect(Collectors.toList());
        int i = Collections.binarySearch(numbers, 21);
        if(i<0) {
            i=-i-1;
        }
        System.out.println("i = " + i);
    }
}
