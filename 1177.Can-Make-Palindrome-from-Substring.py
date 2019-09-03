# https://leetcode.com/problems/diet-plan-performance/
# Medium (29.66%)
# Total Accepted:    2,956
# Total Submissions: 9,967


class Solution(object):
    def canMakePaliQueries(self, s, queries):
        """
        :type s: str
        :type queries: List[List[int]]
        :rtype: List[bool]
        """
        length = len(s)
        chs = [[0] * 26 for _ in xrange(length)]
        chs[0][ord(s[0]) - 97] = 1

        for idx in xrange(1, length):
            k = ord(s[idx]) - 97
            chs[idx][k] = chs[idx - 1][k] + 1
            for i in xrange(26):
                if chs[idx][i] == 0:
                    chs[idx][i] = chs[idx - 1][i]

        res = [False] * len(queries)

        for idx, (start_idx, end_idx, k) in enumerate(queries):
            if start_idx == 0:
                tmp = chs[end_idx]
            else:
                tmp = [0] * 26
                for i in xrange(26):
                    tmp[i] = chs[end_idx][i] - chs[start_idx - 1][i]

            segment_len = end_idx - start_idx + 1
            # 剩下的单个的 ch 数量
            excessive = 0

            for n in tmp:
                excessive += (n % 2)

            # 奇数长度
            if segment_len & 1 == 1:
                if k * 2 >= excessive - 1:
                    res[idx] = True

            # 偶数长度
            else:
                if k * 2 >= excessive:
                    res[idx] = True

        return res
