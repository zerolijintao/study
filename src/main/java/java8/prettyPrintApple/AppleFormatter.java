package java8.prettyPrintApple;

/**
 * Created by panny on 2019/3/27.
 * 其只定义了一个抽象方法，所以这是一个函数式接口，可以使用Lambda表达式
 */
public interface AppleFormatter {
    String accept(Apple apple);
}
