// https://leetcode.com/problems/intersection-of-multiple-arrays/
// algorithms
// Easy (69.71%)
// Total Accepted: 18,478
// Total Submissions: 26,507


class Solution {
    
    public List<Integer> intersection(int[][] nums) {
        if (nums == null) {
            return Collections.emptyList();
        } 
        
        int len = nums.length;
        if (len == 0) {
            return Collections.emptyList();
        }
        
        int[] flag = new int[1001];
        for (int[] arr : nums) {
            for (int n : arr) {
                flag[n]++;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (flag[i] == len) {
                res.add(i);
            }
        }
        
        return res;
    }
    
}