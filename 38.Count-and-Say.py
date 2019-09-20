# https://leetcode.com/problems/count-and-say/description/
#
# algorithms
# Easy (37.82%)
# Total Accepted:    218.5k
# Total Submissions: 577.8k
# beats 92.76% of python submissions


class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        if n == 1:
            return '1'

        path = '1'
        for _ in xrange(n - 1):
            pre_ch = path[0]
            num = 1
            cnt_path = ''
            for ch in path[1:]:
                if ch != pre_ch:
                    cnt_path += (str(num) + pre_ch)
                    pre_ch = ch
                    num = 1
                else:
                    num += 1

            if num > 0:
                cnt_path += (str(num) + pre_ch)
            path = cnt_path

        return path


class Solution1(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        if n == 1:
            return '1'

        tmp = '1'
        for i in xrange(2, n + 1):
            length = len(tmp)
            i = 0
            arr = []

            while i < length:
                j = i + 1
                while j < length and tmp[j] == tmp[i]:
                    j += 1

                arr.extend([str(j - i), tmp[i]])
                i = j

            tmp = ''.join(arr)

        return tmp
