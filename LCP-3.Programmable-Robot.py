# https://leetcode-cn.com/problems/programmable-robot/submissions/
# Medium (11.9%)
# beats 100.0 % of python submissions


from collections import defaultdict


class Solution(object):
    def robot(self, command, obstacles, x, y):
        """
        :type command: str
        :type obstacles: List[List[int]]
        :type x: int
        :type y: int
        :rtype: bool
        """
        u_num, r_num = 0, 0
        hash_map = defaultdict(list)
        hash_map[0].append(0)
        for c in command:
            if c == 'U':
                u_num += 1
            else:
                r_num += 1

            hash_map[r_num].append(u_num)

        def is_point_in_line(x, y):
            x_loop, x_step = x / r_num, x % r_num

            exist = False
            for y_n in hash_map[x_step]:
                if y_n + u_num * x_loop == y:
                    exist = True
                    break

            return exist

        if not is_point_in_line(x, y):
            return False

        for a, b in obstacles:
            if a <= x and b <= y and is_point_in_line(a, b):
                return False

        return True
