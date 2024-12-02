package com.vignesh.basics.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class TekionController {

    // most used words and times of occurrence in the text
// input:- I am manish manish is good person manish like cricket player manish like music manish is now holyboll player// output// [// {// "word" : "manish",// "count":5// },// {// "word" : "like",// "count":2// }

    @PostMapping
    @RequestMapping("/count")
    public Map<String, Integer> getCount(@RequestBody Map<String,String> body) {
        String input = body.get("input");
        HashMap<String, Integer> wordCount = new HashMap<>();
        String[] words = input.split(" ");
        ArrayList arrayList = new ArrayList<wordCount>();
        for(int i = 0; i<words.length; i++) {
            String word = words[i];
            Integer count = wordCount.getOrDefault(word, 0);
            wordCount.put(word, count+1);
        }
//        wordCount.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).forEach(es -> arrayList.add(new wordCount(es.getKey(), es.getValue())));
        Map<String, Integer> collect = wordCount.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(10).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> {throw new RuntimeException();}, LinkedHashMap::new));
        return collect;
    }

    private static class wordCount {
        public String word;
        public Integer count;

        public wordCount(String word, Integer count) {
            this.word = word;
            this.count = count;
        }
    }
}
