// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
// algorithms
// Easy (77.45%)
// Total Accepted: 6,311
// Total Submissions: 8,148
// beats 100.0% of java submissions


class Solution {
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] res = new int[len];

        LinkedList<int[]> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                stack.offerLast(new int[] { prices[i], i });
                continue;
            }

            while (!stack.isEmpty()) {
                int[] pre = stack.peekLast();
                if (prices[i] <= pre[0]) {
                    stack.pollLast();
                    res[pre[1]] = pre[0] - prices[i];
                } else {
                    break;
                }
            }

            stack.offerLast(new int[] { prices[i], i });
        }

        while (!stack.isEmpty()) {
            int[] tmp = stack.pollLast();
            res[tmp[1]] = tmp[0];
        }

        return res;
    }
}