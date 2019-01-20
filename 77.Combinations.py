# https://leetcode.com/problems/combinations/
#
# algorithms
# Medium (45.24%)
# Total Accepted:    178,657
# Total Submissions: 394,947
# beats 79.55% of python submissions

class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        res = [[]]
        
        def resursive(length, idx, path):
            if length == k:
                res[0] += path,
                return
                                    
            if k - length > n - idx + 1:
                return
            
            for i in xrange(idx, n + 1):
                resursive(length + 1, i + 1, path + [i])
                
        resursive(0, 1, [])
        
        return res[0]
        