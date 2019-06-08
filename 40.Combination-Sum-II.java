// https://leetcode.com/problems/combination-sum-ii/
//
// algorithms
// Medium (41.73%)
// Total Accepted:    222,831
// Total Submissions: 533,921
// beats 100.00% of java submissions

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        recursive(candidates, target, 0, res, new ArrayList<Integer>());
        
        return res;
    }
    
    public void recursive(int[] nums, int target, int idx, List<List<Integer>> res, List<Integer> path) {
        int len = nums.length;
        
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
                
        for (int i = idx; i < len; i++) {
            if (nums[i] > target) {
                break;
            }

            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            
            path.add(nums[i]);
            recursive(nums, target - nums[i], i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }
}