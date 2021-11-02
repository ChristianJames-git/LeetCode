"""
https://leetcode.com/problems/n-th-tribonacci-number/
9/25/21

T[0] = 0, T[1] = 1, T[2] = 1 and T[n] = T[n-3] + T[n-2] + T[n-1] for n >= 3.
"""


def tribonacci(n: int) -> int:
    if n < 0:
        return -1
    temp = [0, 1, 1]
    for i in range(3, n + 1):
        temp.append(temp[i - 1] + temp[i - 2] + temp[i - 3])
    return temp[n]


print(tribonacci(4))
print(tribonacci(25))
print(tribonacci(-5))  # outside bounds
