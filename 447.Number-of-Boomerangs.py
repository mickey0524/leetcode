# https://leetcode.com/problems/number-of-boomerangs/description/
#
# algorithms
# Easy (48.1%)
# Total Accepted:    45.7k
# Total Submissions: 95k
# beats 11.19% of python submissions

class Solution(object):
    def numberOfBoomerangs(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        length = len(points)
        
        if length < 3:
            return 0
        
        res = 0
        
        for i in xrange(length):
            hash_map = {}
            for j in xrange(length):
                if j == i:
                    continue
                dis = self.get_dis(points[i], points[j])
                cnt_arr = hash_map.get(dis, [])
                cnt_arr += j,
                hash_map[dis] = cnt_arr
            for _, arr in hash_map.iteritems():
                arr_len = len(arr)
                res += arr_len * (arr_len - 1)
        
        return res
                
    def get_dis(self, i, j):
        return (i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1])

# 下面是最快的解法，没有必要再遍历一般hash_map，当相同距离的point加入进来的时候，直接加上当前的点数，最后再 * 2，就是结果

class Solution(object):
    def numberOfBoomerangs(self, points):
        result = 0
            
        for x,y in points:
            dist_dict = {}
            for i,j in points:
                distance = (x - i)*(x - i) + (y - j)*(y - j)
                if distance in dist_dict:
                    result += dist_dict[distance]
                    dist_dict[distance] += 1
                else:
                    dist_dict[distance] = 1
    
        return result * 2
