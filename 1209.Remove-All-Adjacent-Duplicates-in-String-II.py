# https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
# Medium (57.42%)
# Total Accepted:    3,353
# Total Submissions: 5,839
# beats 100.0 % of python submissions


from collections import deque


class Solution(object):
    def removeDuplicates(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        stack = deque()
        pre_idx, idx = 0, 0
        length = len(s)

        while idx <= length:
            if idx == length or s[idx] != s[pre_idx]:
                repeat_num = idx - pre_idx
                repeat_num %= k
                if stack and stack[-1][0] == s[pre_idx]:
                    tmp = stack.pop()
                    n = (tmp[1] + repeat_num) % k
                    if n > 0:
                        stack.append((s[pre_idx], n))

                elif repeat_num > 0:
                    stack.append((s[pre_idx], repeat_num))

                pre_idx = idx

            idx += 1

        res = []
        for ch, n in stack:
            res.append(ch * n)

        return ''.join(res)
