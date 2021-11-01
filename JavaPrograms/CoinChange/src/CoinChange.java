/*
 * https://leetcode.com/problems/coin-change/
 * 10/11/21
 *
 * Finds the fewest number of coins needed to make the amount provided given int[] of coin values.
 */

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        int[] arr = new int[amount+1];
        int sum = 0;

        while (++sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && arr[sum-coin] != -1) {
                    int temp = arr[sum-coin] + 1;
                    min = min < 0 ? temp : Math.min(temp, min);
                }
            }
            arr[sum] = min;
        }
        return arr[amount];
    }

    public static void main(String[] args) {
        CoinChange a = new CoinChange();
        System.out.println(a.coinChange(new int[] {1,2,5}, 11)); // 3
        System.out.println(a.coinChange(new int[] {2}, 3)); // impossible
        System.out.println(a.coinChange(new int[] {1}, 0)); // adding to 0
    }
}
