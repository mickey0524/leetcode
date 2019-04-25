// https://leetcode.com/problems/find-the-duplicate-number/
//
// algorithms
// Medium (49.16%)
// Total Accepted:    181,040
// Total Submissions: 368,275
// beats 60.29% of java submissions

// 位图，空间复杂度没有 O(n)，但是还是不完全符合题目要求
class Solution {
    public int findDuplicate(int[] nums) {
        BitSet s = new BitSet();
        
        for (int i : nums) {
            if (s.get(i)) {
                return i;
            }
            s.set(i);
        }
        
        return -1;
    }
}

// 二分，完全符合题目要求
class Solution1 {
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        int l = 1, r = length - 1, m = -1;
        int less = 0, more = 0, cur = 0;
        
        while (l <= r) {
            m = l + (r - l) / 2;
            less = 0;
            more = 0;
            cur = 0;
            for (int n : nums) {
                if (n < m && n >= l) {
                    less++;
                } else if (n > m && n <= r) {
                    more++;
                } else if (n == m) {
                    cur++;
                }
            }
            if (cur > 1) {
                return m;
            }
            if (more > less) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}