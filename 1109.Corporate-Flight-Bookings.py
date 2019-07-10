# https://leetcode.com/problems/corporate-flight-bookings/
# Medium (45.89%)
# Total Accepted:    4,406
# Total Submissions: 9,601


class Solution(object):
    def corpFlightBookings(self, bookings, n):
        """
        :type bookings: List[List[int]]
        :type n: int
        :rtype: List[int]
        """
        res = [0] * n

        start_map, end_map = {}, {}
        for b in bookings:
            start_map[b[0] - 1] = start_map.get(b[0] - 1, 0) + b[2]
            end_map[b[1] - 1] = end_map.get(b[1] - 1, 0) + b[2]

        seats = 0

        for i in xrange(n):
            if i in start_map:
                seats += start_map[i]

            res[i] = seats

            if i in end_map:
                seats -= end_map[i]

        return res
