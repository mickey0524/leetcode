# https://leetcode.com/problems/letter-tile-possibilities/
# Easy (75.41%)
# Total Accepted:    1,509
# Total Submissions: 2,001
# beats 100.0% of python submissions


class Solution(object):
    def numTilePossibilities(self, tiles):
        """
        :type tiles: str
        :rtype: int
        """
        length = len(tiles)

        if length < 2:
            return length

        s = set()
        s.add('')
        ans = 0

        chars = [0] * 26
        for ch in tiles:
            idx = ord(ch) - 65
            chars[idx] += 1

        for i in xrange(length):
            tmp = set()
            for string in s:
                prefix_suffix = self.get_prefix_suffix(chars, string)
                for ch in prefix_suffix:
                    tmp |= {ch + string, string + ch}
            s = tmp
            ans += len(s)

        return ans

    def get_prefix_suffix(self, chars, s):
        tmp = chars[:]
        for ch in s:
            idx = ord(ch) - 65
            tmp[idx] -= 1

        res = []
        for i in xrange(65, 91):
            if tmp[i - 65] > 0:
                res += chr(i),

        return res
