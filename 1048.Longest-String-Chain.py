# https://leetcode.com/problems/longest-string-chain/
# Easy (44.06%)
# Total Accepted:    3,426
# Total Submissions: 7,775
# beats 100.0% of python submissions


class Solution(object):
    def longestStrChain(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        length = len(words)
        if length < 2:
            return 1
        
        w_len_map = {}
        w_map = {}
        max_w_len = float('-inf')
        
        for w in words:
            wordLen = len(w)
            max_w_len = max(max_w_len, wordLen)
            if wordLen in w_len_map:
                w_len_map[wordLen] += w,
            else:
                w_len_map[wordLen] = [w]
            w_map[w] = True
        
        res = 1
        q = {}
        
        for i in xrange(max_w_len, 0, -1):
            if i not in w_len_map:
                q = {}
                continue
                
            if not q:
                q = {w:1 for w in w_len_map[i]}
                continue
                
            tmp = {w:1 for w in w_len_map[i]}
            for k, v in q.iteritems():
                res = max(res, v)
                is_found = False
                for j in xrange(i + 1):
                    next_w = k[:j] + k[j+1:]
                    if next_w in tmp:
                        is_found = True
                        tmp[next_w] = v + 1
                if not is_found:
                    res = max(res, v)
                else:
                    res = max(res, v + 1)
            
            q = tmp
        
        return res
        