# https://leetcode.com/problems/ambiguous-coordinates/
#
# algorithms
# Medium (43.27%)
# Total Accepted:    5,726
# Total Submissions: 13,232
# beats 91.11% of python submissions


class Solution(object):
    def ambiguousCoordinates(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        S = S[1:-1]
        length = len(S)
        res = set()

        for i in xrange(1, length):
            left = self.add_decimal_point(S[:i])
            right = self.add_decimal_point(S[i:])
            for m in left:
                for n in right:
                    string = '(' + m + ', ' + n + ')'
                    if string not in res:
                        res.add(string)

        return list(res)

    def add_decimal_point(self, s):
        length = len(s)

        if length == 1:
            return [s]

        if int(s) == 0:
            return []

        if s[-1] == '0':
            if s[0] == '0':
                return []
            return [s]

        if s[0] == '0':
            return ['0.' + s[1:]]

        res = [s]
        for i in xrange(1, length):
            res.append(s[:i] + '.' + s[i:])

        return res
