// https://leetcode.com/problems/finding-the-users-active-minutes/
// algorithms
// Medium (78.76%)
// Total Accepted: 8,447
// Total Submissions: 10,725


class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) { 
        int[] res = new int[k];

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            Set<Integer> set = map.get(log[0]);
            if (set == null) {
                set = new HashSet<>();
                map.put(log[0], set);
            }
            set.add(log[1]);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Set<Integer> s = entry.getValue();
            int size = s.size();
            if (size <= k) {
                res[size - 1]++;
            }
        }

        return res;
    }
}