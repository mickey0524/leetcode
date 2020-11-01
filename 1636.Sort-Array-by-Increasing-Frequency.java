// https://leetcode.com/problems/sort-array-by-increasing-frequency/
// algorithms
// Easy (63.81%)
// Total Accepted: 4,274
// Total Submissions: 6,698
// beats 100.0% of java submissions


class Solution {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Item> map = new HashMap<>();

        for (int n : nums) {
            Item item = map.computeIfAbsent(n, Item::new);
            item.inc();
        }

        List<Item> l = new ArrayList<>(map.values());
        Collections.sort(l);

        int[] res = new int[nums.length];
        int idx = 0;
        for (Item item : l) {
            for (int i = 0; i < item.getNum(); i++) {
                res[idx++] = item.getKey();
            }
        }

        return res;
    }

    class Item implements Comparable<Item> {

        private int key;

        private int num;

        public Item(int key) {
            this.key = key;
        }

        private void inc() {
            this.num++;
        }

        public int getKey() {
            return key;
        }

        public int getNum() {
            return num;
        }

        @Override
        public int compareTo(Item o) {
            if (num < o.getNum()) {
                return -1;
            } else if (num > o.getNum()) {
                return 1;
            }

            return o.getKey() - key;
        }
    }

}