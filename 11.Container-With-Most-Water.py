# https://leetcode.com/problems/container-with-most-water/
#
# algorithms
# Medium (44.59%)
# Total Accepted:    373,155
# Total Submissions: 836,799


class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        length = len(height)
        if length == 2:
            return min(height)
        
        res = float('-inf')
        i, j = 0, length - 1
        width = length - 1
        
        while i < j:
            if height[i] < height[j]:
                res = max(res, width * height[i])
                i += 1
            else:
                res = max(res, width * height[j])
                j -= 1
            width -= 1
        
        return res
        