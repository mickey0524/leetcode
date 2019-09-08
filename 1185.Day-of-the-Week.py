# https://leetcode.com/problems/day-of-the-week/
# Easy (65.59%)
# Total Accepted:    3,145
# Total Submissions: 4,795


class Solution(object):
    def dayOfTheWeek(self, day, month, year):
        """
        :type day: int
        :type month: int
        :type year: int
        :rtype: str
        """
        base_year = 1971
        days_per_month = {
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

        year_diff_to_days = 365 * (year - base_year)
        month_diff_to_days = 0
        for i in xrange(1, month):
            month_diff_to_days += days_per_month[i]

        days = year_diff_to_days + month_diff_to_days + day

        for i in xrange(1972, year, 4):
            days += 1

        if year >= 1972 and (year - 1972) % 4 == 0 and month > 2:
            days += 1

        days %= 7

        if days == 1:
            return 'Friday'

        if days == 2:
            return 'Saturday'

        if days == 3:
            return 'Sunday'

        if days == 4:
            return 'Monday'

        if days == 5:
            return 'Tuesday'

        if days == 6:
            return 'Wednesday'

        return "Thursday"
