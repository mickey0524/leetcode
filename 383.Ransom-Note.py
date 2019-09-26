# https://leetcode.com/problems/ransom-note/
#
# algorithms
# Easy (50.76%)
# Total Accepted:    124,538
# Total Submissions: 245,370


class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        chs = [0] * 26
        for ch in magazine:
            idx = ord(ch) - 97
            chs[idx] += 1

        for ch in ransomNote:
            idx = ord(ch) - 97
            chs[idx] -= 1
            if chs[idx] < 0:
                return False

        return True
