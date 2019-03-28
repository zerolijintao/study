package leetcode;

/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */

public class Q53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, curSum = 0;
        for (int num : nums) {
            curSum = Math.max(curSum + num, num);
            res = Math.max(res, curSum);
        }
        return res;
    }

    public static void main(String[] args) {
        Q53_MaximumSubarray q = new Q53_MaximumSubarray();
        System.out.println(q.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
