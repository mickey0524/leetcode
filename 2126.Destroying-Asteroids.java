// https://leetcode.com/problems/destroying-asteroids/
// algorithms
// Medium (46.71%)
// Total Accepted: 9,921
// Total Submissions: 21,240


class Solution {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long longMass = mass;
        for (int n : asteroids) {
            if (longMass < n) {
                return false;
            }

            longMass += n;
        }

        return true;
    }

}