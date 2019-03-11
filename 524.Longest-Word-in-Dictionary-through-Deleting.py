# https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
#
# algorithms
# Medium (45.11%)
# Total Accepted:    38,788
# Total Submissions: 85,993
# beats 94.13% of python submissions

from collections import defaultdict
from bisect import bisect

class Solution(object):
    def findLongestWord(self, s, d):
        """
        :type s: str
        :type d: List[str]
        :rtype: str
        """
        hash_map = defaultdict(list)
        
        for idx, ch in enumerate(s):
            hash_map[ch] += idx,
            
        res = ''
        
        for w in d:
            is_found = False
            len_w = len(w)
            pre_idx = -1
            for idx, ch in enumerate(w):
                if len(hash_map[ch]) == 0:
                    break
                insert_idx = bisect(hash_map[ch], pre_idx)
                if insert_idx == len(hash_map[ch]):
                    break
                pre_idx = hash_map[ch][insert_idx]
                if idx == len_w - 1:
                    is_found = True
            
            if is_found:
                len_res = len(res)
                if len_w > len_res:
                    res = w
                elif len_w == len_res and w < res:
                    res = w
        
        return res
                
            
