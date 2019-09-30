# https://leetcode-cn.com/problems/guess-numbers/
# Easy (83.0%)
# beats 100.0 % of python submissions


class Solution(object):
    def game(self, guess, answer):
        """
        :type guess: List[int]
        :type answer: List[int]
        :rtype: int
        """
        res = 0

        for i in xrange(3):
            if guess[i] == answer[i]:
                res += 1

        return res
