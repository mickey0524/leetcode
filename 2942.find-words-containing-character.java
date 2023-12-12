// https://leetcode.com/problems/find-words-containing-character/description/
// algorithms
// Easy (88.5%)
// Total Accepted: 30K
// Total Submissions: 33.9K


class Solution {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        int len = words.length;
        
        for (int i = 0; i < len; i++) {
            for (char ch : words[i].toCharArray()) {
                if (ch == x) {
                    res.add(i);
                    break;
                }
            }
        }
        
        return res;
    }

}