# https://leetcode.com/problems/max-consecutive-ones-iii/
# Medium (51.62%)
# Total Accepted:    4,073
# Total Submissions: 7,890


class Solution(object):
    def longestOnes(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: int
        """
        res = 0

        if K == 0:
            cur_ones = 0
            for n in A:
                if n == 0:
                    res = max(res, cur_ones)
                    cur_ones = 0
                else:
                    cur_ones += 1

            return max(res, cur_ones)

        length = len(A)

        i, j = 0, 0
        zero_idxs = []

        while j < length:
            if A[j] == 0:
                if K > 0:
                    K -= 1
                else:
                    res = max(res, j - i)
                    l_zero_idx = zero_idxs.pop(0)
                    i = l_zero_idx + 1
                zero_idxs += j,

            j += 1

        return max(res, j - i)
