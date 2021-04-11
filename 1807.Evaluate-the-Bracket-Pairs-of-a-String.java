// https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/
// algorithms
// Medium (67.26%)
// Total Accepted: 8,449
// Total Submissions: 12,561


class Solution {

    private static final String QUESTION_MARK = "?";
    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder sb = new StringBuilder();
        char[] chArr = s.toCharArray();
        int len = chArr.length;
        int idx = 0;

        while (idx < len) {
            if (chArr[idx] == LEFT_BRACKET) {
                int j = idx + 1;
                while (j < len && chArr[j] != RIGHT_BRACKET) {
                    j++;
                }

                // bad case
                if (j == len) {
                    break;
                }

                String key = s.substring(idx + 1, j);
                String value = map.getOrDefault(key, QUESTION_MARK);
                sb.append(value);
                idx = j + 1;
            } else {
                sb.append(chArr[idx++]);
            }
        }

        return sb.toString();
    }
}