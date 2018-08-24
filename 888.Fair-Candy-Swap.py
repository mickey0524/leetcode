# https://leetcode.com/problems/fair-candy-swap/description/
#
# algorithms
# Easy (57.0%)
# Total Accepted:    4.8k
# Total Submissions: 8.4k


from collections import Counter


class Solution(object):
    def fairCandySwap(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        sum_A, sum_B = sum(A), sum(B)
        counter_B = Counter(B)

        diff = (sum_A - sum_B) / 2

        for i in A:
            if counter_B.has_key(i - diff):
                return [i, i - diff]
