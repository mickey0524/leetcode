# https://leetcode.com/problems/word-break/
#
# algorithms
# Medium (34.92%)
# Total Accepted:    322,772
# Total Submissions: 924,352


class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        length = len(s)
        dp = [False] * (length + 1)
        dp[0] = True
        hash_map = {k: True for k in wordDict}

        for i in xrange(1, length + 1):
            for j in xrange(i):
                if dp[j] and s[j:i] in hash_map:
                    dp[i] = True

        return dp[-1]
