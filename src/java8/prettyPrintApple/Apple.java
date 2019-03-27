package java8.prettyPrintApple;

/**
 * Created by panny on 2019/3/27.
 */
public class Apple {
    private String name;
    private Integer weight;
    private String color;

    public Apple(String name, Integer weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
