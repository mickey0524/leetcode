# https://leetcode.com/problems/find-the-town-judge/
# Easy (49.39%)
# Total Accepted:    32,301
# Total Submissions: 65,395
# beats 100.0% of python submissions


class Solution(object):
    def findJudge(self, N, trust):
        """
        :type N: int
        :type trust: List[List[int]]
        :rtype: int
        """
        trust_num = [0] * (N + 1)

        for a, b in trust:
            trust_num[a] -= 1
            trust_num[b] += 1

        for i in xrange(1, N + 1):

            if trust_num[i] == N - 1:
                return i

        return -1
