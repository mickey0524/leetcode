# https://leetcode.com/problems/n-th-tribonacci-number/
# Easy (64.08%)
# Total Accepted:    4,509
# Total Submissions: 7,036


class Solution(object):
    def tribonacci(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 1:
            return n
        
        if n == 2:
            return 1
        
        st, nd, rd = 0, 1, 1
        for i in xrange(3, n + 1):
            tmp = st + nd + rd
            st = nd
            nd = rd
            rd = tmp
        
        return rd
