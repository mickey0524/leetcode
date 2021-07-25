// https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/
// algorithms
// Medium (32.26%)
// Total Accepted: 5K
// Total Submissions: 15.5K


class Solution {

    public int smallestChair(int[][] times, int targetFriend) {
        int len = times.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        List<int[]> tmp = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            tmp.add(new int[]{times[i][0], 0, i});
            tmp.add(new int[]{times[i][1], 1, i});
        }
        Collections.sort(tmp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }

                return o2[1] - o1[1];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            pq.add(i);
        }

        for (int[] pair : tmp) {
            // 到达
            if (pair[1] == 0) {
                int idx = pq.poll();
                if (pair[2] == targetFriend) {
                    return idx;
                }
                
                map.put(pair[2], idx);
            } else {
                pq.offer(map.get(pair[2]));
            }
        }

        return 0;
    }

}