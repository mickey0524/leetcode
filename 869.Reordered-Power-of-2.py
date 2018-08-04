# https://leetcode.com/problems/reordered-power-of-2/description/
#
# algorithms
# Medium (65.2%)
# Total Accepted:    4.1k
# Total Submissions: 8.6k
# beats 91.45% of python submissions


class Solution(object):
    def reorderedPowerOf2(self, N):
        """
        :type N: int
        :rtype: bool
        """
        N = str(N)
        length = len(list(N))
        pow_arr = []

        base = 1
        while True:
            base_str = str(base)
            cnt_length = len(base_str)
            if cnt_length == length:
                pow_arr.append(''.join(sorted(base_str)))
            elif cnt_length > length:
                break
            base <<= 1

        N = ''.join(sorted(N))
        return N in pow_arr


# 这道题TLE了一炮，太蠢了，用递归去匹配字符串，不过这个判断方法is_pow可以记一下

import math

def is_pow(num, backgroud):
    lognum = math.log(num, backgroud)
    int_part = math.floor(lognum)
    if lognum - int_part == 0:
        return True
    return False
