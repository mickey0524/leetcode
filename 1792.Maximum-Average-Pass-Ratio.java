// https://leetcode.com/problems/maximum-average-pass-ratio/
// algorithms
// Medium (56.87%)
// Total Accepted: 8,049
// Total Submissions: 14,154


class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Item> pq = new PriorityQueue<>();
        for (int[] c : classes) {
            pq.add(new Item(c[1], c[0]));
        }
        
        for (int i = 0; i < extraStudents; i++) {
            Item item = pq.poll();
            item.inc();
            pq.add(item);
        }
        
        double s = 0;
        for (Item item : pq) {
            s += item.passRatio;
        }
        
        return s / classes.length;
    }

    class Item implements Comparable<Item> {

        private int total;

        private int pass;

        private double passRatio;

        Item(int total, int pass) {
            this.total = total;
            this.pass = pass;
            this.passRatio = (double) pass / total;
        }

        void inc() {
            this.total++;
            this.pass++;
            this.passRatio = (double) pass / total;
        }
        
        double getPassRatio() {
            return this.passRatio;
        }

        @Override
        public int compareTo(Item o) {
            double tmp = (double) (pass + 1) / (total + 1);
            double tmp1 = (double) (o.pass + 1) / (o.total + 1);

            double diff = tmp - passRatio;
            double diff1 = tmp1 - o.passRatio;
            
            if (diff >= diff1) {
                return -1;
            }

            return 1;
        }
    }
}
// 50 -> 60
// 33.33 -> 40
// 80 -> 83.3
// 20 -> 27.3

// 60 -> 66.6
// 33.33 -> 40
// 80 -> 83.3
// 20 -> 27.3

// 60 -> 66.6
// 33.33 -> 40
// 80 -> 83.3
// 27.3 -> 33.3

// 66.6 -> 71.4
// 33.33 -> 40
// 80 -> 83.3
// 27.3 -> 33.3

