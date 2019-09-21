# https://leetcode.com/problems/container-with-most-water/
#
# algorithms
# Medium (44.59%)
# Total Accepted:    490,116
# Total Submissions: 919,349


class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = len(s)
        if length == 0:
            return 0

        ch_2_value = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000,
        }
        res, idx = ch_2_value[s[0]], 1

        while idx < length:
            if (s[idx - 1] == 'I' and (s[idx] == 'V' or s[idx] == 'X')) or \
                    (s[idx - 1] == 'X' and (s[idx] == 'L' or s[idx] == 'C')) or \
                    (s[idx - 1] == 'C' and (s[idx] == 'D' or s[idx] == 'M')):
                res -= 2 * ch_2_value[s[idx - 1]]

            res += ch_2_value[s[idx]]
            idx += 1

        return res
