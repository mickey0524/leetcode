// https://leetcode.com/problems/flower-planting-with-no-adjacent/
//
// algorithms
// Easy (38.68%)
// Total Accepted:    1,501
// Total Submissions: 3,881
// beats 100.0% of java submissions

class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] res = new int[N];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < paths.length; i++) {
            if (map.containsKey(paths[i][0])) {
                map.get(paths[i][0]).add(paths[i][1]);    
            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(paths[i][1]);
                map.put(paths[i][0], l);
            }
            
            if (map.containsKey(paths[i][1])) {
                map.get(paths[i][1]).add(paths[i][0]);    
            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(paths[i][0]);
                map.put(paths[i][1], l);
            }
        }
        
        for (int i = 0; i < N; i++) {
            if (res[i] == 0) {
                recursive(map, res, i + 1);    
                if (res[i] == 0) {
                    res[i] = 1;
                }
            }
        }
        
        return res;
    }
    
    public void recursive(HashMap<Integer, ArrayList<Integer>> map, int[] res, int idx) {
        if (!map.containsKey(idx)) {
            return;
        }
        
        ArrayList<Integer> l = map.get(idx);
        ArrayList<Integer> arr = new ArrayList<>();
        boolean[] flag = new boolean[5];
        Arrays.fill(flag, true);
        
        for (int i : l) {
            if (res[i - 1] != 0) {
                flag[res[i - 1]] = false;
            } else {
                arr.add(i);
            }
        }
        
        for (int i = 1; i < 5; i++) {
            if (flag[i]) {
                res[idx - 1] = i;
                break;
            }
        }
        
        for (int i : arr) {
            recursive(map, res, i);
        }
        
    }
}