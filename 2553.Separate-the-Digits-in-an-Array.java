// https://leetcode.com/problems/separate-the-digits-in-an-array/description/
// algorithms
// Easy (78.76%)
// Total Accepted: 20.4K
// Total Submissions: 25.9K


class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int n : nums) {
            String tmp = String.valueOf(n);
            for (char ch : tmp.toCharArray()) {
                list.add(ch - '0');
            }
        }

        int[] res = new int[list.size()];
        int idx = 0;
        for (int n : list) {
            res[idx++] = n;
        }

        return res;
    }
}