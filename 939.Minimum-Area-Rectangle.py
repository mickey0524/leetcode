# https://leetcode.com/problems/minimum-area-rectangle/
#
# algorithms
# Medium (41.69%)
# Total Accepted:    5,326
# Total Submissions: 12,191
# 思路是用 hash_map 保留每一行点的 y 坐标，然后遍历行级 arr，得到 y 坐标对
# 如果后面行和当前行的 y 坐标对上了，就说明能组成一个长方形

class Solution(object):
    def minAreaRect(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        n = len(points)
        nx = len(set(x for x, y in points))
        ny = len(set(y for x, y in points))
        if nx == n or ny == n:
            return 0

        p = collections.defaultdict(list)
        if nx > ny:
            for x, y in points:
                p[x].append(y)
        else:
            for x, y in points:
                p[y].append(x)

        lastx = {}
        res = float('inf')
        for x in sorted(p):
            p[x].sort()
            for i in range(len(p[x])):
                for j in range(i):
                    y1, y2 = p[x][j], p[x][i]
                    if (y1, y2) in lastx:
                        res = min(res, (x - lastx[y1, y2]) * (y2 - y1))
                    lastx[y1, y2] = x
        return res if res < float('inf') else 0 


from collections import defaultdict
from bisect import insort

class Solution1(object):
    def minAreaRect(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        col_m = defaultdict(list)
        row_m = {}
        
        for x, y in points:
            insort(col_m[x], y)
            if y not in row_m:
                row_m[y] = {}
            row_m[y][x] = True
        # print col_m, row_m
        res = float('inf')
        keys = col_m.keys()
        keys.sort()
        length = len(keys)
        # print keys
        for i in xrange(length - 1):
            for j in xrange(i + 1, length):
                pre = -1
                for y in col_m[keys[i]]:
                    if keys[j] not in row_m[y]:
                        continue
                    
                    if pre != -1:
                        # print i, j, pre, y
                        res = min((keys[j] - keys[i]) * (y - pre), res)
                        
                    pre = y
        
        return 0 if res == float('inf') else res
                