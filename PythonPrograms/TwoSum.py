"""
https://leetcode.com/problems/two-sum/
9/25/21

return indices of the two numbers such that they add up to target
"""
from typing import List


class TwoSum:
    @staticmethod
    def twosum(nums: List[int], target: int) -> List[int]:
        prev_map = {}

        for i, n in enumerate(nums):
            diff = target - n
            if diff in prev_map:
                return [prev_map[diff], i]
            prev_map[n] = i


print(TwoSum.twosum([2, 7, 11, 15], 9))
print(TwoSum.twosum([3, 2, 4], 6))
