# https://leetcode.com/problems/moving-stones-until-consecutive/
# Easy (26.88%)
# Total Accepted:    2,095
# Total Submissions: 7,795
# beats 100.0% of python submissions


class Solution(object):
    def numMovesStones(self, a, b, c):
        """
        :type a: int
        :type b: int
        :type c: int
        :rtype: List[int]
        """
        arr = [a, b, c]
        arr.sort()
        a, b, c = arr[0], arr[1], arr[2]
        
        minimum_moves, maximum_moves = -1, -1
        if a == b - 1 and b == c - 1:
            minimum_moves = 0
            maximum_moves = 0
        elif a == b - 1 or b == c - 1:
            minimum_moves = 1
            maximum_moves = c - a - 2
        else:
            minimum_moves = 1 if b - a == 2 or c - b == 2 else 2
            maximum_moves = c - a - 2
        
        return [minimum_moves, maximum_moves]
