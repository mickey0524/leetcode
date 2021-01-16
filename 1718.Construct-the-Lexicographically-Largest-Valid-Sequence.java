// https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
// algorithms
// Medium (42.24%)
// Total Accepted: 2,795
// Total Submissions: 6,617


class Solution {
    
    private static int[] res;
    
    private static boolean success;
    
    public int[] constructDistancedSequence(int n) {
        res = new int[2 * n - 1];
        success = false;
        
        recursive(0, n, new int[2 * n - 1], new HashSet<>());
    
        return res;
    }
    
    private void recursive(int idx, int n, int[] tmp, Set<Integer> set) {
        if (success) {
            return;
        }
        
        int len = res.length;
        if (idx == len) {
            for (int i = 0; i < len; i++) {
                res[i] = tmp[i];
            }
            
            success = true;
            return;
        }
        
        if (tmp[idx] != 0) {
            recursive(idx + 1, n, tmp, set);
            return;
        }
        
        for (int i = n; i > 0; i--) {
            if (set.contains(i)) {
                continue;
            }
            if (i != 1 && (idx + i >= len || tmp[idx + i] != 0)) {
                continue;
            }
            
            tmp[idx] = i;
            if (i != 1) {
                tmp[idx + i] = i;
            }
            set.add(i);
            
            recursive(idx + 1, n, tmp, set);
            
            if (success) {
                return;
            }
        
            tmp[idx] = 0;
            if (i != 1) {
                tmp[idx + i] = 0;
            }
            set.remove(i);
        }
        
    }
}