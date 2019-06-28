// https://leetcode.com/problems/minimum-height-trees/
//
// algorithms
// Medium (30.26%)
// Total Accepted:    66,045
// Total Submissions: 218,234

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return new ArrayList<>(Arrays.asList(0));
        }
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>(n);

        for (int[] e : edges) {
            if (map.containsKey(e[0])) {
                map.get(e[0]).add(e[1]);
            } else {
                map.put(e[0], new LinkedList<>(Arrays.asList(e[1])));
            }
            if (map.containsKey(e[1])) {
                map.get(e[1]).add(e[0]);
            } else {
                map.put(e[1], new LinkedList<>(Arrays.asList(e[0])));
            }
        }

        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (map.get(i).size() == 1) {
                q.add(i);
            }
        }

        while (map.size() > 2) {
            for (int i : q) {
                int targetId = map.get(i).peek();
                map.get(targetId).remove(Integer.valueOf(i));
                map.remove(i);
            }
            q.clear();
            for (int i = 0; i < n; i++) {
                if (map.containsKey(i) && map.get(i).size() <= 1) {
                    q.add(i);
                }
            }
        }

        return q;
    }
}