# https://leetcode.com/problems/integer-replacement/description/
#
# algorithms
# Medium (30.67%)
# Total Accepted:    34.5k
# Total Submissions: 112.5k
# beats 100.0% of python submissions


class Solution(object):
    def integerReplacement(self, n):
        """
        :type n: int
        :rtype: int
        """
        res = 0
        while n != 1:
            if bin(n)[-1] == '0':
                n = n >> 1
            else:
                if bin(n)[-2] == '1' and len(bin(n)) != 4:
                    n += 1  # if '11' +1
                else:
                    n -= 1  # if '01' -1
            res += 1
        return res
