# https://leetcode.com/problems/fraction-addition-and-subtraction/description/
#
# algorithms
# Medium (46.15%)
# Total Accepted:    10.2k
# Total Submissions: 22.12k


import re


class Solution(object):
    def fractionAddition(self, expression):
        """
        :type expression: str
        :rtype: str
        """
        def get_hcf(x, y):
           # 获取最小值
            if x > y:
                smaller = y
            else:
                smaller = x
            hcf = 1
            for i in xrange(1, smaller + 1):
                if((x % i == 0) and (y % i == 0)):
                    hcf = i
            return hcf

        if expression == '':
            return '0/1'

        expression = expression[0] + expression[1:].replace('-', '+-')

        pattern = re.compile(r'\+')
        fraction_arr = re.split(pattern, expression)
        res_child, res_parent = 0, 1

        for fraction in fraction_arr:
            fraction_child, fraction_parent = map(int, fraction.split('/'))
            res_child = fraction_child * res_parent + res_child * fraction_parent
            res_parent = res_parent * fraction_parent
            if res_child == 0:
                res_parent = 1
            elif res_parent % res_child == 0:
                res_parent /= res_child
                res_child = 1
            elif res_child % res_parent == 0:
                res_child /= res_parent
                res_parent = 1

        sample = 1

        if res_child < 0:
            res_child = -res_child
            sample = -sample
        if res_parent < 0:
            res_parent = -res_parent
            sample = -sample

        hcf = get_hcf(res_child, res_parent)
        res = str(res_child / hcf) + '/' + str(res_parent / hcf)

        if sample == -1:
            res = '-' + res

        return res
