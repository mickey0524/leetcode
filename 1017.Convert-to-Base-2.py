# https://leetcode.com/problems/convert-to-base-2/  
# Medium (53.76%)
# Total Accepted:    3,043
# Total Submissions: 5,660


class Solution(object):
    def baseNeg2(self, N):
        """
        :type N: int
        :rtype: str
        """
        if N <= 1:
            return str(N)
        
        res = ''
        
        while N != 0:
            if N % 2 == 1:
                res = '1' + res
                N -= 1
            else:
                res = '0' + res
            N /= (-2)
        
        return res