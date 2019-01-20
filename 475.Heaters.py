# https://leetcode.com/problems/heaters/
#
# algorithms
# Easy (30.79%)
# Total Accepted:    41,152
# Total Submissions: 133,635
# beats 99.53% of python submissions

class Solution(object):
    def findRadius(self, houses, heaters):
        """
        :type houses: List[int]
        :type heaters: List[int]
        :rtype: int
        """
        houses.sort()
        heaters.sort()

        res = 0

        heater_idx = 0
        heaters_len = len(heaters)

        for h in houses:
            while heater_idx < heaters_len and heaters[heater_idx] < h:
                heater_idx += 1
            if heater_idx == 0:
                res = max(res, heaters[heater_idx] - h)
            elif heater_idx == heaters_len:
                res = max(res, houses[-1] - heaters[-1])
                break
            else:
                if heaters[heater_idx - 1] + res < h < heaters[heater_idx] - res:
                    res = min(h - heaters[heater_idx - 1], heaters[heater_idx] - h)

        return res
