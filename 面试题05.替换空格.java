// https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
// algorithms
// Easy (76.75%)
// Total Accepted: 28,669
// Total Submissions: 37,354


class Solution {

    private static final String SPACE = " ";
    private static final String SPACE_REPLACE = "%20";

    public String replaceSpace(String s) {
        return s.replace(SPACE, SPACE_REPLACE);
    }
}