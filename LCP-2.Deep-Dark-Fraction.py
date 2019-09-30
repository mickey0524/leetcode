# https://leetcode-cn.com/problems/deep-dark-fraction/submissions/
# Easy (45.5%)
# beats 100.0 % of python submissions


class Solution(object):
    def fraction(self, cont):
        """
        :type cont: List[int]
        :rtype: List[int]
        """
        length = len(cont)

        molecule, denominator = 1, cont[-1]

        for i in xrange(length - 2, -1, -1):
            tmp = denominator * cont[i] + molecule
            molecule = denominator
            denominator = tmp

        a = max(denominator, molecule)
        b = min(denominator, molecule)

        gcd = self.gcd(a, b)

        return [denominator / gcd, molecule / gcd]

    def gcd(self, a, b):
        if b == 0:
            return a

        return self.gcd(b, a % b)
