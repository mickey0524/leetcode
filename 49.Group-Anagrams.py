# https://leetcode.com/problems/count-and-say/description/
#
# algorithms
# Medium (42.26%)
# Total Accepted:    255.6k
# Total Submissions: 604.8k

class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        hash_map = {}
        
        for s in strs:
            key = ''.join(sorted(s))
            cnt_arr = hash_map.get(key, [])
            cnt_arr += s,
            hash_map[key] = cnt_arr
        
        res = []
        
        for v in hash_map.itervalues():
            res += v,
        
        return res