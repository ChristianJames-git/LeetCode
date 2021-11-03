/*
 * https://leetcode.com/problems/reverse-integer/
 * 9/25/21
 *
 * Reverse input digits. Leave '-' if input is negative.
 * If reversing x causes it to exceed integer range, return 0.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int negative = 0;
        if (x < 0)
            negative = 1;
        String integer = String.valueOf(x);
        String temp = "";
        if (negative == 1)
            temp += '-';
        for (int i = integer.length()-1; i >= negative; i--)
            temp += integer.charAt(i);
        if (Long.parseLong(temp) > 2147483647 || Long.parseLong(temp) < -2147483648)
            return 0;
        x = Integer.parseInt(temp);
        return x;
    }

    public static void main(String[] args) {
        ReverseInteger a = new ReverseInteger();
        System.out.println(a.reverse(123)); //321
        System.out.println(a.reverse(-123)); //-321
        System.out.println(a.reverse(120)); //21
        System.out.println(a.reverse(0)); //0
        System.out.println(a.reverse(-2147483648)); //0 since -8463847412 is out of integer bounds
    }
}
