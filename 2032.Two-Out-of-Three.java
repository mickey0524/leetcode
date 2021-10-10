// https://leetcode.com/problems/two-out-of-three/
// algorithms
// Easy (70.33%)
// Total Accepted: 6.4K
// Total Submissions: 9.1K


class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        helper(map, nums1, 1);
        helper(map, nums2, 2);
        helper(map, nums3, 3);
        
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() >= 2) {
                res.add(entry.getKey());
            }
        }
        
        return res;
    }
    
    private void helper(Map<Integer, Set<Integer>> map, int[] arr, int idx) {
        for (int n : arr) {
            Set<Integer> s = map.get(n);
            if (s == null) {
                s = new HashSet<>();
                map.put(n, s);
            }
            
            s.add(idx);
        }
    }
}