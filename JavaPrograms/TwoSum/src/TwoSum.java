import java.util.ArrayList;
import java.util.HashMap;

/*
 * https://leetcode.com/problems/two-sum/
 * twoSum 9/25/21
 * twoSumHM 11/2/21 *much faster*
 *
 * Returns the two indices who's values add to the target value. 1 solution assumed
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> hM = new ArrayList<>();
        int[] toReturn = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hM.contains(diff)) {
                toReturn[0] = hM.indexOf(diff);
                toReturn[1] = i;
                return toReturn;
            }
            hM.add(nums[i]);
        }
        return toReturn;
    }

    public int[] twoSumHM(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Integer complement = target - nums[i];
            if(hm.containsKey(nums[i])) {
                return new int[] {hm.get(nums[i]), i};
            }
            hm.put(complement, i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum a = new TwoSum();
        print(a.twoSum(new int[] {2,7,11,15}, 9)); //[0,1]
        print(a.twoSumHM(new int[] {3,2,4}, 6)); //[1,2]
    }
    static void print(int[] output) {
        System.out.print("[");
        for (int i = 0 ; i < output.length ; i++) {
            System.out.print(output[i]);
            if (i < output.length-1)
                System.out.print(",");
        }
        System.out.println("]");
    }
}
