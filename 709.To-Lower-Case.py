# https://leetcode.com/problems/to-lower-case/description/
#
# algorithms
# Easy (74.44%)
# Total Accepted:    26.5K
# Total Submissions: 35.6K
# beats 93.88% of python submissions


class Solution(object):
    def toLowerCase(self, str):
        """
        :type str: str
        :rtype: str
        """
        return ''.join([chr(ord(ch) + 32) if 90 >= ord(ch) >= 65 else ch for ch in str])
