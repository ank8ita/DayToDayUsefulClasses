package com.practice.usefulclasses;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PairUse {

    /**
     * Prints the prime number and it's square
     * @param args
     */
    public static void main(String[] args) {

        Pair<List<Integer>, List<Integer>> output = getPrimeNumberAndSquare(100);
        IntStream.range(0, Math.min(output.getKey().size(), output.getValue().size()))
                .mapToObj(i -> output.getKey().get(i) + ":" + output.getValue().get(i))
                .forEach(System.out::println);
    }

    private static Pair<List<Integer>, List<Integer>> getPrimeNumberAndSquare(int i) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> squares = new ArrayList<>();
        IntStream.range(2,i+1).filter(PairUse::isPrime).forEach(num->{
            numbers.add(num);
            squares.add(num*num);
        });
        return Pair.of(numbers,squares);

    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0)
                return false;
        return true;
    }
}
