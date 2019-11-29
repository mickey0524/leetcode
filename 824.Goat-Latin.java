// https://leetcode.com/problems/goat-latin/
//
// algorithms
// Easy (59.8%)
// Total Accepted: 44,253
// Total Submissions: 74,007
// beats 100.0% of java submissions


class Solution {

    private static final String WORD_PADDING_CHAR = "ma";
    private static final char IDX_PADDING_CHAR = 'a';
    private static final char SEPARATOR = ' ';

    public String toGoatLatin(String S) {
        HashSet<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));

        StringBuilder sb = new StringBuilder();
        StringBuilder padding = new StringBuilder();

        for (String s : S.split(" ")) {
            padding.append(IDX_PADDING_CHAR);
            if (vowelSet.contains(s.charAt(0))) {
                sb.append(s);
            } else {
                sb.append(s.substring(1)).append(s.charAt(0));
            }
            sb.append(WORD_PADDING_CHAR).append(padding).append(SEPARATOR);
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}