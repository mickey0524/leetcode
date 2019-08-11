# https://leetcode.com/problems/day-of-the-year/
# Easy (52.01%)
# Total Accepted:    3,507
# Total Submissions: 6,743
# beats 100.0% of python submissions


class Solution(object):
    def dayOfYear(self, date):
        """
        :type date: str
        :rtype: int
        """
        month_map = {
            1: 31,
            2: 28,
            3: 31,
            4: 30,
            5: 31,
            6: 30,
            7: 31,
            8: 31,
            9: 30,
            10: 31,
            11: 30,
            12: 31,
        }
        year, month, day = map(int, date.split('-'))
        if self.is_leap_year(year):
            month_map[2] = 29

        res = 0
        for i in xrange(1, month):
            res += month_map[i]

        return res + day

    def is_leap_year(self, year):
        if year % 400 == 0:
            return True
        if year % 4 == 0 and year % 100 != 0:
            return True

        return False
