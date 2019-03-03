# https://leetcode.com/problems/letter-combinations-of-a-phone-number/
#
# algorithms
# Medium (40.39%)
# Total Accepted:    348,181
# Total Submissions: 862,054
# beats 100.0% of python submissions


class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        length = len(digits)
        if length == 0:
            return []

        res = [[]]
        chars = []
        for i in xrange(97, 123):
            chars += chr(i),

        hash_map = {}

        for i in xrange(2, 8):
            hash_map[str(i)] = chars[(i - 2) * 3: (i - 1) * 3]
        hash_map['7'] += 's',
        hash_map['8'] = ['t', 'u', 'v']
        hash_map['9'] = ['w', 'x', 'y', 'z']

        def recursive(idx, path):
            if idx == length:
                res[0] += path,
                return

            for ch in hash_map[digits[idx]]:
                recursive(idx + 1, path + ch)

        recursive(0, '')

        return res[0]
