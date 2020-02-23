// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
// algorithms
// Easy (67.65%)
// Total Accepted: 2,973
// Total Submissions: 4,395
// beats 100.0% of java submissions


class Solution {
    public int[] sortByBits(int[] arr) {
        int len = arr.length;

        ArrayList<Helper> l = new ArrayList<>(len);
        for (int n : arr) {
            l.add(new Helper(n));
        }

        Collections.sort(l);
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = l.get(i).getNum();
        }

        return res;
    }

    class Helper implements Comparable<Helper> {
        private int num;
        private int oneOfbinary;

        Helper(int n) {
            this.num = n;
            String tmp = Integer.toBinaryString(n);
            int one = 0;

            for (char ch : tmp.toCharArray()) {
                if (ch == '1') {
                    one++;
                }
            }

            this.oneOfbinary = one;
        }

        public int getNum() {
            return num;
        }

        @Override
        public int compareTo(Helper o) {
            if (this.oneOfbinary < o.oneOfbinary) {
                return -1;
            } else if (this.oneOfbinary > o.oneOfbinary) {
                return 1;
            } else {
                return this.num <= o.num ? -1 : 1;
            }
        }
    }

}