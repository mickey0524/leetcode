# https://leetcode.com/problems/3sum-with-multiplicity/
#
# algorithms
# Medium (29.23%)
# Total Accepted:    4,840
# Total Submissions: 16,558

from collections import Counter
from itertools import combinations_with_replacement


class Solution(object):
    def threeSumMulti(self, A, target):
        c = Counter(A)
        res = 0
        for i, j in combinations_with_replacement(c, 2):
            k = target - i - j
            if i == j == k:
                res += c[i] * (c[i] - 1) * (c[i] - 2) / 6
            elif i == j != k:
                res += c[i] * (c[i] - 1) / 2 * c[k]
            elif k > i and k > j:
                res += c[i] * c[j] * c[k]
        return res % (10**9 + 7)
