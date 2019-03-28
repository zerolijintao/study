package leetcode;

/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。
输入: [1,3,5,6], 5
输出: 2
输入: [1,3,5,6], 2
输出: 1
 */
public class Q35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Q35_SearchInsertPosition q = new Q35_SearchInsertPosition();
        System.out.println(q.searchInsert(new int[]{1,3,5,6}, 5));
    }
}
