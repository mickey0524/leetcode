# https://leetcode.com/problems/prime-arrangements/
# Easy (49.91%)
# Total Accepted:    2,666
# Total Submissions: 5,342
# beats 100.0% of python submissions


class Solution(object):
    def numPrimeArrangements(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1

        modulo = 10 ** 9 + 7
        prime = self.count_prime(n)
        not_prime = n - prime

        prime_factorial = self.count_factorial(prime) % modulo
        not_prime_factorial = self.count_factorial(not_prime) % modulo

        return (prime_factorial * not_prime_factorial) % modulo

    def count_factorial(self, n):
        res = 1

        for i in xrange(1, n + 1):
            res *= i

        return res

    def count_prime(self, n):
        flag = [True] * (n + 1)

        for i in xrange(2, n / 2 + 1):
            for j in xrange(2, n / 2 + 1):
                idx = i * j
                if idx > n:
                    break

                flag[idx] = False

        res = 0
        for i in xrange(2, n + 1):
            if flag[i]:
                res += 1

        return res
