// https://leetcode.com/problems/sliding-window-maximum/
//
// algorithms
// Hard (37.85%)
// Total Accepted:    152,428
// Total Submissions: 402,716
// beats 88.66% of java submissions

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length == 0 || k == 0) {
            return new int[]{};
        }
        
        int[] res = new int[length - k + 1];
        LinkedList<Integer> stack = new LinkedList<>();
        
        for (int i = 0; i < k; i++) {
            while (stack.size() > 0) {
                if (nums[i] >= nums[stack.peekLast()]) {
                    stack.pollLast();
                } else {
                    break;
                }
            }
            stack.offer(i);
        }
        
        int resIdx = 0;
        for (int i = k; i < length; i++) {
            res[resIdx] = nums[stack.peekFirst()];
            resIdx++;
            if ((i - stack.peekFirst() + 1) > k) {
                stack.pollFirst();
            }
            
            while (stack.size() > 0) {
                if (nums[i] >= nums[stack.peekLast()]) {
                    stack.pollLast();
                } else {
                    break;
                }
            }
            stack.offer(i);
        }
        
        res[resIdx] = nums[stack.peekFirst()];
        
        return res;
        
    }
}