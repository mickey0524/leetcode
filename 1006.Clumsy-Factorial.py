# https://leetcode.com/problems/clumsy-factorial/
# Medium (53.74%)
# Total Accepted:    2,548
# Total Submissions: 4,741
# beats 100.0% of python submissions


class Solution(object):
    def clumsy(self, N):
        """
        :type N: int
        :rtype: int
        """
        res = 0
        is_first = True
        
        for i in xrange(N, 0, -4):
            tmp = i
            for j in xrange(1, 4):
                if j - i == 0:
                    break
                if j == 1:
                    tmp *= (i - 1)
                elif j == 2:
                    tmp /= (i - 2)
                else:
                    if is_first:
                        tmp += (i - 3)
                    else:
                        tmp -= (i - 3)
            
            if is_first:
                res = tmp
                is_first = False
            else:
                res -= tmp
                
        return res
    