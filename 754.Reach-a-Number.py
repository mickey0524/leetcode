# https://leetcode.com/problems/reach-a-number/description/
#
# algorithms
# Easy (29.35%)
# Total Accepted:    5.4K
# Total Submissions: 18.4K
# beats 42.68% of python submissions
# 这道题首先肯定判断 1 + 2 + 3 + ... + x的等差数列和是否等于target，如果等于，直接返回
# 然后判断和与target的差是否能够整除2，如果可以的话，也可以直接返回，因为差值可以由前面数目
# 的符号改变来抹平，比如差值为4，则可以由 -2 + 3来抹平
# 最后再根据x + 1取余2来判断结果需要 + 1还是 + 2


class Solution(object):
    def reachNumber(self, target):
        """
        :type target: int
        :rtype: int
        """
        if target == 0:
            return 0

        pos, step = 0, 0
        if target < 0:
            target = -target

        while pos < target:
            step += 1
            pos += step

        if pos == target or (pos - target) % 2 == 0:
            return step

        return step + 1 if (step + 1) % 2 == 1 else step + 2
