// https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
// algorithms
// Medium (58.94%)
// Total Accepted: 4,570
// Total Submissions: 7,753


class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] p : adjacentPairs) {
            List<Integer> tmp1 = map.computeIfAbsent(p[0], k -> new ArrayList<>());
            tmp1.add(p[1]);

            List<Integer> tmp2 = map.computeIfAbsent(p[1], k -> new ArrayList<>());
            tmp2.add(p[0]);
        }
        
        int size = map.size();
        List<Integer> l = new ArrayList<>(size);
        int head = -1, pre = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                head = entry.getKey();
                break;
            }
        }
        
        for (int i = 0; i < size; i++) {
            l.add(head);
            int preTmp = head;
            
            List<Integer> tmp = map.get(head);
            if (tmp.size() == 1) {
                head = tmp.get(0);
            } else {
                head = tmp.get(0) == pre ? tmp.get(1) : tmp.get(0);
            }
            
            pre = preTmp;
        }
        
        l.add(head);
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = l.get(i);
        }
        
        return res;
    }
}