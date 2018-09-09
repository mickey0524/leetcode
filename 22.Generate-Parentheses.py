# https://leetcode.com/problems/generate-parentheses/description/
#
# algorithms
# Medium (50.01%)
# Total Accepted:    242.4K
# Total Submissions: 484.7K
# beats 100.0% of python submissions


class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        def resursive(path, left_num, right_num):
            """
            :type path: str
            :type left_num: int
            :type right_num: int
            :rtype: None
            """
            if left_num == 0 and right_num == 0:
                res.append(path)
                return

            if left_num < right_num:
                resursive(path + ')', left_num, right_num - 1)

            if left_num > 0:
                resursive(path + '(', left_num - 1, right_num)

        res = []

        resursive('', n, n)

        return res
