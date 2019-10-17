// https://leetcode.com/problems/jewels-and-stones/
//
// algorithms
// Easy (83.8%)
// Total Accepted: 336,373
// Total Submissions: 401,397
// beats 100.0% of java submissions


class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> s = new HashSet<>();
        for (char ch : J.toCharArray()) {
            s.add(ch);
        }

        int res = 0;
        for (char ch : S.toCharArray()) {
            if (s.contains(ch)) {
                res++;
            }
        }

        return res;
    }
}