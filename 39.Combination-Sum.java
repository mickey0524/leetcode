// https://leetcode.com/problems/combination-sum/
//
// algorithms
// Medium (48.64%)
// Total Accepted:    345,225
// Total Submissions: 709,733
// beats 100.00% of java submissions


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        recursive(candidates, 0, target, res, new ArrayList<Integer>());
        
        return res;
    }
    
    public void recursive(int[] candidates, int idx, int curNum, ArrayList<List<Integer>> l, ArrayList<Integer> path) {
        int len = candidates.length;
        
        if (curNum == 0) {
            l.add(new ArrayList<Integer>(path));
            return;
        }
        
        if (curNum < 0) {
            return;
        }
        
        if (idx == len) {
            return;
        }
        
        for (int i = idx; i < len; i++) {
            if (curNum < candidates[i]) {
                break;
            }
            path.add(candidates[i]);
            recursive(candidates, i, curNum - candidates[i], l, path);
            path.remove(path.size() - 1);
        }
    }
}