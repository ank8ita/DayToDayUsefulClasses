package com.practice.usefulclasses.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AggregateFuncByCollector {

    public static void main(String[] args) {
        //find frequency of each word
        List<String> names = Arrays.asList("bob", "misstee", "noddy", "misstee", "oswald", "noddy", "misstee", "noddy", "misstee");
        Map<String, Long> countByName = names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("count by Name:" + countByName);

        Map<String, Integer> countByNameInt = names.stream()
                .collect(Collectors.groupingBy(name -> name,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
        System.out.println("count by Name int:" + countByNameInt);

        AggregateFuncByCollector aggregateFuncByCollector = new AggregateFuncByCollector();
        Map<String, Set<Integer>> ageByName = aggregateFuncByCollector.createPeople().stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.mapping(Person::getAge, Collectors.toSet())));
        System.out.println("ages by name:" + ageByName);


        Map<String, Integer> sumOfAgeByName = aggregateFuncByCollector.createPeople().stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.mapping(Person::getAge, Collectors.reducing(0, Integer::sum))));
        System.out.println("sum fo age by Name:" + sumOfAgeByName);

        System.out.println("Max Age:" + aggregateFuncByCollector.createPeople().stream().mapToInt(Person::getAge).max());
        System.out.println("Max Age Person:" + aggregateFuncByCollector.createPeople().stream().max(Comparator.comparing(Person::getAge)));
        System.out.println("Min Age:" + aggregateFuncByCollector.createPeople().stream().mapToInt(Person::getAge).min());
        System.out.println("Min Age Person:" + aggregateFuncByCollector.createPeople().stream().min(Comparator.comparing(Person::getAge)));
    }

    public List<Person> createPeople() {
        return Arrays.asList(
                new Person("Bob", 24),
                new Person("Bob", 29),
                new Person("Misstee", 28),
                new Person("noddy", 24),
                new Person("Oswald", 30),
                new Person("Oswald", 39),
                new Person("Mistee", 25)

        );
    }
}

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}