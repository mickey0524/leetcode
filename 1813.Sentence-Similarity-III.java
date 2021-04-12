// https://leetcode.com/problems/sentence-similarity-iii/
// algorithms
// Medium (45.05%)
// Total Accepted: 6,123
// Total Submissions: 13,592


class Solution {

    private static final String SPACE = " ";

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        int len1 = sentence1.length();
        int len2 = sentence2.length();

        if (len1 < len2) {
            String tmp = sentence1;
            sentence1 = sentence2;
            sentence2 = tmp;
        }

        String[] arr1 = sentence1.split(SPACE);
        String[] arr2 = sentence2.split(SPACE);
        len1 = arr1.length;
        len2 = arr2.length;
        int leftIdx = -1, rightIdx = -1;
        for (int i = 0; i < len2; i++) {
            if (!arr1[i].equals(arr2[i])) {
                leftIdx = i;
                break;
            }
        }
        for (int i = 0; i < len2; i++) {
            if (!arr1[len1 - i - 1].equals(arr2[len2 - i - 1])) {
                rightIdx = len2 - i - 1;
                break;
            }
        }

        if (leftIdx == -1 || rightIdx == -1) {
            return true;
        }
        
        return leftIdx != -1 && rightIdx != -1 && leftIdx > rightIdx;
    }
}