# https://leetcode.com/problems/largest-number/
#
# algorithms
# Medium (24.84%)
# Total Accepted:    114,565
# Total Submissions: 461,267

class Solution(object):
    def largestNumber(self, num):
        length = len(num)
        if length == 0:
            return '0'
        
        comp = lambda a, b: 1 if a + b > b + a else -1 if a + b < b + a else 0
        num = map(str, num)
        num.sort(cmp = comp, reverse = True)
        if num[0] == '0':
            return '0'
        
        return ''.join(num)
