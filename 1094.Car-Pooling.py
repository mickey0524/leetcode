# https://leetcode.com/problems/car-pooling/
# Easy (56.22%)
# Total Accepted:    3,367
# Total Submissions: 5,989


class Solution(object):
    def carPooling(self, trips, capacity):
        """
        :type trips: List[List[int]]
        :type capacity: int
        :rtype: bool
        """
        trips.sort(key=lambda x: x[1])
        q = []

        for t in trips:
            capacity -= t[0]
            q += t,
            tmp = []
            for q_t in q:
                if q_t[2] <= t[1]:
                    capacity += q_t[0]
                else:
                    tmp += q_t,

            if capacity < 0:
                return False

            q = tmp

        return True
