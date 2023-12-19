// https://leetcode.com/problems/find-the-peaks/
// algorithms
// Easy (76.44%)
// Total Accepted: 25.3K
// Total Submissions: 33.1K


class Solution {

    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> res = new LinkedList<>();

        int len = mountain.length;
        for (int i = 1; i < len - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                res.add(i);
            }
        }

        return res;
    }

}