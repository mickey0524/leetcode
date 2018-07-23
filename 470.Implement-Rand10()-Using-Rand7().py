# https://leetcode.com/problems/implement-rand10-using-rand7/
#
# algorithms
# Medium (45.6%)
# Total Accepted:    630
# Total Submissions: 1.4K

# The rand7() API is already defined for you.
# def rand7():
# @return a random integer in the range 1 to 7

class Solution(object):
    def rand10(self):
        """
        :rtype: int
        """
        i, j = rand7(), rand7()

        if i == 7 or (i == 6 and j > 5):
          return self.rand10()

        return (((i - 1) * 7 + j) % 10) + 1


class Solution(object):
    def rand10(self):
        """
        :rtype: int
        """
        num = (rand7() - 1) * 7 + rand7()
        if num > 40:
            return self.rand10()
        
        return num % 10 + 1

        