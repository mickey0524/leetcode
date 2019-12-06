// https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/
// algorithms
// Medium (49.43%)
// Total Accepted: 4.3K
// Total Submissions: 8.7K
// beats 100.0% of java submissions


class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int tmp = tomatoSlices - 2 * cheeseSlices;
        if (tmp < 0 || (tmp & 1) == 1) {
            return Collections.emptyList();
        }

        int bigMac = tmp >>> 1;
        int littleFort = cheeseSlices - bigMac;

        if (littleFort < 0) {
            return Collections.emptyList();
        }

        return Arrays.asList(bigMac, littleFort);
    }
}