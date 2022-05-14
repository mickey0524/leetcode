// https://leetcode.com/problems/count-number-of-texts/
// algorithms
// Medium (48.45%)
// Total Accepted: 7,617
// Total Submissions: 15,721


class Solution {
    
    private static int MODULE = 1000000007;
    
    private static int[] MAPPING = new int[10];
    
    static {
        Arrays.fill(MAPPING, 3);
        MAPPING[7] = 4;
        MAPPING[9] = 4;
    }
    
    public int countTexts(String pressedKeys) {
        if (pressedKeys == null) {
            return 0;
        }
        int len = pressedKeys.length();
        if (len < 2) {
            return len;
        }
        
        long[] dp = new long[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len; i++) {
            char curCh = pressedKeys.charAt(i);
            if (curCh != pressedKeys.charAt(i - 1)) {
                dp[i + 1] = dp[i];
            } else {
                long tmp = 0;
                for (int j = i - 1; j >= Math.max(-1, i - MAPPING[curCh - '0']); j--) {
                    tmp += dp[j + 1];

                    if (j >= 0 && pressedKeys.charAt(j) != curCh) {
                        break;
                    }
                }

                if (tmp > MODULE) {
                    tmp %= MODULE;
                }
                dp[i + 1] = tmp;
            }
        }
        
        return (int) dp[len];
    }
    
}