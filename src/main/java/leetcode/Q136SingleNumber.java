package leetcode;

public class Q136SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    public static void main(String[] args) {
        Q136SingleNumber q = new Q136SingleNumber();
        System.out.println(q.singleNumber(new int[]{1, 2, 3, 3, 5, 4, 2, 4, 1}));
    }
}
