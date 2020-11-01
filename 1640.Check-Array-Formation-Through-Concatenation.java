// https://leetcode.com/problems/check-array-formation-through-concatenation/
// algorithms
// Easy (66.02%)
// Total Accepted: 5,134
// Total Submissions: 7,777
// beats 100.0% of java submissions


class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        int pLen = pieces.length;
        
        for (int i = 0; i < pLen; i++) {
            int[] tmp = pieces[i];
            map.put(tmp[0], i);
        }
        
        int idx = 0, arrLen = arr.length;;
        while (idx < arrLen) {
            Integer targetIdx = map.get(arr[idx]);
            if (targetIdx == null) {
                return false;
            }
            
            for (int i = 0; i < pieces[targetIdx].length; i++) {
                if (arr[idx++] != pieces[targetIdx][i]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}