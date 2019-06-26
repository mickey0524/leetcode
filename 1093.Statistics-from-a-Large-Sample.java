// https://leetcode.com/problems/statistics-from-a-large-sample/
//
// algorithms
// Medium (40.40%)
// Total Accepted: 3,208
// Total Submissions: 7,940

class Solution {
    public double[] sampleStats(int[] count) {
        int minimum = -1, maximum = -1, num = 0, maxCount = -1, mode = -1;
        long sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> l = new ArrayList<>();

        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                num += count[i];
                sum += (count[i] * i);

                if (minimum == -1) {
                    minimum = i;
                }

                if (count[i] > maxCount) {
                    maxCount = count[i];
                    mode = i;
                }

                maximum = i;

                l.add(num - 1);
                map.put(num - 1, i);
            }
        }

        double[] res = new double[5];
        res[0] = (double) minimum;
        res[1] = (double) maximum;
        res[2] = (double) sum / num;
        res[4] = (double) mode;

        int i = 0, j = l.size() - 1, m = -1;
        int target = num / 2;
        while (i <= j) {
            m = i + (j - i) / 2;
            if (l.get(m) < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        if ((num & 1) == 1) {
            res[3] = (double) map.get(l.get(j + 1));
        } else {
            if (target == l.get(j) + 1) {
                res[3] = (double) (map.get(l.get(j + 1)) + map.get(l.get(j))) / 2;
            } else {
                res[3] = (double) map.get(l.get(j + 1));
            }
        }

        return res;
    }
}