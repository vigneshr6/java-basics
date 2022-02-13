package com.vignesh.basics.collection;

import com.vignesh.basics.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.vignesh.basics.collection.CollectionTestUtil.getPersonArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void testFindMaxOccurrence() {
        Map<Integer, Long> occurrences = Stream.of(1, 4, 5, 4, 5, 2, 1, 7, 4)
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        long maxOccurrence = occurrences.values().stream().mapToLong(Long::longValue).max().getAsLong();
        Integer ans = occurrences.entrySet().stream().filter(e -> e.getValue() == maxOccurrence).findFirst().get().getKey();
        assertEquals(4, ans);
    }

}
