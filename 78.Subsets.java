// https://leetcode.com/problems/subsets/
//
// algorithms
// Medium (52.86%)
// Total Accepted: 366,464
// Total Submissions: 693,299
// beats 100.0% of java submissions

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();

        recursive(res, new ArrayList<Integer>(), 0, nums);

        return res;
    }

    public void recursive(ArrayList<List<Integer>> res, ArrayList<Integer> path, int idx, int[] nums) {
        res.add(new ArrayList<Integer>(path));

        int len = nums.length;
        if (idx == len) {
            return;
        }

        for (int i = idx; i < len; i++) {
            path.add(nums[i]);
            recursive(res, path, i + 1, nums);
            path.remove(path.size() - 1);
        }
    }

}