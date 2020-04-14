// https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
// algorithms
// Easy (59.38%)
// Total Accepted: 10,901
// Total Submissions: 18,357


class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chArr = s.toCharArray();
        for (char ch : chArr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : chArr) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return ' ';
    }
}