package com.practice.usefulclasses.stream;

import java.util.Arrays;
import java.util.List;

public class ReduceStreamFunc {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,20,19,29);
        System.out.println(numbers.stream().reduce(0, Integer::sum));
        System.out.println(numbers.stream().reduce(100, (sum, num)-> sum + num));
    }
}
