/*
 * https://leetcode.com/problems/n-th-tribonacci-number/submissions/
 * 9/25/21
 *
 * T[0] = 0, T[1] = 1, T[2] = 1, T[n] = T[n-1] + T[n-2] + T[n-3] for n >= 3
 */
public class NthTribonacciNumber {
    public int tribonacci(int n) {
        if (n < 0)
            return -1;
        int[] temp = new int[n+1];
        if (n < 2)
            return n;
        temp[0] = 0; temp[1] = 1; temp[2] = 1;
        for (int i = 3; i <= n; i++)
            temp[i] = temp[i-1] + temp[i-2] + temp[i-3];
        return temp[n];
    }

    public static void main(String[] args) {
        NthTribonacciNumber a = new NthTribonacciNumber();
        System.out.println(a.tribonacci(4));
        System.out.println(a.tribonacci(25));
        System.out.println(a.tribonacci(-5)); //not within constraints
    }
}
