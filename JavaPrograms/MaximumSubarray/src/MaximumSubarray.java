/*
 * https://leetcode.com/problems/maximum-subarray/
 * 9/30/21
 *
 * Finds the largest contiguous subarray in the given array. Returns the largest sum.
 * Assumption: nums.length >= 1
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        for (int i = 1 ; i < nums.length ; i++)
            temp[i] = Math.max(temp[i-1] + nums[i], nums[i]);
        int max = Integer.MIN_VALUE;
        for (int a : temp) {
            if (a > max)
                max = a;
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray a = new MaximumSubarray();
        System.out.println(a.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4})); // 6 : [4,-1,2,1]
        System.out.println(a.maxSubArray(new int[] {5,4,-1,7,8})); // 23 : [5,4,-1,7,8]
        System.out.println(a.maxSubArray(new int[] {1})); // 1 : [1]
    }
}
