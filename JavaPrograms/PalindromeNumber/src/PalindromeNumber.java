/*
 * https://leetcode.com/problems/palindrome-number/
 * 9/25/21
 *
 * Return true if x is a palindrome integer
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String temp = String.valueOf(x);
        for (int i = 0; i < temp.length()/2; i++) {
            if (temp.charAt(i) != temp.charAt(temp.length()-i-1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber a = new PalindromeNumber();
        System.out.println(a.isPalindrome(121)); //true
        System.out.println(a.isPalindrome(-121)); //false 121-
        System.out.println(a.isPalindrome(10)); //false 01
        System.out.println(a.isPalindrome(1334331)); //true
    }
}
