# https://leetcode.com/problems/find-the-difference/description/
#
# algorithms
# Easy (52.06%)
# Total Accepted:    124.1k
# Total Submissions: 238.4k

class Solution(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        length = len(t)
        bit = 0
        
        for i in xrange(length):
            bit ^= ord(t[i])
            if i == length - 1:
                break
            bit ^= ord(s[i])
        
        return chr(bit)
        
        