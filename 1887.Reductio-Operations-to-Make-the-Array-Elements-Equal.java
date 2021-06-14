// https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
// algorithms
// Medium (59.67%)
// Total Accepted: 10.8K
// Total Submissions: 18.1K


class Solution {

    public int reductionOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        if (map.size() < 2) {
            return 0;
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> o2 - o1);

        int res = 0, cur = 0, size = list.size();
        for (int i = 0; i < size - 1; i++) {
            int tmp = map.getOrDefault(list.get(i), 0);
            res += (cur + tmp);

            cur += tmp;
        }

        return res;
    }

}