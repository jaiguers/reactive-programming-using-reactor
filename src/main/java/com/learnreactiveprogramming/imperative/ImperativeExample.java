package com.learnreactiveprogramming.imperative;

import java.util.ArrayList;
import java.util.List;

public class ImperativeExample {
    public static void main(String[] args) {
        var nameList=List.of("alex", "ben","chloe","adam");
        var newNames =nameGreaterThanSize(nameList,3);
        System.out.println("newNameList: "+newNames);
    }

    private static List<String> nameGreaterThanSize(List<String> nameList, int size) {
        var newNameList = new ArrayList<String>();

        for(String name: nameList)
        {
            if(name.length()>3)
                newNameList.add(name);
        }

        return newNameList;
    }
}
