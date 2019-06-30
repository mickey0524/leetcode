// https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/
//
// algorithms
// Easy (68.77%)
// Total Accepted: 1,808
// Total Submissions: 2,629
// beats 100.0% of java submissions

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        if (label == 1) {
            return Collections.singletonList(1);
        }

        int base = 2, level = 1;
        while (label >= base) {
            base <<= 1;
            level++;
        }

        LinkedList<Integer> res = new LinkedList<>();
        res.offer(label);
        boolean l2r = (level & 1) == 1;
        int position = l2r ? label - (base >> 1) : base - label - 1;

        for (int i = 0; i < level - 2; i++) {
            l2r = !l2r;
            position /= 2;
            base /= 2;

            if (l2r) {
                res.offerFirst(position + (base >> 1));
            } else {
                res.offerFirst(base - 1 - position);
            }
        }
        res.offerFirst(1);

        return res;
    }
}