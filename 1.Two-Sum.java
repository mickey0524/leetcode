// https://leetcode.com/problems/two-sum/description/
//
// algorithms
// Easy (42.68%)
// Total Accepted:    1,597,390
// Total Submissions: 3,742,467
// beats 100.0% of java submissions

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (hashMap.containsKey(t)) {
                return new int[]{hashMap.get(t), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        
        return new int[]{};
    }
}