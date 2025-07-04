package org.quantaidk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {



        List<Class> list = new ArrayList<>();
        list.add(new Class(1));
        list.add(new Class(2));
        list.add(new Class(3));
        list.add(new Class(4));
        list.add(new Class(5));

        Consumer<Class> c = i -> i.setValue(i.getValue() * 2);


        list.forEach(c);
        list.forEach(i -> System.out.println(i.getValue()));
    }
}