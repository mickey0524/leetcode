// https://leetcode.com/problems/all-divisions-with-the-highest-score-of-a-binary-array/
// algorithms
// Medium (56.28%)
// Total Accepted: 9,116
// Total Submissions: 16,199


class Solution {
    
    public List<Integer> maxScoreIndices(int[] nums) {
        int len = nums.length;
        int[] l2r = new int[len];
        int[] r2l = new int[len];
        
        int zeroNum = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeroNum++;
            }
            
            l2r[i] = zeroNum;
        }
        
        int oneNum = 0;
        for (int i = len - 1; i >= 0; i--) {
            r2l[i] = oneNum;
            
            if (nums[i] == 1) {
                oneNum++;
            }
        }
        
        int curMax = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int sum = l2r[i] + r2l[i];
            if (sum > curMax) {
                curMax = sum;
                res.clear();
                res.add(i + 1);
            } else if (sum == curMax) {
                res.add(i + 1);
            }
        }
        
        if (oneNum > curMax) {
            res = Arrays.asList(0);
        } else if (oneNum == curMax) {
            res.add(0);
        }
        
        return res;
    }
    
}