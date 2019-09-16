# https://leetcode.com/problems/unique-substrings-in-wraparound-string/
#
# algorithms
# Medium (34.48%)
# Total Accepted:    20,119
# Total Submissions: 58,355
# beats 95.67% of python submissions


from collections import defaultdict


class Solution(object):
    def findSubstringInWraproundString(self, p):
        """
        :type p: str
        :rtype: int
        """
        length = len(p)
        if length == 1:
            return 1

        pre_ch = ['z'] * 26
        for i in xrange(1, 26):
            pre_ch[i] = chr(96 + i)

        hash_map = defaultdict(int)
        res = 0
        l, r = 0, 1

        while r <= length:
            if r == length or pre_ch[ord(p[r]) - 97] != p[r - 1]:

                for i in xrange(l, min(r, l + 26)):
                    tmp = r - i
                    if tmp <= hash_map[p[i]]:
                        continue

                    res += (tmp - hash_map[p[i]])
                    hash_map[p[i]] = tmp

                l = r

            r += 1

        return res
