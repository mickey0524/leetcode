# https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
# Easy (63.29%)
# Total Accepted:    2,839
# Total Submissions: 4,486
# beats 100.0% of python submissions


class Solution(object):
    def numSmallerByFrequency(self, queries, words):
        """
        :type queries: List[str]
        :type words: List[str]
        :rtype: List[int]
        """
        length = len(queries)
        res = [0] * length
        words_f = [self.f(w) for w in words]

        for idx, q in enumerate(queries):
            f_res = self.f(q)
            tmp = 0
            for n in words_f:
                if f_res < n:
                    tmp += 1

            res[idx] = tmp

        return res

    def f(self, w):
        tmp = [0] * 26
        for ch in w:
            idx = ord(ch) - 97
            tmp[idx] += 1

        for n in tmp:
            if n > 0:
                return n
