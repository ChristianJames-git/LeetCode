/*
 * https://leetcode.com/problems/majority-element/
 * 9/21/21
 *
 * Return the majority, any number that appears more than n/2 times
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] larr = new int[(nums.length+1)/2];
        System.arraycopy(nums, 0, larr, 0, (nums.length+1)/2);
        int lmaj = majorityElement(larr);
        if(lmaj != -1) {
            if(countInstances(nums, lmaj) != -1)
                return lmaj;
        }
        int[] rarr = new int[nums.length/2];
        System.arraycopy(nums, (nums.length+1)/2, rarr, 0, nums.length/2);
        int rmaj = majorityElement(rarr);
        if(rmaj != -1) {
            if(countInstances(nums, rmaj) != -1)
                return rmaj;
        }
        return -1;
    }
    public static int countInstances(int[] nums, int maj) {
        if (maj != -1) {
            int count = 0;
            for (int num : nums)
                if (num == maj)
                    count++;
            if(count > nums.length/2)
                return maj;
            return -1;
        }
        return maj;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 9, 4, 2, 4, 5, 1, 6, 12, 4, 6, 3};
        int[] arr2 = {3,2,3};
        int[] arr3 = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr)); //-1 due to no majority
        System.out.println(majorityElement(arr2));
        System.out.println(majorityElement(arr3));
    }
}
