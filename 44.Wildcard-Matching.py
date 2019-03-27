# https://leetcode.com/problems/wildcard-matching/
#
# algorithms
# Hard (22.5%)
# Total Accepted:    166,779
# Total Submissions: 741,308
# beats 48.18% of python submissions

# 下面是 DP 的解法
class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        if s == p or p == '*':
            return True

        len_s, len_p = len(s), len(p)

        dp = [[False] * (len_p + 1) for _ in xrange((len_s + 1))]
        dp[0][0] = True

        for i in xrange(1, len_p + 1):
            if p[i - 1] == '*':
                dp[0][i] |= dp[0][i - 1]

        for i in xrange(1, len_s + 1):
            for j in xrange(1, len_p + 1):
                if s[i - 1] == p[j - 1] or p[j - 1] == '?':
                    dp[i][j] = dp[i - 1][j - 1]
                elif p[j - 1] == '*':
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1]

        return dp[len_s][len_p]

# AC 之后发现别的同学有更巧妙的解法，利用循环回溯


class Solution1(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        sp = 0
        pp = 0
        latest_star = -1
        star_match = 0

        while sp < len(s):
            if pp < len(p) and (p[pp] == s[sp] or p[pp] == '?'):
                sp += 1
                pp += 1
            elif pp < len(p) and p[pp] == '*':  # only pp keep moving
                star_match = sp
                latest_star = pp
                pp += 1
            elif latest_star != -1:  # p exist star, go back re-match
                pp = latest_star + 1
                star_match += 1
                sp = star_match
            else:  # no star and two char not equal or p shorter than s ...
                return False

        # also need to consider p longer case
        while pp < len(p) and p[pp] == '*':
            pp += 1

        return pp == len(p)
