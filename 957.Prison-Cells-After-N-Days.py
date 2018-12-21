# algorithms
# https://leetcode.com/problems/prison-cells-after-n-days/
# Medium (34.41%)
# Total Accepted:    2,620
# Total Submissions: 7,613
# beats 84.09% of python submissions
# 这道题的思路是遍历过程中会出现循环，找到循环的 interval，就不用一个一个遍历


class Solution(object):
    def prisonAfterNDays(self, cells, N):
        """
        :type cells: List[int]
        :type N: int
        :rtype: List[int]
        """
        hash_map, i = {}, 0

        while i < N:
            key = ''.join(map(str, cells))
            if key in hash_map:
                cells = hash_map[key][0]
                interval = i - hash_map[key][1]
                n = (N - 1 - i) / interval
                i += n * interval
                hash_map[key][1] = i

            else:
                tmp = [0] * 8
                for j in xrange(1, 7):
                    tmp[j] = 1 if cells[j - 1] == cells[j + 1] else 0

                cells = tmp
                hash_map[key] = [tmp, i]

            i += 1

        return cells
