# https://leetcode.com/problems/sum-of-even-numbers-after-queries/
# Easy (69.88%)
# Total Accepted:    3,035
# Total Submissions: 4,343
# beats 100.0% of python submissions


class Solution(object):
    def sumEvenAfterQueries(self, A, queries):
        """
        :type A: List[int]
        :type queries: List[List[int]]
        :rtype: List[int]
        """
        cur_even_sum = 0
        for n in A:
            if n & 1 == 0:
                cur_even_sum += n

        answer = []

        for val, index in queries:
            if A[index] & 1 == 0:
                cur_even_sum -= A[index]
            A[index] += val
            if A[index] & 1 == 0:
                cur_even_sum += A[index]
            answer += cur_even_sum,

        return answer
