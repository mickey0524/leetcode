// https://leetcode.com/problems/max-pair-sum-in-an-array/description/
// algorithms
// Easy (57.85%)
// Total Accepted: 30.2K
// Total Submissions: 52.2K


class Solution {

    public int maxSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int n : nums) {
            int maxDigit = getMaxDigit(n);

            List<Integer> list = map.get(maxDigit);
            if (list == null) {
                list = new ArrayList<>();
                map.put(maxDigit, list);
            }

            list.add(n);
        }    

        int res = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            int size = list.size();
            if (size > 1) {
                Collections.sort(list);
                res = Math.max(res, list.get(size - 1) + list.get(size - 2));
            }
        }

        return res;
    }

    private int getMaxDigit(int n) {
        int maxDigit = -1;
        while (n > 0) {
            maxDigit = Math.max(maxDigit, n % 10);
            n = n / 10;
        }

        return maxDigit;
    }

}