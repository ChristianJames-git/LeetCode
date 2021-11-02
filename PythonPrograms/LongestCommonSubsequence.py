"""
https://leetcode.com/problems/longest-common-subsequence/
9/29/21
Returns the length of the longest common subsequence
"""


class LCS:
    @staticmethod
    def longestcommonsubsequence(s: str, t: str) -> int:
        (n, m) = (len(s), len(t))
        dp = [[0 for j in range(m+1)] for i in range(n+1)]
        for i in range(1, n+1):
            for j in range(1, m+1):
                if s[i-1] == t[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        return dp[n][m]


print(LCS.longestcommonsubsequence("abcde", "ace"))  # 3 : "ace"
print(LCS.longestcommonsubsequence("abc", "def"))  # 0 : ""
print(LCS.longestcommonsubsequence("abl3n3sxcdeidk", "3345ddik"))  # 5 : "33ddk"
