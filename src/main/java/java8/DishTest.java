package java8;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class DishTest {
    List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));


    public List<Dish> getMEATLimit2() {int calories = menu.stream()
            .map(Dish::getCalories)
            .reduce(0, Integer::sum);
        return menu.stream().filter(t -> t.getType().equals(Dish.Type.MEAT)).limit(2).collect(toList());
    }

    public List<Integer> getDishNameLength() {
        return menu.stream().map(t -> t.getName().length()).collect(toList());
    }

    public List<String> getDistinctWord() {
        List<String> words = Arrays.asList("hello", "world");
        return words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
    }

    /**
     * 将两个数组合并，并返回能被3整除的数组
     * 给定列表[1, 2, 3]和列表[3, 4]，
     * 新数组[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。
     * 返回总和能被3整除的数对[(2, 4), (3, 3)]
     * @return
     */
    public List<int[]> getIntMerge() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        return numbers1.stream()
                .flatMap(i -> numbers2.stream()
                                .filter(j -> (i + j) % 3 == 0)
                                .map(j -> new int[]{i, j})
                        )
                .collect(toList());
    }

    public List<int[]> getIntMergeOld() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> result = new ArrayList<>();
        for (Integer n1 : numbers1) {
            for (Integer n2 : numbers2) {
                result.add(new int[]{n1, n2});
            }
        }
        return result;
    }

    public void testReduce() {
        List<Integer> numbers = Arrays.asList(1, 9, 3);
        System.out.println(numbers.stream().reduce(0, (a, b) -> a + b));
        Integer max = numbers.stream().reduce(0, (a, b) -> Math.max(a, b));
        System.out.println(max);
    }

    public void testError() {
        Set<Dish> nameSet = new HashSet<>();
        menu.stream().forEach(t->nameSet.add(t));
    }

    public int getMenuNum() {
        return (int) menu.stream().count();
    }

    public static void main(String[] args) {
        DishTest test = new DishTest();
        System.out.println(test.getMEATLimit2());
        System.out.println(test.getDistinctWord());
        System.out.println(test.getIntMerge());
        test.testReduce();
    }
}
