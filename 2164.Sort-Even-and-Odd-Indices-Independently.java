// https://leetcode.com/problems/sort-even-and-odd-indices-independently/
// algorithms
// Easy (65.42%)
// Total Accepted: 10,469
// Total Submissions: 16,002


class Solution {

    public int[] sortEvenOdd(int[] nums) {
        int len = nums.length;
        int oddLen = len / 2;
        int evenLen = (len + 1) / 2;

        int[] oddNums = new int[oddLen];
        int[] evenNums = new int[evenLen];
        for (int i = 0; i < len; i += 2) {
            int idx = i / 2;
            evenNums[idx] = nums[i];
            if (i + 1 < len) {
                oddNums[idx] = nums[i + 1];
            }
        }

        Arrays.sort(evenNums);
        Arrays.sort(oddNums);
        reverse(oddNums);
        for (int i = 0; i < len; i += 2) {
            int idx = i / 2;
            nums[i] = evenNums[idx];
            if (i + 1 < len) {
                nums[i + 1] = oddNums[idx];
            }
        }

        return nums;
    }
    
    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
            i++;
            j--;
        }
    }

}