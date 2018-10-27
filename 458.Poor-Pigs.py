# https://leetcode.com/problems/poor-pigs/description/
#
# algorithms
# Easy (43.72%)
# Total Accepted:    12.9k
# Total Submissions: 29.5k
# beats 88.59% of python submissions

import math

class Solution(object):
    def poorPigs(self, buckets, minutesToDie, minutesToTest):
        """
        :type buckets: int
        :type minutesToDie: int
        :type minutesToTest: int
        :rtype: int
        """
        try_num = minutesToTest / minutesToDie + 1

        return (int)(math.ceil(math.log(buckets) / math.log(try_num)))
