# https://leetcode.com/problems/monotonic-array/description/
#
# algorithms
# Medium (42.6%)
# Total Accepted:    4.8k
# Total Submissions: 11.2k
# beats 77.52% of python submissions


class Solution(object):
    def largestOverlap(self, A, B):
        """
        :type A: List[List[int]]
        :type B: List[List[int]]
        :rtype: int
        """
        length = len(A)
        A_1_arr, B_1_arr = [], []

        for i in xrange(length):
            for j in xrange(length):
                if A[i][j] == 1:
                    A_1_arr.append((i, j))
                if B[i][j] == 1:
                    B_1_arr.append((i, j))

        res = 0

        for i in xrange(length):
            for j in xrange(length):
                cnt_sum_A, cnt_sum_B = 0, 0
                for x, y in A_1_arr:
                    if x + i < length and y + j < length and B[x + i][y + j] == 1:
                        cnt_sum_A += 1
                for x, y in B_1_arr:
                    if x + i < length and y + j < length and A[x + i][y + j] == 1:
                        cnt_sum_B += 1
                res = max(res, cnt_sum_A, cnt_sum_B)

        return res
