// https://leetcode.com/problems/occurrences-after-bigram/
//
// algorithms
// Easy (69.8%)
// Total Accepted: 2,625
// Total Submissions: 3,761
// beats 100.0% of java submissions

class Solution {
    public String[] findOcurrences(String text, String first, String second) {        
        String[] wordArr = text.split(" ");
        int len = wordArr.length;
        if (len < 3) {
            return new String[]{};
        }
        
        int i = 0;
        ArrayList<String> l = new ArrayList<>();
        
        while (i < len - 2) {
            if (wordArr[i].equals(first) && wordArr[i + 1].equals(second)) {
                l.add(wordArr[i + 2]);
            }
            i++;
        }
        
        String[] res = l.toArray(new String[l.size()]);
        
        return res;
    }
}


class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> l = new ArrayList<>();
        String[] arr = text.split(" ");
        int idx = 0, len = arr.length;

        while (idx < len) {
            if (idx < len - 2 && arr[idx].equals(first) && arr[idx + 1].equals(second)) {
                l.add(arr[idx + 2]);
            }
            idx++;
        }

        return l.toArray(new String[0]);
    }
}
