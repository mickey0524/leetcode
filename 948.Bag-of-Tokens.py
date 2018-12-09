# algorithms
# Medium (38.18%)
# Total Accepted:    3,231
# Total Submissions: 8,462


class Solution(object):
    def bagOfTokensScore(self, tokens, P):
        """
        :type tokens: List[int]
        :type P: int
        :rtype: int
        """
        length = len(tokens)
        if length == 0:
            return 0

        tokens.sort()

        if P < tokens[0]:
            return 0

        res, cnt_p = 0, 0
        head, tail = 0, length - 1

        while head <= tail:
            while head <= tail and P >= tokens[head]:
                P -= tokens[head]
                head += 1
                cnt_p += 1
            res = max(res, cnt_p)
            if head > tail:
                break
            P += tokens[tail]
            tail -= 1
            cnt_p -= 1

        return res
