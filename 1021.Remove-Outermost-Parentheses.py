# https://leetcode.com/problems/remove-outermost-parentheses/
# Easy (84.8%)
# Total Accepted:    4,648
# Total Submissions: 5,481

class Solution(object):
    def removeOuterParentheses(self, S):
        """
        :type S: str
        :rtype: str
        """
        length = len(S)
        if length == 0:
            return ''
        
        symbol = 0
        last_idx = 0
        res = ''
        
        for i in xrange(length):
            if S[i] == ')':
                symbol -= 1
            else:
                symbol += 1
            
            if symbol == 0:
                res += S[last_idx + 1:i]
                last_idx = i + 1
        
        return res
        