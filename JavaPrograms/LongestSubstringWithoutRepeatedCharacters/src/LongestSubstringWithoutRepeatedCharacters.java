/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 9/29/21
 *
 * Finds the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatedCharacters {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int curr = 0;
        StringBuilder temp = new StringBuilder();
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            if (temp.toString().indexOf(c) != -1) {
                temp.append(c);
                temp = new StringBuilder(temp.substring(temp.toString().indexOf(c) + 1));
                curr = temp.length();
            } else {
                temp.append(c);
                curr++;
            }
            if (curr > longest)
                longest = curr;
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatedCharacters a = new LongestSubstringWithoutRepeatedCharacters();
        System.out.println(a.lengthOfLongestSubstring("abcabcbb")); // 3 : "abc"
        System.out.println(a.lengthOfLongestSubstring("bbbbb")); // 1 : "b"
        System.out.println(a.lengthOfLongestSubstring("pwwkew")); // 3 : "wke"
        System.out.println(a.lengthOfLongestSubstring("")); // 0
    }
}
