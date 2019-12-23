// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
// algorithms
// Medium (46.27%)
// Total Accepted: 3,712
// Total Submissions: 8,023
// beats 100.0% of java submissions


class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
                pq.add(n);
            }
        }

        while (!pq.isEmpty()) {
            int n = pq.poll();
            int num = map.get(n);
            if (num == 0) {
                continue;
            }

            for (int i = n + 1; i < n + k; i++) {
                int tmp = map.getOrDefault(i, 0);
                if (tmp < num) {
                    return false;
                }
                map.put(i, tmp - num);
            }
        }

        return true;
    }
}