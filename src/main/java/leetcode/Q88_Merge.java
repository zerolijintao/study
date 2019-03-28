package leetcode;

import java.util.Arrays;

public class Q88_Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Q88_Merge q = new Q88_Merge();
        q.merge(new int[]{1, 2, 3, 6,0,0,0,0}, 4, new int[]{5, 7, 8, 9}, 4);
    }
}
