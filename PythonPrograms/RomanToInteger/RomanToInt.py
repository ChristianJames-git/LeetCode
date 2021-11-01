"""
https://leetcode.com/problems/roman-to-integer/
Converts Roman numerals ('I', 'V', 'X', 'L', 'C', 'D', 'M') to integer
"""


class RomanToInteger:
    @staticmethod
    def romantoint(s: str) -> int:
        total = 0
        prev = 1001
        curr = 0
        mapping = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000
        }
        for i in s:
            curr = mapping.get(i)
            if curr > prev:
                total -= 2 * prev
            total += curr
            prev = curr
        return total


print(RomanToInteger.romantoint("MCMXCIV"))  # 1994
print(RomanToInteger.romantoint("MMMMMMMM"))  # 8000, done this way since only 7 base numerals are counted
