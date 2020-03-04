// https://leetcode.com/problems/set-mismatch/
//
// algorithms
// Easy (41.53%)
// Total Accepted:    63,652
// Total Submissions: 153,260
// beats 100.0% of java submissions


class Solution {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len + 1];
        int repeatNum = -1, missNum = -1;

        for (int n : nums) {
            if (visited[n]) {
                repeatNum = n;
            }

            visited[n] = true;
        }

        for (int i = 1; i <= len; i++) {
            if (!visited[i]) {
                missNum = i;
                break;
            }
        }

        return new int[] { repeatNum, missNum };
    }
}