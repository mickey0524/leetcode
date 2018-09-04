# https://leetcode.com/problems/monotonic-array/description/
#
# algorithms
# Easy (58.8%)
# Total Accepted:    4.9k
# Total Submissions: 8.3k
# beats 75.07% of python submissions


class Solution(object):
    def isMonotonic(self, A):
        """
        :type A: List[int]
        :rtype: bool
        """
        length = len(A)
        increase = None

        for i in xrange(1, length):
            if A[i] == A[i - 1]:
                pass
            elif increase is None:
                increase = True if A[i] > A[i - 1] else False
            else:
                if (A[i] > A[i - 1] and not increase) or \
                        (A[i] < A[i - 1] and increase):
                    return False

        return True
