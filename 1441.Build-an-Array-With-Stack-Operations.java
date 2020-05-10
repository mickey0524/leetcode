// https://leetcode.com/problems/build-an-array-with-stack-operations/
// algorithms
// Easy (68.48%)
// Total Accepted: 7,444
// Total Submissions: 10,870
// beats 100.0% of java submissions


class Solution {

    private static final String PUSH = "Push";
    private static final String POP = "Pop";

    public List<String> buildArray(int[] target, int n) {
        List<String> l = new LinkedList<>();
        int preTarget = 0;

        for (int t : target) {
            l.add(PUSH);

            int diff = t - preTarget;
            if (diff != 1) {
                for (int i = 0; i < diff - 1; i++) {
                    l.add(POP);
                    l.add(PUSH);
                }
            }

            preTarget = t;
        }

        return l;
    }
}