# https://leetcode.com/problems/bitwise-ors-of-subarrays/
#
# algorithms
# Medium (32.02%)
# Total Accepted:    5,616
# Total Submissions: 17,538

class Solution(object):
    def subarrayBitwiseORs(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        cur, res = set(), set()
        
        for n in A:
            cur = {i | n for i in cur} | {n}
            res |= cur
        
        return len(res)
        