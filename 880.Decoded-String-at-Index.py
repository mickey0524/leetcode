# https://leetcode.com/problems/decoded-string-at-index/
#
# algorithms
# Medium (22.95%)
# Total Accepted:    6,260
# Total Submissions: 27,271
# beats 77.38% of python submissions


class Solution(object):
    def decodeAtIndex(self, S, K):
        """
        :type S: str
        :type K: int
        :rtype: str
        """
        stack = []
        cur_len, idx = 0, 0
        S_len = len(S)
        
        while idx < S_len:
            ch, is_digit = S[idx], False
            if ch.isdigit():
                cur_len *= int(ch)
                is_digit = True
            else:
                cur_len += 1
            stack.append((cur_len, is_digit))
            if cur_len >= K:
                break
            idx += 1
        
        if idx == S_len:
            K %= stack[-1][0]
            idx = 0
            while idx < S_len:
                if stack[idx][0] >= K:
                    break
                idx += 1
        
        while idx > 0:
            if stack[idx][0] == K or K == 0:
                while stack[idx][1]:
                    idx -= 1
                return S[idx]
            
            if stack[idx][1]:
                K %= stack[idx - 1][0]
            idx -= 1

        return S[0]
        