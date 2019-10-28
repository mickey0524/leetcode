# https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/
# Easy (64.08%)
# Total Accepted:    4,134
# Total Submissions: 6,451
# beats 100.0 % of python submissions


"""
   This is the custom function interface.
   You should not implement it, or speculate about its implementation
   class CustomFunction:
       # Returns f(x, y) for any given positive integers x and y.
       # Note that f(x, y) is increasing with respect to both x and y.
       # i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
       def f(self, x, y):
  
"""
class Solution(object):
    def findSolution(self, customfunction, z):
        """
        :type num: int
        :type z: int
        :rtype: List[List[int]]
        """
        res = []
        
        i, j = 1, 1000
        while 1 <= i <= 1000 and 1 <= j <= 1000:
            tmp = customfunction.f(i, j)
            if tmp == z:
                res.append([i, j])
                i += 1
            elif tmp > z:
                j -= 1
            else:
                i += 1
        
        return res
        
