// https://leetcode.com/problems/add-to-array-form-of-integer/
//
// algorithms
// Medium (51.97%)
// Total Accepted: 27,452
// Total Submissions: 62,341
// beats 100.0% of java submissions


class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int len = A.length;
        int idx = len - 1;
        int carry = 0;
        LinkedList<Integer> l = new LinkedList<>();

        while (K != 0 || idx >= 0) {
            int tmp = K % 10;
            K /= 10;
            tmp += carry;

            if (idx >= 0) {
                tmp += A[idx];
            }

            if (tmp >= 10) {
                tmp -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            l.offerFirst(tmp);

            idx--;
        }

        if (carry != 0) {
            l.offerFirst(carry);
        }

        return (List<Integer>) l;
    }
}