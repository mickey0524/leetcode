# https://leetcode.com/problems/shifting-letters/description/
#
# algorithms
# Medium (35.1%)
# Total Accepted:    5K
# Total Submissions: 14.3K
# beats 10.0% of python submissions

# way1

class Solution(object):
    def shiftingLetters(self, S, shifts):
        """
        :type S: str
        :type shifts: List[int]
        :rtype: str
        """
        def get_char(char, num):
            return chr((ord(char) - 97 + num) % 26 + 97)

        length = len(shifts)
        res = get_char(S[-1], shifts[-1])

        for i in xrange(length - 2, -1, -1):
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26
            res = get_char(S[i], shifts[i]) + res

        return res


# way2

from itertools import izip


class Solution(object):
    def shiftingLetters(self, S, shifts):
        """
        :type S: str
        :type shifts: List[int]
        :rtype: str
        """
        for i in range(len(shifts) - 1)[::-1]:
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26

        return ''.join([chr((ord(char) - 97 + num) % 26 + 97) for char, num in izip(S, shifts)])
