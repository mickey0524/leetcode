// https://leetcode.com/problems/power-of-two/
//
// algorithms
// Easy (41.95%)
// Total Accepted: 227,879
// Total Submissions: 543,208

// 这道题有很多种做法，包括取对数相除都是好方法
// 这种做法应该是最好的
// n & (n - 1) 会消去 n 的二进制表示中的最右边的 1
// 如果是 2 的倍数的话，则说明二进制中只有一个 1
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}