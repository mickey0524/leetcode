// https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
// algorithms
// Easy (60.56%)
// Total Accepted: 2,271
// Total Submissions: 3,750
// beats 100.0% of java submissions


class Solution {
    public int findSpecialInteger(int[] arr) {
        int curNum = arr[0], curTime = 0;
        int resNum = arr[0], resTime = 0;

        for (int n : arr) {
            if (curNum == n) {
                curTime++;
            } else {
                if (curTime > resTime) {
                    resTime = curTime;
                    resNum = curNum;
                }
                curNum = n;
                curTime = 1;
            }
        }

        return resTime > curTime ? resNum : curNum;
    }
}