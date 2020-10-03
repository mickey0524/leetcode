// https://leetcode.com/problems/crawler-log-folder/
// algorithms
// Easy (64.53%)
// Total Accepted: 9,994
// Total Submissions: 15,488
// beats 100.0% of java submissions


class Solution {

    private static final String MOVE_TO_PARENT = "../";

    private static final String STAY_CUR_LEVEL = "./";

    public int minOperations(String[] logs) {
        int level = 0;

        for (String log : logs) {
            if (MOVE_TO_PARENT.equals(log)) {
                if (level > 0) {
                    level--;
                }
            } else if (STAY_CUR_LEVEL.equals(log)) {
                // nop
            } else {
                level++;
            }
        }

        return level;
    }
}