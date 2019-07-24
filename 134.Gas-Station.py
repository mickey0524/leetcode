# https://leetcode.com/problems/gas-station/
#
# algorithms
# Medium (34.42%)
# Total Accepted:    150,549
# Total Submissions: 437,355


class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        length = len(gas)
        if length == 0:
            return -1

        total_sum, cur_sum, res = 0, 0, 0
        for i in xrange(length):
            total_sum += (gas[i] - cost[i])
            cur_sum += (gas[i] - cost[i])

            if cur_sum < 0:
                res = i + 1
                cur_sum = 0

        return -1 if total_sum < 0 else res
