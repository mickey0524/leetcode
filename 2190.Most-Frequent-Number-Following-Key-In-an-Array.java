// https://leetcode.com/problems/most-frequent-number-following-key-in-an-array/
// algorithms
// Easy (55.72%)
// Total Accepted: 10,366
// Total Submissions: 18,603

class Solution {
    
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>(); 
        int len = nums.length;
        
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] == key) {
                Integer curSum = map.get(nums[i]);
                if (curSum == null) {
                    curSum = 0;
                }
                
                curSum++;
                map.put(nums[i], curSum);
            }    
        }
        
        int res = -1, num = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > num) {
                num = entry.getValue();
                res = entry.getKey();
            }
        }
        
        return res;
    }
    
}