// https://leetcode.com/problems/contains-duplicate-ii/
//
// algorithms
// Easy (36.55%)
// Total Accepted: 234,075
// Total Submissions: 640,395


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }
}