# https://leetcode.com/problems/partition-array-into-disjoint-intervals/
#
# algorithms
# Medium (43.82%)
# Total Accepted:    13,024
# Total Submissions: 29,719


class Solution(object):
    def partitionDisjoint(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        length = len(A)
        idx = 0
        tmp = 0
        cur_max = A[0]

        while idx < length:
            cur_max_tmp = []
            for i in xrange(idx + 1, length):
                if A[i] < cur_max:
                    tmp = i

                elif A[i] > cur_max:
                    cur_max_tmp += i,

            if not cur_max_tmp or cur_max_tmp[0] > tmp:
                break

            idx = tmp
            for i in cur_max_tmp:
                if i > tmp:
                    break

                cur_max = max(cur_max, A[i])

        return tmp + 1
