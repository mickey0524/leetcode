// https://leetcode.com/problems/distribute-elements-into-two-arrays-i/description/
// algorithms
// Easy (70%)
// Total Accepted: 29.4K
// Total Submissions: 42K

class Solution {

    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        int[] res = new int[nums.length];
        int idx = 0;
        for (int n : arr1) {
            res[idx++] = n;
        }
        for (int n : arr2) {
            res[idx++] = n;
        }
        
        return res;
    }

}