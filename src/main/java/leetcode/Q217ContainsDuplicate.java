package leetcode;

import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Q217ContainsDuplicate {
    public boolean isPerfectSquare(int num) {
        int temp = num, c = 0;
        while(temp > 0){
            temp >>= 1;
            c =  (c << 1) + 1;
        }
        return (num ^ c) == num - 1;
    }

    public static void main(String[] args) {
        Q217ContainsDuplicate q = new Q217ContainsDuplicate();
        System.out.println(q.isPerfectSquare(15));
    }

    public static <T> Collector<T, ?, Stream<T>> toEagerShuffledStream() {
        return Collectors.collectingAndThen(
                toList(),
                list -> {
                    Collections.shuffle(list);
                    return list.stream();
                });
    }
}
