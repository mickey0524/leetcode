// https://leetcode.com/problems/construct-the-rectangle/
//
// algorithms
// Easy (48.96%)
// Total Accepted: 49,643
// Total Submissions: 101,401


class Solution {
    public int[] constructRectangle(int area) {
        int tmp = (int) Math.sqrt(area);
        int l = tmp, r = tmp;

        while ((tmp = l * r) != area) {
            if (tmp > area) {
                l--;
            } else {
                r++;
            }
        }

        return new int[] { r, l };
    }
}