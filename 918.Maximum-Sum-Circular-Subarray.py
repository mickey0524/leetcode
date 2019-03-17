# https://leetcode.com/problems/maximum-sum-circular-subarray/
#
# algorithms
# Medium (53.97%)
# Total Accepted:    8,055
# Total Submissions: 26,569

# 我的做法直接去做，比较蠢，不过也能 AC
class Solution(object):
    def maxSubarraySumCircular(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        length = len(A)

        if length == 0:
            return 0

        if length == 1:
            return A[0]

        res, tmp = A[0], A[0]
        left = [A[0]] * length
        left_tmp = 0
        right = [A[-1]] * length

        for i in xrange(1, length):
            left_tmp += A[i - 1]
            left[i] = max(left_tmp, left[i - 1])
            if tmp < 0:
                tmp = A[i]
            else:
                tmp += A[i]
            res = max(tmp, res)

        right_tmp = 0
        for i in xrange(length - 2, -1, -1):
            right_tmp += A[i + 1]
            right[i] = max(right_tmp, right[i + 1])

        for i in xrange(length):
            res = max(res, left[i] + right[i])

        return res


# 最大字段和 - 最小字段和s
class Solution1(object):
    def maxSubarraySumCircular(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        length = len(A)

        if length == 0:
            return 0

        if length == 1:
            return A[0]

        max_array_s, tmp = A[0], A[0]

        for i in xrange(1, length):
            if tmp < 0:
                tmp = A[i]
            else:
                tmp += A[i]
            max_array_s = max(tmp, max_array_s)

        s = sum(A)
        A[0] = A[-1] = float('inf')
        min_array_s, tmp = A[0], A[0]

        for i in xrange(1, length):
            n = tmp + A[i]
            if n > A[i]:
                tmp = A[i]
            else:
                tmp = n

            min_array_s = min(min_array_s, tmp)

        return max(max_array_s, s - min_array_s)
