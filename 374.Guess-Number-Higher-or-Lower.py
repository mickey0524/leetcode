# https://leetcode.com/problems/guess-number-higher-or-lower/
#
# algorithms
# Easy (38.29%)
# Total Accepted:    94,409
# Total Submissions: 246,815

# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num):

class Solution(object):
    def guessNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        head, tail, middle = 1, n, None
        
        while head <= tail:
            middle = head + (tail - head) / 2
            guess_res = guess(middle)
            print head, tail, middle, guess_res
            if guess_res == 0:
                return middle
            elif guess_res == 1:
                head = middle + 1
            else:
                tail = middle
        
        