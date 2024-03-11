// https://leetcode.com/problems/apple-redistribution-into-boxes/description/
// algorithms
// Easy (62.8%)
// Total Accepted: 29K
// Total Submissions: 46.1K


class Solution {

    public int minimumBoxes(int[] apple, int[] capacity) {
        int appleSum = 0;

        for (int n : apple) {
            appleSum += n;
        }

        Arrays.sort(capacity);
        int capLen = capacity.length;

        for (int i = capLen - 1; i >= 0; i--) {
            appleSum -= capacity[i];
            if (appleSum <= 0) {
                return capLen - i;
            }
        }

        return -1;
    }

}