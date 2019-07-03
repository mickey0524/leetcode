# https://leetcode.com/problems/missing-number/
#
# algorithms
# Easy (24.49%)
# Total Accepted:    106,816
# Total Submissions: 436,070

from collections import OrderedDict


class Solution(object):
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0:
            return 'Zero'

        one_place = {idx: eng for idx, eng in enumerate(
            ['Zero', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine'])}
        ten_place = {idx + 1: eng for idx, eng in enumerate(
            ['Ten', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety'])}
        ten_place_1 = {
            11: 'Eleven',
            12: 'Twelve',
            13: 'Thirteen',
            14: 'Fourteen',
            15: 'Fifteen',
            16: 'Sixteen',
            17: 'Seventeen',
            18: 'Eighteen',
            19: 'Nineteen',
        }

        unit = OrderedDict([
            (1000000000, 'Billion'),
            (1000000, 'Million'),
            (1000, 'Thousand'),
            (100, 'Hundred'),
        ])

        res = ''
        while num >= 100:
            for u, eng in unit.iteritems():
                if num >= u:
                    n = num / u
                    num %= u
                    if n > 0:
                        res += ' ' + self.numberToWords(n)
                    res += ' ' + eng

        if num in ten_place_1:
            res += ' ' + ten_place_1[num]
            return res.strip()

        if num >= 10:
            res += ' ' + ten_place[num / 10]

        if num > 0 and num % 10 != 0:
            res += ' ' + one_place[num % 10]

        return res.strip()
