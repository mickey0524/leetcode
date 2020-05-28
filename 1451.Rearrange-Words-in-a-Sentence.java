// https://leetcode.com/problems/rearrange-words-in-a-sentence/
// algorithms
// Medium (52.66%)
// Total Accepted: 12,400
// Total Submissions: 23,549
// beats 100.0% of java submissions


class Solution {
    public String arrangeWords(String text) {
        if (text == null || text.length() == 0) {
            return "";
        }

        String[] arr = text.split(" ");
        arr[0] = arr[0].toLowerCase();
        int len = arr.length;
        ArrayList<Pair> list = new ArrayList<>(len);

        for (int i = 0; i < len; i++) {
            list.add(new Pair(i, arr[i]));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        String firstStr = list.get(0).getStr();
        sb.append(firstStr.substring(0, 1).toUpperCase() + firstStr.substring(1));

        for (int i = 1; i < len; i++) {
            sb.append(" ").append(list.get(i).getStr());
        }

        return sb.toString();
    }

    class Pair implements Comparable<Pair> {

        private int idx;
        private String str;

        Pair(int idx, String str) {
            this.idx = idx;
            this.str = str;
        }

        int getIdx() {
            return idx;
        }

        String getStr() {
            return str;
        }

        int getStrLen() {
            return str.length();
        }

        @Override
        public int compareTo(Pair o) {
            int len1 = getStrLen();
            int len2 = o.getStrLen();

            if (len1 == len2) {
                return getIdx() - o.getIdx();
            }

            return len1 - len2;
        }
    }
}