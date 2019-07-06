// https://leetcode.com/problems/bulls-and-cows/
//
// algorithms
// Medium (39.79%)
// Total Accepted:    99,494
// Total Submissions: 250,066
// beats 100.0% of java submissions

class Solution {
    public String getHint(String secret, String guess) {
        int[] sNum = new int[10], gNum = new int[10];
        int bulls = 0;
        
        for (int i = 0; i < Math.min(secret.length(), guess.length()); i++) {
            char chS = secret.charAt(i), chG = guess.charAt(i);
            if (chS == chG) {
                bulls++;
            } else {
                sNum[chS - '0']++;
                gNum[chG - '0']++;
            }
        }
        
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(sNum[i], gNum[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append('A').append(cows)
            .append('B');
        
        return sb.toString();
    }
}