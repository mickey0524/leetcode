// https://leetcode.com/problems/count-primes/
//
// algorithms
// Easy (28.66%)
// Total Accepted:    226,408
// Total Submissions: 789,922


class Solution {
    public int countPrimes(int n) {
        if (n <= 4) {
            return Math.max(0, n - 2);
        }
            
        boolean flag[] = new boolean[n];
        Arrays.fill(flag, true);
        
        for (int i = 2; i * i < n; i++) {
            for (int j = i + i; j < n; j += i) {
                flag[j] = false;
            }
        }
        
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (flag[i]) {
                res++;
            }
        }
        
        return res;
    }
}