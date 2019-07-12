# https://leetcode.com/problems/scramble-string/
#
# algorithms
# Hard (31.83%)
# Total Accepted:    92,440
# Total Submissions: 290,420


class Solution(object):
    def isScramble(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        length = len(s1)

        if s1 == s2:
            return True

        chs = [0] * 26
        for ch in s1:
            chs[ord(ch) - 97] += 1

        for ch in s2:
            chs[ord(ch) - 97] -= 1

        for n in chs:
            if n != 0:
                return False

        for i in xrange(1, length):
            if self.isScramble(s1[i:], s2[i:]) and self.isScramble(s1[:i], s2[:i]):
                return True

            if self.isScramble(s1[:i], s2[length - i:]) and self.isScramble(s1[i:], s2[:length - i]):
                return True

        return False