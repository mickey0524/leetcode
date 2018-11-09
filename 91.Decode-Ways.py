# https://leetcode.com/problems/two-sum/description/
#
# algorithms
# Medium (21.2%)
# Total Accepted:    211.5k
# Total Submissions: 997.6k
# beats 98.86% of python submissions

class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = len(s)
        if length == 0 or s[0] == '0':
            return 0

        res = [0] * (length + 1)
        res[0] = 1
        res[1] = 1
        
        for i in xrange(2, length + 1):
            if res[i - 1] == 0 and res[i - 2] == 0:
                break
                
            n = 0
                
            if s[i - 1] != '0' and res[i - 1] != 0: # 当前位不为0，且前一位有数值 例如：104
                n += res[i - 1]
            if s[i - 2] != '0' and 1 <= int(s[i-2:i]) <= 26: # 当前两位合法
                n += res[i - 2]
                
            res[i] = n
                            
        return res[length]
            