# https://leetcode.com/problems/arithmetic-slices/
#
# algorithms
# Medium (55.27%)
# Total Accepted:    57,459
# Total Submissions: 103,958
# beats 100.0% of python submissions


class Solution(object):
    def numberOfArithmeticSlices(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        length = len(A)
        if length < 3:
            return 0

        fragment_len = []
        i, j = 0, 1

        while j < length:
            while j + 1 < length and A[j + 1] - A[j] == A[j] - A[j - 1]:
                j += 1

            if j - i + 1 > 2:
                fragment_len += j - i + 1,

            if j == length - 1:
                break

            i = j
            j += 1

        res = 0
        for n in fragment_len:
            begin = n - 2
            while begin > 0:
                res += begin
                begin -= 1

        return res
