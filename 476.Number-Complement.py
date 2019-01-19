# https://leetcode.com/problems/number-complement/
#
# algorithms
# Easy (61.89%)
# Total Accepted:    97,623
# Total Submissions: 157,732
# beats 87.78% of python submissions

class Solution(object):
    def findComplement(self, num):
        """
        :type num: int
        :rtype: int
        """
        binary_num = bin(num)[2:]
        max_num = 1 << len(binary_num)
        
        return max_num - 1 - num
        