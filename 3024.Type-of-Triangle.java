// https://leetcode.com/problems/type-of-triangle/description/
// algorithms
// Easy (38.4%)
// Total Accepted: 35.3K
// Total Submissions: 91.9K


class Solution {

    public String triangleType(int[] nums) {
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        }

        if (nums[1] + nums[2] <= nums[0]) {
            return "none";
        }

        if (nums[2] + nums[0] <= nums[1]) {
            return "none";
        }

        if ((nums[0] == nums[1]) && (nums[1] == nums[2])) {
            return "equilateral";
        }

        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        set.add(nums[1]);
        set.add(nums[2]);

        return set.size() == 2 ? "isosceles" : "scalene";
    }

}