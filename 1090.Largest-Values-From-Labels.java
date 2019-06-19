// https://leetcode.com/problems/largest-values-from-labels/
//
// algorithms
// Medium (55.74%)
// Total Accepted: 3,245
// Total Submissions: 5,822
// beats 100.0% of java submissions

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int length = values.length;

        int[][] nums = new int[length][2];
        for (int i = 0; i < length; i++) {
            nums[i][0] = values[i];
            nums[i][1] = labels[i];
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        int res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int curUse = hashMap.getOrDefault(nums[i][1], 0);
            if (curUse < use_limit) {
                res += nums[i][0];
                hashMap.put(nums[i][1], curUse + 1);
                num_wanted--;
                if (num_wanted == 0) {
                    break;
                }
            }
        }

        return res;
    }
}