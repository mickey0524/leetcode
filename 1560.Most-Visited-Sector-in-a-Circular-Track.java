// https://leetcode.com/problems/most-visited-sector-in-a-circular-track/
// algorithms
// Easy (54.76%)
// Total Accepted: 5,586
// Total Submissions: 10,200
// beats 100.0% of java submission


class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList<>();
        int[] flag = new int[n + 1];

        int len = rounds.length;
        for (int i = 1; i < len; i++) {
            if (rounds[i] > rounds[i - 1]) {
                for (int j = rounds[i - 1]; j < rounds[i]; j++) {
                    flag[j]++;
                }
            } else {
                for (int j = rounds[i - 1]; j <= n; j++) {
                    flag[j]++;
                }
                for (int j = 0; j < rounds[i]; j++) {
                    flag[j]++;
                }
            }

            if (i == len - 1) {
                flag[rounds[i]]++;
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (flag[i] > max) {
                max = flag[i];
                res.clear();
                res.add(i);
            } else if (flag[i] == max) {
                res.add(i);
            }
        }

        return res;
    }
}