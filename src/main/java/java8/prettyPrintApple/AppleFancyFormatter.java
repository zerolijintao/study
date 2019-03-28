package java8.prettyPrintApple;

/**
 * Created by panny on 2019/3/27.
 */
public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" :
                "light";
        return "A " + characteristic +
                " " + apple.getColor() +" apple";
    }
}
