// https://leetcode.com/problems/sort-integers-by-the-power-value/
// algorithms
// Medium (72.72%)
// Total Accepted: 5,983
// Total Submissions: 8,227


class Solution {
    public int getKth(int lo, int hi, int k) {
        ArrayList<Element> l = new ArrayList<Element>(hi - lo + 1);
        for (int i = lo; i <= hi; i++) {
            l.add(new Element(i));
        }

        Collections.sort(l);

        return l.get(k - 1).getNum();
    }

    class Element implements Comparable<Element> {
        private int num;
        private int power;

        Element(int num) {
            this.num = num;
            computePower();
        }

        private void computePower() {
            int power = 0;
            int curN = num;

            while (curN != 1) {
                if ((curN & 1) == 0) {
                    curN >>>= 1;
                } else {
                    curN = curN * 3 + 1;
                }
                power++;
            }

            this.power = power;
        }

        @Override
        public int compareTo(Element other) {
            if (this.power < other.power) {
                return -1;
            } else if (this.power > other.power) {
                return 1;
            }

            return this.num - other.num;
        }

        public int getNum() {
            return num;
        }
    }
}
