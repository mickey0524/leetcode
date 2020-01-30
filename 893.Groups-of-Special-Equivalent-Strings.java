// https://leetcode.com/problems/groups-of-special-equivalent-strings/
//
// algorithms
// Easy (64.68%)
// Total Accepted: 21,389
// Total Submissions: 33,067


class Solution {

    private static final char arrDelimiter = '#';
    private static final char numDelimiter = '_';

    public int numSpecialEquivGroups(String[] A) {
        int res = 0;
        HashSet<String> set = new HashSet<>();

        for (String s : A) {
            int[] odd = new int[26];
            int[] even = new int[26];

            for (int i = 0; i < s.length(); i++) {
                if ((i & 1) == 0) {
                    even[s.charAt(i) - 'a']++;
                } else {
                    odd[s.charAt(i) - 'a']++;
                }
            }

            set.add(buildKey(even, odd));
        }

        return set.size();
    }

    private String buildKey(int[] even, int[] odd) {
        StringBuilder sb = new StringBuilder();

        for (int n : even) {
            sb.append(n);
            sb.append(numDelimiter);
        }

        sb.append(arrDelimiter);

        for (int n : odd) {
            sb.append(n);
            sb.append(numDelimiter);
        }

        return sb.toString();
    }

}