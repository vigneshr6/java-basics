package com.vignesh.basics.oops;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tester {
    public static void main(String[] args) {
//        Animal a = new Dog();
//        //fields values won't be overridden
//        System.out.println(a.barkType);
//        System.out.println(a.getBarkType());
        Map<Integer, Long> result = process(new Integer[]{1, 2, 3, 4, 1, 3});
        System.out.println(result);
        List<String> products= null;
        Map<String,Long> sold = products.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
        long maxCount = sold.values().stream().mapToLong(s -> s).max().getAsLong();
        String featured = null;
    }

    private static Map<Integer, Long> process(Integer[] nums) {
        return Arrays.asList(nums).stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
    }
}
