package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Collection<People> peoples = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Иван Иванович", 69, Sex.MAN)
        );
        Stream<People> stream = peoples.stream();
        List<People> militarian =
                stream.filter(people -> people.getSex() == Sex.MAN && (people.getAge() >= 18 && people.getAge() <= 27)).collect(Collectors.toList());
        System.out.println(militarian.toString());

        Stream<People> averageMan = peoples.stream();
        double result = averageMan.filter(people -> people.getSex() == Sex.MAN).mapToInt(People::getAge).average().getAsDouble();
        // 'OptionalDouble.getAsDouble()' without 'isPresent()' check предупреждение в IDEA.
        System.out.println(result);

        Stream<People> potencialWorks = peoples.stream();
        long countWorks = potencialWorks.filter(people -> (people.getSex() == Sex.MAN && (people.getAge() >= 18 & people.getAge() <= 65))
                || people.getSex() == Sex.WOMEN && (people.getAge() >= 18 & people.getAge() <= 60))
                .count();
        System.out.println(countWorks);
    }
}
