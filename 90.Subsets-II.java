// https://leetcode.com/problems/subsets-ii/
//
// algorithms
// Medium (42.43%)
// Total Accepted: 203,160
// Total Submissions: 478,867
// beats 100.0% of java submissions


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

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
            if (i == idx || nums[i] != nums[i - 1]) {
                path.add(nums[i]);
                recursive(res, path, i + 1, nums);
                path.remove(path.size() - 1);
            }
        }
    }
}