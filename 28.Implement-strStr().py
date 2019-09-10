# https://leetcode.com/problems/implement-strstr/
#
# algorithms
# Easy (32.84%)
# Total Accepted:    486,985
# Total Submissions: 1,482,860


class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if needle == '':
            return 0

        len_h, len_n = len(haystack), len(needle)
        if len_n > len_h:
            return -1

        idx_h, idx_n = 0, 0
        next = self.gen_next(needle)

        while idx_h < len_h and idx_n < len_n:
            if idx_n == -1 or needle[idx_n] == haystack[idx_h]:
                idx_n += 1
                idx_h += 1

            else:
                idx_n = next[idx_n]

        if idx_n < len_n:
            return -1

        return idx_h - len_n

    def gen_next(self, s):
        length = len(s)
        next = [0] * length
        next[0] = -1
        j, k = 0, -1

        while j < length - 1:
            if k == -1 or s[j] == s[k]:
                j += 1
                k += 1
                next[j] = k

            else:
                k = next[k]

        return next
