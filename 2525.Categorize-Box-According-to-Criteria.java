// https://leetcode.com/problems/categorize-box-according-to-criteria/description/
// algorithms
// Easy (33.3%)
// Total Accepted: 19.1K
// Total Submissions: 57.3K


class Solution {

    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isHeavy = mass >= 100;
        boolean isBulky = length >= 10000 || width >= 10000 || height >= 10000;
        if (!isBulky) {
            long dimension = (long) length * (long) width * (long) height;
            isBulky = dimension >= 1000000000;
        }

        if (isHeavy && isBulky) {
            return "Both";
        }

        if (!isHeavy && !isBulky) {
            return "Neither";
        }

        if (isHeavy) {
            return "Heavy";
        }

        return "Bulky";
    }

}