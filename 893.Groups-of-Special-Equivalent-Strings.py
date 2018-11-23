# https://leetcode.com/problems/groups-of-special-equivalent-strings/description/
#
# algorithms
# Esay (60.0%)
# Total Accepted:    8.1k
# Total Submissions: 13.5k
# beats 100.00% of python submissions


class Solution(object):
    def numSpecialEquivGroups(self, A):
        """
        :type A: List[str]
        :rtype: int
        """
        return len({''.join(sorted(word[::2]))+''.join(sorted(word[1::2])) for word in A})
