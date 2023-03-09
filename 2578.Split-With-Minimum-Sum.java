// https://leetcode.com/problems/left-and-right-sum-differences/description/
// algorithms
// Easy (68.56%)
// Total Accepted: 15.7K
// Total Submissions: 22.9K

class Solution {

    public int splitNum(int num) {
        List<Integer> list = new ArrayList<>();

        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }

        Collections.sort(list);
        int res1 = 0;
        int res2 = 0;
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            res1 = res1 * 10 + list.get(i);
            if (i + 1 < size) {
                res2 = res2 * 10 + list.get(i + 1);
            }
        }

        return res1 + res2;
    }

}

