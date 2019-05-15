import java.util.HashMap;

// https://leetcode.com/problems/interleaving-string/
//
// algorithms
// Hard (27.87%)
// Total Accepted: 110,126
// Total Submissions: 395,156
// beats 92.99% of java submissions


class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();

        if (len1 + len2 != len3) {
            return false;
        }

        HashMap<String, Boolean> map = new HashMap<>();

        return recursive(s1, s2, s3, 0, 0, 0, map);
    }

    public boolean recursive(String s1, String s2, String s3, int idx1, int idx2, int idx3,
            HashMap<String, Boolean> map) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();

        if (idx3 == len3) {
            return true;
        }

        String key = String.valueOf(idx1) + ":" + String.valueOf(idx2);
        if (map.containsKey(key)) {
            return map.get(key);
        }

        boolean res = false;

        if (idx1 == len1) {
            res = s2.substring(idx2).equals(s3.substring(idx3));
        } else if (idx2 == len2) {
            res = s1.substring(idx1).equals(s3.substring(idx3));
        } else {
            if (s1.charAt(idx1) == s3.charAt(idx3)) {
                res = recursive(s1, s2, s3, idx1 + 1, idx2, idx3 + 1, map);
            }
            if (!res && s2.charAt(idx2) == s3.charAt(idx3)) {
                res = recursive(s1, s2, s3, idx1, idx2 + 1, idx3 + 1, map);
            }
        }

        map.put(key, res);

        return res;
    }
}