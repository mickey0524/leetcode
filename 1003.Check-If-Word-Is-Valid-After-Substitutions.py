# https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
# Medium (52.57%)
# Total Accepted:    5,063
# Total Submissions: 9,631
# beats 100.0% of python submissions


class Solution(object):
    def isValid(self, S):
        """
        :type S: str
        :rtype: bool
        """
        length = len(S)
        if length % 3 != 0:
            return False

        while 'abc' in S:
            S = S.replace('abc', '')

        return True if len(S) == 0 else False
