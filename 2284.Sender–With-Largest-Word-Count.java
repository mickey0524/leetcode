// https://leetcode.com/problems/sender-with-largest-word-count/
// algorithms
// Medium (52.2%)
// Total Accepted: 13K
// Total Submissions: 24.9K


class Solution {
    
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        int len = messages.length;
            
        for (int i = 0; i < len; i++) {
            int wordNum = map.getOrDefault(senders[i], 0);
            map.put(senders[i], wordNum + messages[i].split(" ").length);
        }
        
        int maxWordCnt = Integer.MIN_VALUE;
        String maxWordCntSender = null;
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxWordCnt) {
                maxWordCnt = entry.getValue();
                maxWordCntSender = entry.getKey();
            } else if (entry.getValue() == maxWordCnt && maxWordCntSender.compareTo(entry.getKey()) < 0) {
                maxWordCntSender = entry.getKey();
            }
        }
        
        return maxWordCntSender;
    }
    
}