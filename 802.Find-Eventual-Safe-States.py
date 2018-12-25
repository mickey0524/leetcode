# https://leetcode.com/problems/monotonic-array/description/
#
# algorithms
# Medium (41.26%)
# Total Accepted:    11,944
# Total Submissions: 28,646

class Solution(object):
    def eventualSafeNodes(self, graph):
        """
        :type graph: List[List[int]]
        :rtype: List[int]
        """
        length = len(graph)
        flag = [0] * length
        res = []        
        
        def dfs(idx):
            flag[idx] = 1
            
            for i in graph[idx]:
                if flag[i] == 2:
                    continue
                if flag[i] == 1:
                    return False
                if not dfs(i):
                    return False
            
            flag[idx] = 2
            res.append(idx)
            return True
        
        for i in xrange(length):
            if flag[i] == 0:
                dfs(i)
        
        return sorted(res)
    