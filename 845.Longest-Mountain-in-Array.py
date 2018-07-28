# https://leetcode.com/problems/longest-mountain-in-array/description/
#
# algorithms
# Medium (31.4%)
# Total Accepted:    5.9K
# Total Submissions: 18.8K
# beats 95.20% of python submissions


class Solution(object):
    def longestMountain(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        length = len(A)

        if length < 3:
            return 0

        is_downhill = False
        head, tail, res, start = 0, 1, 0, None

        while tail < length:
            if not is_downhill:
                if A[tail] > A[head]:
                    start = head
                    while tail < length and A[tail] > A[head]:
                        head += 1
                        tail += 1
                    if tail == length:
                        return res
                    if A[tail] == A[head]:
                        start = None
                        head += 1
                        tail += 1
                    else:
                        is_downhill = True
                else:
                    head += 1
                    tail += 1
            else:
                while tail < length and A[tail] < A[head]:
                    tail += 1
                    head += 1

                res = max(res, head - start + 1)
                is_downhill = False

        return res
