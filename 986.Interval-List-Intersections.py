# https://leetcode.com/problems/interval-list-intersections/
# Medium (56.68%)
# Total Accepted:    2,740
# Total Submissions: 4,834
# beats 100.0% of python submissions

class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution(object):
    def intervalIntersection(self, A, B):
        """
        :type A: List[Interval]
        :type B: List[Interval]
        :rtype: List[Interval]
        """
        A_len, B_len = len(A), len(B)
        A_idx, B_idx = 0, 0
        res = []

        while A_idx < A_len and B_idx < B_len:
            if A[A_idx].start > B[B_idx].end:
                B_idx += 1
            elif B[B_idx].start > A[A_idx].end:
                A_idx += 1
            else:
                left = max(A[A_idx].start, B[B_idx].start)
                right = min(A[A_idx].end, B[B_idx].end)
                res += Interval(left, right),
                if A[A_idx].end < B[B_idx].end:
                    A_idx += 1
                else:
                    B_idx += 1

        return res
