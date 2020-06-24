// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
// algorithms
// Medium (53.84%)
// Total Accepted: 12,218
// Total Submissions: 22,693


class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int res = map.size();
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);
        for (int n : values) {
            if (k < n) {
                break;
            }

            res--;
            k -= n;
        }

        return res;
    }
}