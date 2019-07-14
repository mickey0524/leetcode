// https://leetcode.com/problems/relative-sort-array/
//
// algorithms
// Easy (68.39%)
// Total Accepted: 3,572
// Total Submissions: 5,223
// beats 100.0% of java submissions

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int n : arr2) {
            map.put(n, 0);
        } 
        
        ArrayList<Integer> l = new ArrayList<>();
        for (int n : arr1) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                l.add(n);
            }
        }
        Collections.sort(l);
        int[] res = new int[arr1.length];
        int idx = 0;
        for (int n : arr2) {
            for (int j = 0; j < map.get(n); j++) {
                res[idx++] = n;
            }
        }
        for (int n : l) {
            res[idx++] = n;
        }
        
        return res;
    }
}