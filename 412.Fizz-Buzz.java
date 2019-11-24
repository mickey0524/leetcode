// https://leetcode.com/problems/fizz-buzz/
//
// algorithms
// Easy (60.46%)
// Total Accepted: 255,086
// Total Submissions: 421,882


class Solution {

    private static final int THREE_BASE = 3;
    private static final int FIVE_BASE = 5;
    private static final int THREE_FIVE_BASE = 15;
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZ_BUZZ = "FizzBuzz";

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        int three = THREE_BASE, five = FIVE_BASE, threeFive = THREE_FIVE_BASE;

        for (int i = 1; i <= n; i++) {
            if (i == threeFive) {
                res.add(FIZZ_BUZZ);
                threeFive += THREE_FIVE_BASE;
                three += THREE_BASE;
                five += FIVE_BASE;
            } else if (i == three) {
                res.add(FIZZ);
                three += THREE_BASE;
            } else if (i == five) {
                res.add(BUZZ);
                five += FIVE_BASE;
            } else {
                res.add(String.valueOf(i));
            }
        }

        return res;
    }
}