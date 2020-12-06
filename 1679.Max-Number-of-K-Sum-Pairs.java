// https://leetcode.com/problems/max-number-of-k-sum-pairs/
// algorithms
// Easy (50.94%)
// Total Accepted: 4,860
// Total Submissions: 9,541


class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums) {
            if (n < k) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }
        
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int n1 = entry.getKey();
            
            if (n1 > (k / 2)) {
                continue;
            }
            
            int v1 = entry.getValue();
            int n2 = k - n1;
            
            if (n1 == n2) {
                res += (v1 / 2);
            } else {
                Integer v2 = map.get(n2);
                if (v2 != null) {
                    res += Math.min(v1, v2);
                }
            }
        }
        
        return res;
    }
}