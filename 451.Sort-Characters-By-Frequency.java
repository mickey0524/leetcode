// https://leetcode.com/problems/sort-characters-by-frequency/
//
// algorithms
// Medium (67.48%)
// Total Accepted:    345,470
// Total Submissions: 511,943


class Solution {

    public String frequencySort(String s) {
        List<Item> list = new ArrayList<>();
        Map<Character, Item> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            Item item = map.get(ch);
            if (item == null) {
                item = new Item(ch, 0);
                map.put(ch, item);
                list.add(item);
            }

            item.inc();
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < list.get(i).getNum(); j++) {
                sb.append(list.get(i).getCh());
            }
        }

        return sb.toString();
    }

    class Item implements Comparable<Item> {

        private char ch;

        private int num;

        Item(char ch, int num) {
            this.ch = ch;
            this.num = num;
        }

        public void inc() {
            num++;
        }

        public int getNum() {
            return num;
        }

        public char getCh() {
            return ch;
        }

        @Override
        public int compareTo(Item o) {
            if (num < o.getNum()) {
                return 1;
            }

            return -1;
        }
    }

}