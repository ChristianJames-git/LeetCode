/*
 * https://leetcode.com/problems/sort-array-by-parity-ii/
 * 9/28/21
 *
 * Given array of half even, half odd integers
 * Sorts so every odd index corresponds to an odd number and same for even.
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) { //nums.length is even
        for (int i = 0 ; i < nums.length ; i++) {
            if (i % 2 == nums[i] % 2)
                continue;
            for (int j = i+1 ; j < nums.length ; j++) {
                if (i % 2 == nums[j] % 2) {
                    nums = swap(nums, i, j);
                    break;
                }
            }
        }
        return nums;
    }
    public int[] swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
    public void print(int[] output) {
        System.out.print("[");
        for (int i = 0 ; i < output.length ; i++) {
            System.out.print(output[i]);
            if (i < output.length-1)
                System.out.print(",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        SortArrayByParityII a = new SortArrayByParityII();
        a.print(a.sortArrayByParityII(new int[] {4,2,5,7}));
        a.print(a.sortArrayByParityII(new int[] {2,3}));
    }
}
