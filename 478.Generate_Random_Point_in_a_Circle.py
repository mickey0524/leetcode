# https://leetcode.com/problems/generate-random-point-in-a-circle/description/
#
# algorithms
# Medium (33.3%)
# Total Accepted:    2.2k
# Total Submissions: 6.6k
# beats 65.29% of python submissions


from random import uniform


class Solution(object):

    def __init__(self, radius, x_center, y_center):
        """
        :type radius: float
        :type x_center: float
        :type y_center: float
        """
        self.r = radius
        self.x = x_center
        self.y = y_center

    def randPoint(self):
        """
        :rtype: List[float]
        """
        r = random.triangular(0, self.r, self.r)
        theta = random.uniform(-math.pi, math.pi)

        return [self.x + r * math.cos(theta), self.y + r * math.sin(theta)]


# Your Solution object will be instantiated and called as such:
# obj = Solution(radius, x_center, y_center)
# param_1 = obj.randPoint()
