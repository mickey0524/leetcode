# https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
#
# algorithms
# Hard (22.31%)
# Total Accepted:    13,423
# Total Submissions: 60,163
# beats 75.50% of python submissions


class Solution(object):
    def shortestSubarray(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: int
        """
        res = float('inf')

        cur_k, l = 0, 0

        for idx, n in enumerate(A):
            if n >= K:
                return 1
            cur_k += n
            if cur_k < 0:
                cur_k = 0
                l = idx + 1
                continue

            for i in xrange(idx - 1, -1, -1):
                if A[i + 1] >= 0:
                    break
                A[i] += A[i + 1]
                A[i + 1] = 0

            if cur_k >= K:
                while cur_k >= K:
                    cur_k -= A[l]
                    l += 1

                res = min(res, idx - l + 2)

        return res if res < float('inf') else -1
