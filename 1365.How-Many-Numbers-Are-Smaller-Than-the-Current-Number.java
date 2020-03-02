// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
// algorithms
// Easy (88.4%)
// Total Accepted: 5,714
// Total Submissions: 6,464
// beats 100.0% of java submissions


class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        ArrayList<Tuple> l = new ArrayList<>();
        HashMap<Integer, Tuple> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            Tuple tmp = map.get(nums[i]);
            if (tmp == null) {
                tmp = new Tuple(nums[i]);
                map.put(nums[i], tmp);
                l.add(tmp);
            }
            tmp.addIndex(i);
        }
        Collections.sort(l);

        int tmp = 0;
        for (int i = 0; i < l.size(); i++) {
            ArrayList<Integer> indexList = l.get(i).getIndex();
            for (int idx : indexList) {
                res[idx] = tmp;
            }
            tmp += indexList.size();
        }

        return res;
    }

    class Tuple implements Comparable<Tuple> {

        private int num;
        private ArrayList<Integer> index;

        Tuple(int num) {
            this.num = num;
            this.index = new ArrayList<>();
        }

        public void addIndex(int index) {
            this.index.add(index);
        }

        public int getNum() {
            return this.num;
        }

        public ArrayList<Integer> getIndex() {
            return this.index;
        }

        @Override
        public int compareTo(Tuple another) {
            return this.num - another.num;
        }
    }
}