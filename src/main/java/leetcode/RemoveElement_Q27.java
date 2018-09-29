package leetcode;
/*
给定 nums = [0,1,2,2,3,0,4,2], val = 2,

函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

注意这五个元素可为任意顺序。

你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement_Q27 {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        RemoveElement_Q27 s = new RemoveElement_Q27();
        int[] nums = {3, 2, 2, 3};
        int num = s.removeElement(nums, 3);
        for (int i = 0; i < num; i++) {
            System.out.println(nums[i]);
        }
    }
}
