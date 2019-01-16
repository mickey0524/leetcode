# https://leetcode.com/problems/max-points-on-a-line/
#
# algorithms
# Hard (15.43%)
# Total Accepted:    109,228
# Total Submissions: 707,757
# 思路是计算斜率，不能直接相除，这样容易丢失精度
# 将 y2 - y1, x2 - x1 除 gcd，然后保存 tuple
# 这样才能得到准确的 answer

import math

class Solution:
    def maxPoints(self, points):
        """
        :type points: List[Point]
        :rtype: int
        """
        
        if len(points) <= 2:
            return len(points)
        
        max_points = 0
        
        for i in range(len(points)):
            hist = {}
            
            for j in range(i+1, len(points)):
                slope = self.calc_slope(points[i], points[j])
                hist[slope] = hist.get(slope, 0) + 1
            
            max_using_point_i = 0
            for k, v in hist.items():
                if k != 'overlap':
                    max_using_point_i = max(max_using_point_i, v)
            max_using_point_i += 1 + hist.get('overlap', 0)
            max_points = max(max_points, max_using_point_i)
        
        return max_points
    
    def calc_slope(self, p1, p2):
        x1, y1 = p1.x, p1.y
        x2, y2 = p2.x, p2.y
        deltaY = y2 - y1
        deltaX = x2 - x1
        
        if deltaX == 0 and deltaY == 0:
            return 'overlap'
        if deltaX == 0:
            return 'vertical'
        
        is_neg = deltaY * deltaX < 0
        
        div = abs(math.gcd(deltaX, deltaY))
        
        if is_neg:
            return abs(deltaY) // div, -abs(deltaX) // div
        return abs(deltaY) // div, abs(deltaX) // div