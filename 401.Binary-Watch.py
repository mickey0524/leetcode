# https://leetcode.com/problems/binary-watch/
#
# algorithms
# Easy (45.81%)
# Total Accepted:    69,493
# Total Submissions: 151,697


class Solution(object):

    def readBinaryWatch(self, num):
        """
        :type num: int
        :rtype: List[str]
        """
        hour = [1, 2, 4, 8]
        minute = [1, 2, 4, 8, 16, 32]
        res = []
        h_arr, m_arr = [], []

        def recursive(arr, idx, length, tmp, res_arr):
            arr_len = len(arr)

            if length == 0:
                res_arr.append(tmp)
                return

            if idx >= arr_len:
                return

            for i in xrange(idx, arr_len):
                recursive(arr, i + 1, length - 1, tmp + arr[i], res_arr)

        for i in xrange(0, num + 1):
            h_arr, m_arr = [], []
            recursive(hour, 0, i, 0, h_arr)
            recursive(minute, 0, num - i, 0, m_arr)

            for h in h_arr:
                if h > 11:
                    continue

                for m in m_arr:
                    if m > 59:
                        continue

                    tmp = str(h) + ':' + ('0' if m < 10 else '') + str(m)
                    res.append(tmp)

        return res
