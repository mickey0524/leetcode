// https://leetcode.com/problems/degree-of-an-array/
//
// algorithms
// Easy (51.74%)
// Total Accepted: 60,818
// Total Submissions: 117,542
// beats 100.0% of java submissions


class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        HashMap<Integer, int[]> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (numMap.containsKey(n)) {
                numMap.put(n, numMap.get(n) + 1);
                indexMap.get(n)[1] = i;
            } else {
                numMap.put(n, 1);
                indexMap.put(n, new int[] { i, i });
            }
        }

        int res = 0;
        int curMaxNum = 0;
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > curMaxNum) {
                curMaxNum = value;
                int[] index = indexMap.get(key);
                res = index[1] - index[0] + 1;
            } else if (value == curMaxNum) {
                int[] index = indexMap.get(key);
                res = Math.min(res, index[1] - index[0] + 1);
            }
        }

        return res;
    }
}