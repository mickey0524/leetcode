// https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/
// algorithms
// Medium (50.79%)
// Total Accepted: 6,742
// Total Submissions: 13,274


class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int[] tmp1 = getNum(nums1);
        int[] tmp2 = getNum(nums2);
        int sum1 = getSum(tmp1);
        int sum2 = getSum(tmp2);
        
        if (sum1 == sum2) {
            return 0;
        }
        
        int res = 0;
        int curDiff = sum1 - sum2;
        
        while (curDiff != 0) {
            int absCurDiff = Math.abs(curDiff);
            int first = -1, last = -1;
            
            for (int i = 1; i < 7; i++) {
                if (tmp1[i] == 0) {
                    continue;
                }
                
                if (first == -1) {
                    first = i;
                }
                last = i;
                
                if (curDiff > 0) {
                    if (i - 1 >= absCurDiff) {
                        return res + 1;
                    }
                } else {
                    if (6 - i >= absCurDiff) {
                        return res + 1;
                    }
                }
            }
            
            int first1 = -1, last1 = -1;
            for (int i = 1; i < 7; i++) {
                if (tmp2[i] == 0) {
                    continue;
                }
                
                if (first1 == -1) {
                    first1 = i;
                }
                last1 = i;
                
                if (curDiff > 0) {
                    if (6 - i >= absCurDiff) {
                        return res + 1;
                    }
                } else {
                    if (i - 1 >= absCurDiff) {
                        return res + 1;
                    }
                }
            }
            
            if (curDiff > 0) {
                int contribution = last - 1;
                int contribution1 = 6 - first1;
                
                if (contribution == 0 && contribution1 == 0) {
                    return -1;
                }
                
                if (contribution >= contribution1) {
                    curDiff -= contribution;
                    tmp1[last]--;
                    tmp1[1]++;
                } else {
                    curDiff -= contribution1;
                    tmp2[first1]--;
                    tmp2[6]++;
                }
            } else {
                int contribution = 6 - first;
                int contribution1 = last1 - 1;
                
                if (contribution == 0 && contribution1 == 0) {
                    return -1;
                }
                
                if (contribution >= contribution1) {
                    curDiff += contribution;
                    tmp1[first]--;
                    tmp1[6]++;
                } else {
                    curDiff += contribution1;
                    tmp2[last1]--;
                    tmp2[1]++;
                }
            }
            
            res++;
        }
        
        return res;
    }
    
    private int[] getNum(int[] arr) {
        int[] res = new int[7];
        
        for (int n : arr) {
            res[n]++;
        }
        
        return res;
    } 
    
    private int getSum(int[] tmp) {
        int res = 0;
        
        for (int i = 1; i < 7; i++) {
            res += i * tmp[i];
        }
        
        return res;
    }
}


// 21 - 10 = 11