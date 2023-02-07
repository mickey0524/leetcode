// https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/
// algorithms
// Easy (65,49%)
// Total Accepted: 18.6K
// Total Submissions: 28.4K


class Solution {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int n : gifts) {
            pq.offer(n);
        }

        long res = 0;
        for (int i = 0; i < k; i++) {
            int curMaxGift = pq.poll();
            int tmp = (int) Math.sqrt(curMaxGift);
            pq.offer(tmp);
        }

        for (int n : pq) {
            res += (long) n;
        }
        return res;
    }

}
