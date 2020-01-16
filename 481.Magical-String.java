// https://leetcode.com/problems/magical-string/
//
// algorithms
// Medium (46.84%)
// Total Accepted: 20,533
// Total Submissions: 43,839


class Solution {
    public int magicalString(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 4) {
            return 1;
        }

        int res = 1;
        List<Character> l = new ArrayList<>(Arrays.asList('1', '2', '2'));
        char ch = '1';
        int idx = 2;

        while (l.size() < n) {
            int num = l.get(idx++) - '0';
            if (ch == '1') {
                res += num;
            }
            for (int i = 0; i < num; i++) {
                l.add(ch);
            }

            ch = ch == '1' ? '2' : '1';
        }

        if (l.size() > n && ch == '2') {
            res--;
        }

        return res;
    }
}