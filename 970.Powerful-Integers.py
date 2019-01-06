# https://leetcode.com/problems/univalued-binary-tree/
# Easy (33.2%)
# Total Accepted:    2,910
# Total Submissions: 8,765
# beats 100.0% of python submissions


class Solution(object):
    def powerfulIntegers(self, x, y, bound):
        """
        :type x: int
        :type y: int
        :type bound: int
        :rtype: List[int]
        """
        if bound < 2:
            return []
        
        if bound == 2 or (x == 1 and y == 1):
            return [2]
        
        if x == 1:
            x, y = y, x
        
        res = set()
        
        i, j = 0, 0
        
        while True:
            tmp = x ** i
            if tmp > bound:
                break
            i += 1
            j = 1
            while True:
                s = tmp + j
                if s > bound:
                    break
                j *= y
                res.add(s)
                if y == 1:
                    break
        
        return list(res)
                