package com.practice.usefulclasses.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningByCollector {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("person1", "person2", "person3");
        System.out.println(names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", ")));
    }
}
