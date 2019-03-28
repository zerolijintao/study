package java8.prettyPrintApple;

/**
 * Created by panny on 2019/3/27.
 */
public class AppleWeightFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        return "the apple is " + apple.getWeight() + "g";
    }
}
