/*
 * https://leetcode.com/problems/roman-to-integer/
 * 9/30/21
 *
 * Converts Roman Numerals to Integers. Only include 7 main Roman characters.
 */
public class RomanToInt {
    public int romanToInt(String s) {
        int sum = 0;
        int prevVal = 1001;
        int currVal = 0;
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case 'I' -> currVal = 1;
                case 'V' -> currVal = 5;
                case 'X' -> currVal = 10;
                case 'L' -> currVal = 50;
                case 'C' -> currVal = 100;
                case 'D' -> currVal = 500;
                case 'M' -> currVal = 1000;
            }
            if (currVal > prevVal)
                sum -= 2 * prevVal;
            sum += currVal;
            prevVal = currVal;
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInt a = new RomanToInt();
        System.out.println(a.romanToInt("MCMXCIV")); // 1994
        System.out.println(a.romanToInt("MMMMMMMM")); // 8000 since only 7 characters included
    }
}
