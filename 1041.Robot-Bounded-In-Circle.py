# https://leetcode.com/problems/robot-bounded-in-circle/
# Easy (36.23%)
# Total Accepted:    2,329
# Total Submissions: 6,428
# beats 100.0% of python submissions


class Solution(object):
    def isRobotBounded(self, instructions):
        """
        :type instructions: str
        :rtype: bool
        """
        x, y = 0, 0
        x_d, y_d = 0, 1

        for _ in xrange(4):
            for f in instructions:
                if f == 'G':
                    x = x + x_d
                    y = y + y_d
                elif f == 'L':
                    if x_d == 0 and y_d == 1:
                        x_d, y_d = -1, 0
                    elif x_d == -1 and y_d == 0:
                        x_d, y_d = 0, -1
                    elif x_d == 0 and y_d == -1:
                        x_d, y_d = 1, 0
                    else:
                        x_d, y_d = 0, 1
                else:
                    if x_d == 0 and y_d == 1:
                        x_d, y_d = 1, 0
                    elif x_d == 1 and y_d == 0:
                        x_d, y_d = 0, -1
                    elif x_d == 0 and y_d == -1:
                        x_d, y_d = -1, 0
                    else:
                        x_d, y_d = 0, 1

            if x == 0 and y == 0:
                return True

        return False
