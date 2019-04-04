# https://leetcode.com/problems/largest-sum-of-averages/
#
# algorithms
# Medium (44.26%)
# Total Accepted:    11,672
# Total Submissions: 26,373


class Solution(object):
    def largestSumOfAverages(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: float
        """
        hash_map = {}
        
        def recursive(n, k):
            if (n, k) in hash_map:
                return hash_map[(n, k)]
            
            if k > n:
                return 0
            
            if k == 1:
                hash_map[(n, k)] = sum(A[:n]) / float(n)
                return hash_map[(n, k)]
            
            cur, hash_map[(n, k)] = 0, 0
            for i in xrange(n - 1, 0, -1):
                cur += A[i]
                hash_map[(n, k)] = max(hash_map[(n, k)], recursive(i, k - 1) + cur / float(n - i))
            
            return hash_map[(n, k)]
            
        return recursive(len(A), K)
        
        
        
        
        
        