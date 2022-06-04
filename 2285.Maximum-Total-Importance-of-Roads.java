// https://leetcode.com/problems/maximum-total-importance-of-roads/
// algorithms
// Medium (59.24%)
// Total Accepted: 12.5K
// Total Submissions: 21.1K


class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        s.maximumImportance(5, new int[][]{{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}});
    }

    public long maximumImportance(int n, int[][] roads) {
        int[][] degree = new int[n][2];
        for (int[] r : roads) {
            degree[r[0]][0]++;
            degree[r[0]][1] = r[0];

            degree[r[1]][0]++;
            degree[r[1]][1] = r[1];
        }

        Arrays.sort(degree, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        long res = 0;
        long v = 1;
        for (int[] p : degree) {
            res += v * (long) p[0];
            v++;
        }

        return res;
    }

}