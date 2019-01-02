# https://leetcode.com/problems/length-of-last-word/
#
# algorithms
# Medium (32.09%)
# Total Accepted:    232,624
# Total Submissions: 724,955


class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s.strip()
        
        space_idx = s.rfind(' ')
        
        if space_idx == -1:
            return len(s)
        
        return len(s[space_idx+1:])
        