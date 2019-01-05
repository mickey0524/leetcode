# https://leetcode.com/problems/maximum-product-subarray/
#
# algorithms
# Medium (28.11%)
# Total Accepted:    178,452
# Total Submissions: 634,808

# 提供两种解题思路
# 这道题和最长子串和很相似，但是由于存在负数的原因，max 和 min 经常交换

class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = max_s = min_s = nums[0]
        
        for n in nums[1:]:
            if n < 0:
                max_s, min_s = min_s, max_s
            
            max_s = max(n, n * max_s)
            min_s = min(n, n * min_s)
            res = max(res, max_s)
            
        return res

# 当遇到 0 的时候，计算一次当前的 max_res，用 negative 记录遍历过的负数，如果当前负数为偶数
# 直接全部相乘，就是结果，如果是奇数个负数，那么就比较去掉第一个负数和去掉最后一个负数的大小

class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        negative = []
        res = nums[0]
        pre = 0
        length = len(nums)
        has_zero = False
        
        for idx in xrange(length + 1):
            if idx < length and nums[idx] == 0:
                has_zero = True
                
            if idx == length or nums[idx] == 0:
                negative_len = len(negative)
                if negative_len & 1 == 0:
                    res = max(res, self.get_product(nums, pre, idx - 1))
                else:
                    res = max(res, self.get_product(nums, pre, negative[-1] - 1), \
                             self.get_product(nums, negative[0] + 1, idx - 1))
                pre = idx + 1
                negative = []
            elif nums[idx] < 0:
                negative += idx,
        
        if res < 0 and has_zero:
            res = 0
        
        return res
    
    def get_product(self, nums, head, tail):
        if head > tail:
            return float('-inf')
        
        res = 1
        
        for i in xrange(head, tail + 1):
            res *= nums[i]
        
        return res
                