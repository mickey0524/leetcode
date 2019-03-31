// https://leetcode.com/problems/binary-prefix-divisible-by-5/
//
// algorithms
// Easy (40.41%)
// Total Accepted:    3,360
// Total Submissions: 8,314
// beats 100.0% of java submissions

class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int len = A.length;
        List<Boolean> res = new ArrayList<>();
        int curRemainder = 0;
        
        if (A[0] == 0) {
            res.add(true);
        } else {
            res.add(false);
            curRemainder = 1;
        }
        
        for (int i = 1; i < len; i++) {
            curRemainder = ((curRemainder << 1) + A[i]) % 5;
            if (curRemainder == 0) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        
        return res;
    }
}