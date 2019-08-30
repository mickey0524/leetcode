# https://leetcode.com/problems/super-pow/
#
# algorithms
# Medium (35.89%)
# Total Accepted:    29,476
# Total Submissions: 82,122


class Solution(object):
    def superPow(self, a, b):
        """
        :type a: int
        :type b: List[int]
        :rtype: int
        """
        power = int(''.join(map(str, b)))

        return self.handler(a, power)

    def handler(self, a, b):
        if b == 1:
            return a

        sub_res = self.handler(a, b / 2)

        if b & 1 == 1:
            ans = sub_res * sub_res * a
        else:
            ans = sub_res * sub_res

        return ans % 1337
