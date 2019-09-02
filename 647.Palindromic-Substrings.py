# https://leetcode.com/problems/palindromic-substrings/
#
# algorithms
# Medium (57.73%)
# Total Accepted:    115,226
# Total Submissions: 199,582
# beats 92.09% of python submissions


class Solution(object):
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = len(s)
        res = length

        for i in xrange(length):
            # 以 i 为中心
            l, r = i - 1, i + 1
            while l >= 0 and r < length and s[l] == s[r]:
                l -= 1
                r += 1

            res += i - l - 1
            # 以 i 和 i + 1 为中心
            if i < length - 1 and s[i] == s[i + 1]:
                l, r = i - 1, i + 2
                while l >= 0 and r < length and s[l] == s[r]:
                    l -= 1
                    r += 1

                res += i - l

        return res
