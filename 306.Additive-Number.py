# https://leetcode.com/problems/additive-number/
#
# algorithms
# Medium (28.44%)
# Total Accepted:    41,434
# Total Submissions: 145,714
# beats 100.0% of python submissions


class Solution(object):
    def isAdditiveNumber(self, num):
        """
        :type num: str
        :rtype: bool
        """
        length = len(num)
        if length < 3:
            return False

        def recursive(st, nd, idx):
            if idx == length:
                return True

            if st == '':
                if num[idx] == '0':
                    return recursive('0', '', idx + 1)

                for i in xrange(1, length / 2 + 1):
                    if recursive(num[:i], '', i):
                        return True

            elif nd == '':
                if num[idx] == '0':
                    return recursive(st, '0', idx + 1)

                for i in xrange(idx + 1, length):
                    if recursive(st, num[idx:i], i):
                        return True

            else:
                target = str(int(st) + int(nd))
                if num.startswith(target, idx):
                    return recursive(nd, target, idx + len(target))

            return False

        return recursive('', '', 0)
