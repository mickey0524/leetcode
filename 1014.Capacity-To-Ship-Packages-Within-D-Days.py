# https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
# Medium (48.32%)
# Total Accepted:    2,832
# Total Submissions: 5,861
# 个人觉得这道题应该是 Hard 难度

class Solution(object):
    def shipWithinDays(self, weights, D):
        """
        :type weights: List[int]
        :type D: int
        :rtype: int
        """
        max_w = max(weights)
        sum_w = sum(weights)
        m = -1
        l, r = max_w, sum_w

        while l <= r:
            m = l + (r - l) / 2
            if self.can_ship(weights, m, D):
                r = m - 1
            else:
                l = m + 1

        if l > sum_w:
            return sum_w
        if l < max_w:
            return max_w

        return l

    def can_ship(self, weights, cap, D):
        cur_w = 0

        for w in weights:
            tmp = w + cur_w
            if tmp < cap:
                cur_w += w
            elif tmp == cap:
                cur_w = 0
                D -= 1
                if D == 0:
                    return False
            else:
                if D == 1:
                    return False
                else:
                    D -= 1
                    cur_w = w

        return True
