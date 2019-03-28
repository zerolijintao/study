package java8.prettyPrintApple;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by panny on 2019/3/27.
 */
public class PrettyPrintApple {
    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(
                new Apple("a", 10, "green"),
                new Apple("b", 20, "red")
        );
        prettyPrintApple(list, new AppleWeightFormatter());
        prettyPrintApple(list, new AppleFancyFormatter());
        prettyPrintApple(list, (Apple a)-> a.getColor());
    }

    public Callable<String> fetch() {
        return () -> "abc";
    }
}
