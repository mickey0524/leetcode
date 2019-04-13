// https://leetcode.com/problems/h-index/
//
// algorithms
// Medium (34.48%)
// Total Accepted:    119,735
// Total Submissions: 347,216
// beats 100.0% of java submissions

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        
        int res = length;
        while (res > 0) {
            if (res == length) {
                if (citations[length - res] >= res) {
                    return res;
                }
            } else {
                if (citations[length - res] >= res && citations[length - res - 1] <= res) {
                    return res;
                }
            }
            
            res--;
        }
        
        return 0;
    }
}