# https://leetcode.com/problems/plus-one/
#
# algorithms
# Easy (41.61%)
# Total Accepted:    434,239
# Total Submissions: 1,043,613


class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        length = len(digits)
        carry = 1

        for i in xrange(length - 1, -1, -1):
            tmp = digits[i] + 1
            if tmp < 10:
                digits[i] = tmp
                carry = 0
                break

            else:
                carry = 1
                digits[i] = tmp - 10

        if carry == 1:
            digits.insert(0, 1)

        return digits
