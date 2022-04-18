package com.learnreactiveprogramming.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalExample {
    public static void main(String[] args) {
        var nameList= List.of("alex", "ben","chloe","adam","adam");
        var newNames =nameGreaterThanSize(nameList,3);
        System.out.println("newNameList: "+newNames);
    }

    private static List<String> nameGreaterThanSize(List<String> nameList, int size) {
       return nameList.parallelStream()
               .filter(s->s.length()>size)
               .map(String::toUpperCase)
               .distinct()
               .sorted()
               .collect(Collectors.toList());
    }
}
