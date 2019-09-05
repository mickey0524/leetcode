# https://leetcode.com/problems/sum-of-subarray-minimums/
#
# algorithms
# Medium (29.03%)
# Total Accepted:    13,901
# Total Submissions: 47,883


from collections import deque


class Solution(object):
    def sumSubarrayMins(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        length = len(A)
        l_2_r = [-1] * length
        r_2_l = [-1] * length

        s = deque([0])
        for i in xrange(1, length):
            while s and A[i] < A[s[-1]]:
                idx = s.pop()
                l_2_r[idx] = i - 1

            s.append(i)

        while s:
            idx = s.pop()
            l_2_r[idx] = length - 1

        s = deque([length - 1])
        for i in xrange(length - 2, -1, -1):
            while s and A[i] <= A[s[-1]]:
                idx = s.pop()
                r_2_l[idx] = i + 1

            s.append(i)

        while s:
            idx = s.pop()
            r_2_l[idx] = 0
        # print l_2_r, r_2_l
        res = 0
        for i in xrange(length):
            l_len = i - r_2_l[i] + 1
            r_len = l_2_r[i] - i + 1
            res += (l_len * r_len) * A[i]

        return res % (10 ** 9 + 7)
