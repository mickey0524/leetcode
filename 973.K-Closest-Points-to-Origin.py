# https://leetcode.com/problems/k-closest-points-to-origin/
# Easy (69.96%)
# Total Accepted:    4,029
# Total Submissions: 5,759


from heapq import heappush, heappop

class Solution(object):
    def kClosest(self, points, K):
        """
        :type points: List[List[int]]
        :type K: int
        :rtype: List[List[int]]
        """
        length = len(points)
        
        if length <= K:
            return points
        
        h = []
        res = []
        
        for x, y in points:
            heappush(h, (x * x + y * y, x, y))
            if len(h) > length - K:
                smallest = heappop(h)
                res += [smallest[1], smallest[2]],
        
        return res
    