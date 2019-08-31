# https://leetcode.com/problems/add-binary/
#
# algorithms
# Easy (40.29%)
# Total Accepted:    331,633
# Total Submissions: 823,154


class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        res = []
        len_a, len_b = len(a), len(b)

        carry = 0
        idx_a, idx_b = 0, 0
        while idx_a < len_a or idx_b < len_b:
            bit_a = int(a[len_a - 1 - idx_a]) if idx_a < len_a else 0
            bit_b = int(b[len_b - 1 - idx_b]) if idx_b < len_b else 0
            bit_sum = bit_a + bit_b + carry

            if bit_sum >= 2:
                carry = 1
                bit_sum -= 2
            else:
                carry = 0

            res.append(str(bit_sum))

            idx_a += 1
            idx_b += 1

        if carry == 1:
            res.append('1')

        return ''.join(reversed(res))
