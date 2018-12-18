# https://leetcode.com/problems/flip-string-to-monotone-increasing/
#
# algorithms
# Medium (45.36%)
# Total Accepted:    6,269
# Total Submissions: 13,754

class Solution(object):
    def minFlipsMonoIncr(self, S):
        """
        :type S: str
        :rtype: int
        """
        length = len(S)
        if length < 2:
            return 0
        
        nums_left = [0] * 2
        nums_right = [0] * 2
        for i in xrange(0, length):
            if S[i] == '0':
                nums_left[1] += 1
            else:
                nums_left[0] += 1
        
        res = min(nums_left)

        for i in xrange(length - 1, -1, -1):
            if S[i] == '0':
                nums_right[1] += 1
            else:
                nums_left[0] -= 1
            
            res = min(res, nums_left[0] + nums_right[1])
                

        return res
        