# https://leetcode.com/problems/swap-for-longest-repeated-character-substring/
# Medium (43.83%)
# Total Accepted:    2,061
# Total Submissions: 4,702
# beats 100.0% of python submissions


class Solution(object):
    def maxRepOpt1(self, text):
        """
        :type text: str
        :rtype: int
        """ 
        ch_idx = [None] * 26
        for i, ch in enumerate(text):
            idx = ord(ch) - 97
            if not ch_idx[idx]:
                ch_idx[idx] = [i]
            elif len(ch_idx[idx]) == 1:
                ch_idx[idx].append(i)
            else:
                ch_idx[idx][1] = i
        for i, arr in enumerate(ch_idx):
            if arr and len(arr) == 1:
                ch_idx[i].append(arr[0]) 
        
        length = len(text)
        segment_arr = [None] * 26
        res = 1
        
        i = 0
        while i < length:
            j = i + 1
            while j < length and text[j] == text[i]:
                j += 1
            
            arr_idx = ord(text[i]) - 97
            if segment_arr[arr_idx]:
                if segment_arr[arr_idx][0] == i - 2:
                    n = segment_arr[arr_idx][1] + j - i
                    if ch_idx[arr_idx][1] > j or ch_idx[arr_idx][0] < (segment_arr[arr_idx][0] - segment_arr[arr_idx][1]):
                        n += 1
                    
                    res = max(res, n)
                else:
                    res = max(res, max(segment_arr[arr_idx][1], j - i) + 1)
                segment_arr[arr_idx] = (j - 1, j - i)
                
            else:
                segment_arr[arr_idx] = (j - 1, j - i)
                res = max(res, j - i)
            
            i = j
        
        return res