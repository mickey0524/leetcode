// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
// algorithms
// Easy (68.76%)
// Total Accepted: 5,717
// Total Submissions: 8,314
// beats 100.0% of java submissions


class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Row[] rows = new Row[mat.length];

        for (int i = 0; i < mat.length; i++) {
            int soldierNum = 0;
            for (int n : mat[i]) {
                if (n == 1) {
                    soldierNum++;
                } else {
                    break;
                }
            }
            rows[i] = new Row(soldierNum, i);
        }

        Arrays.sort(rows);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = rows[i].getIndex();
        }

        return res;
    }

    private class Row implements Comparable<Row> {

        private int soldierNum;
        private int index;

        public Row(int soldierNum, int index) {
            this.soldierNum = soldierNum;
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Row o) {
            if (this.soldierNum < o.soldierNum) {
                return -1;
            } else if (this.soldierNum > o.soldierNum) {
                return 1;
            }

            return this.index < o.index ? -1 : 1;
        }
    }
}