# https://leetcode.com/problems/get-equal-substrings-within-budget/
# Medium (33.86%)
# Total Accepted:    5,086
# Total Submissions: 15,019
# beats 100.0 % of python submissions


class Solution(object):
    def equalSubstring(self, s, t, maxCost):
        """
        :type s: str
        :type t: str
        :type maxCost: int
        :rtype: int
        """
        length = len(s)
        cost = [0] * length

        for i in xrange(length):
            cost[i] = abs(ord(s[i]) - ord(t[i]))

        res = 0
        cur_cost = 0
        left_idx = 0

        for i in xrange(length):
            tmp = cur_cost + cost[i]
            if tmp > maxCost:
                res = max(res, i - left_idx)
                while tmp > maxCost:
                    tmp -= cost[left_idx]
                    left_idx += 1

            cur_cost = tmp

        res = max(res, length - left_idx)

        return res
