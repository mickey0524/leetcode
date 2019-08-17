# https://leetcode.com/problems/find-all-anagrams-in-a-string/
#
# algorithms
# Medium (37.8%)
# Total Accepted:    138,777
# Total Submissions: 365,240


class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        len_s, len_p = len(s), len(p)
        if len_s < len_p:
            return []

        ch_p = [0] * 26
        for ch in p:
            ch_p[ord(ch) - 97] += 1

        ch_s = [0] * 26
        for i in xrange(len_p):
            ch_s[ord(s[i]) - 97] += 1

        res = []
        if self.equals(ch_p, ch_s):
            res += 0,

        for i in xrange(len_p, len_s):
            ch_s[ord(s[i]) - 97] += 1
            ch_s[ord(s[i - len_p]) - 97] -= 1
            if self.equals(ch_p, ch_s):
                res.append(i - len_p + 1)

        return res

    def equals(self, l1, l2):
        for i in xrange(26):
            if l1[i] != l2[i]:
                return False

        return True
