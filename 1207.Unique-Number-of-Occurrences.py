# https://leetcode.com/problems/smallest-string-with-swaps/
# Medium (77.76%)
# Total Accepted:    4,818
# Total Submissions: 6,196
# beats 100.0 % of python submissions


from collections import defaultdict

class Solution(object):
    def uniqueOccurrences(self, arr):
        """
        :type arr: List[int]
        :rtype: bool
        """
        hash_map = defaultdict(int)
        for n in arr:
            hash_map[n] += 1
        
        s = set()
        for v in hash_map.values():
            if v in s:
                return False
            
            s.add(v)
        
        return True
