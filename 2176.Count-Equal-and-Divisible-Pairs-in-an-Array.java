// https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/
// algorithms
// Easy (78.28%)
// Total Accepted: 12,087
// Total Submissions: 15,441


class Solution {
    
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            List<Integer> indexList = map.get(nums[i]);
            if (indexList == null) {
                indexList = new ArrayList<>();
                map.put(nums[i], indexList);
            }
            
            indexList.add(i);
        }
        
        int res = 0;
        for (List<Integer> indexList : map.values()) {
            len = indexList.size();
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    int tmp = indexList.get(i) * indexList.get(j);
                    if (tmp % k == 0) {
                        res++;
                    }
                }
            }
        }
        
        return res;
    }
    
}