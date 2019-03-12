# https://leetcode.com/problems/different-ways-to-add-parentheses/
#
# algorithms
# Hard (48.98%)
# Total Accepted:    69,070
# Total Submissions: 141,016
# beats 100.0% of python submissions


class Solution(object):
    def __init__(self):
        self.hash_map = {}

    def diffWaysToCompute(self, input):
        """
        :type input: str
        :rtype: List[int]
        """
        if input in self.hash_map:
            return self.hash_map[input]

        left, right, res = [], [], []
        for idx, ch in enumerate(input):
            if ch == '+' or ch == '-' or ch == '*':
                left, right = self.diffWaysToCompute(input[:idx]), self.diffWaysToCompute(input[idx+1:])
                for i in left:
                    for j in right:
                        if ch == '+':
                            res += i + j,
                        elif ch == '-':
                            res += i - j,
                        else:
                            res += i * j,

        if len(left) == 0 and len(right) == 0:
            return [int(input)]
        
        # res.sort()
        self.hash_map[input] = res

        return res
