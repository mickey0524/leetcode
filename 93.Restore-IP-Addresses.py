# https://leetcode.com/problems/restore-ip-addresses/
#
# algorithms
# Medium (31.43%)
# Total Accepted:    138,937
# Total Submissions: 442,122
# beats 85.52% of python submissions


class Solution(object):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        length = len(s)
        if length < 4 or length > 12:
            return []

        res = [[]]

        def recursive(idx, path, pre):
            path_len = len(path)
            if path_len > 4:
                return

            if path_len == 4:
                if idx == length + 1:
                    res[0] += '.'.join(path),

                return

            for i in xrange(idx, length + 1):
                if self.is_valid(s[pre:i]):
                    recursive(i + 1, path + [s[pre:i]], i)

        recursive(0, [], 0)

        return res[0]

    def is_valid(self, s):
        length = len(s)

        if length == 0 or length > 3:
            return False

        if length > 1 and s[0] == '0':
            return False

        if length == 3 and int(s) > 255:
            return False

        return True
