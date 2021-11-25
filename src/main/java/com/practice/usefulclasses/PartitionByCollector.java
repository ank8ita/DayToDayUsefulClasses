package com.practice.usefulclasses;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionByCollector {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,11,23,24,34,55);
        Map<Boolean, List<Integer>> collect = numbers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println("even numbers:" + collect.get(Boolean.TRUE));
        System.out.println("Odd numbers:" + collect.get(Boolean.FALSE));
    }
}
