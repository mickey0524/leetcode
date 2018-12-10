# algorithms
# Medium (25.69%)
# Total Accepted:    1,456
# Total Submissions: 5,666
# beats 100.0% of python submissions

from copy import copy


class Solution(object):
    def minDeletionSize(self, A):
        """
        :type A: List[str]
        :rtype: int
        """
        A_len, str_len, res = len(A), len(A[0]), 0
        is_need_compare = [True] * A_len

        for i in xrange(str_len):
            tmp = copy(is_need_compare)
            for j in xrange(1, A_len):
                if is_need_compare[j]:
                    if A[j][i] < A[j - 1][i]:
                        res += 1
                        is_need_compare = tmp
                        break

                    elif A[j][i] > A[j - 1][i]:
                        is_need_compare[j] = False

        return res
