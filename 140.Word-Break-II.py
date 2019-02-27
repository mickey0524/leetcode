# https://leetcode.com/problems/word-break-ii/
#
# algorithms
# Hard (26.26%)
# Total Accepted:    141,443
# Total Submissions: 538,582
# beats 100.0% of python submissions

class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """
        if len(wordDict) == 0:
            return []

        hash_map = {}
        for word in wordDict:
            hash_map[word] = True

        length = len(s)
        dp = [None] * (length + 1)
        dp[0] = True

        for i in xrange(1, length + 1):
            tmp = []
            for j in xrange(i):
                if dp[j] is not None and s[j:i] in hash_map:
                    tmp += j,
            if len(tmp) > 0:
                dp[i] = tmp

        if dp[-1] is None:
            return []

        res = [[]]

        def recursive(idx, path):
            if idx == 0:
                res[0] += path.strip(),
                return

            for i in dp[idx]:
                recursive(i, s[i:idx] + ' ' + path)

        recursive(length, '')

        return res[0]
