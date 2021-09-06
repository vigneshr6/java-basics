package com.vignesh.basics.ust;

import java.util.*;
import java.util.stream.Collectors;

public class ListNames {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("vignesh", "raj", "sachin", "Rami", "sachin", "raj", "raj", "vignesh"));
        Map<String,Integer> duplicates = getDuplicates(names);
        duplicates.forEach((name,occur) ->  {
            System.out.println(name+" --> "+occur);
        });
    }
    public static Map<String,Integer> getDuplicates(List<String> all) {
        Map<String,Integer> occurs = new HashMap<>();
//        all.stream().collect(Collectors.groupingBy((name,count) -> {
//            count++
//        }))
        Map<String, List<String>> nameGroups = all.stream().collect(Collectors.groupingBy(String::toString));
        System.out.println(nameGroups);
//        nameGroups.entrySet().stream().map((name,ng) -> {
//            return Map.Entry();
//        })
        all.stream().filter(name -> name.matches("^(r|R).*")).forEach(System.out::println);
        all.forEach(name -> {
            Integer occur = occurs.getOrDefault(name, 0);
            occurs.put(name,occur.intValue()+1);
        });
        System.out.println("occurs : "+occurs);
        Map<String,Integer> dups = new HashMap<>();
//        occurs.entrySet().
        occurs.forEach((name,count)->{
            if(count > 1) {
                dups.put(name,count);
            }
        });
        System.out.println("dups : "+dups);
        return dups;
    }
}
