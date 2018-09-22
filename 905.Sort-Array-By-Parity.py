# https://leetcode.com/problems/sort-array-by-parity/description/
#
# algorithms
# Easy (73.57%)
# Total Accepted:    10.3k
# Total Submissions: 14k
# beats 72.87% of python submissions


class Solution(object):
    def sortArrayByParity(self, A):
        """
        :type A: List[int]
        :rtype: List[int]
        """
        length = len(A)

        if length <= 1:
            return A

        head, tail = 0, length - 1

        while head < tail:
            while head < tail and A[head] & 1 == 0:
                head += 1
            while tail > head and A[tail] & 1 == 1:
                tail -= 1
            A[head], A[tail] = A[tail], A[head]
            head += 1
            tail -= 1

        return A
