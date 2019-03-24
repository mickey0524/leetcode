# https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
# Easy (47.22%)
# Total Accepted:    2,951
# Total Submissions: 6,250
# beats 100.0% of python submissions


class Solution(object):
    def canThreePartsEqualSum(self, A):
        """
        :type A: List[int]
        :rtype: bool
        """
        s = sum(A)

        if s % 3 != 0:
            return False

        target = s / 3

        cur_s, p = 0, 0

        for idx, n in enumerate(A):
            cur_s += n
            if cur_s == target:
                cur_s = 0
                p += 1
                if p == 2:
                    return True if sum(A[idx+1:]) == target else False

        return False
