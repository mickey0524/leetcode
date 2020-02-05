// https://leetcode.com/problems/next-greater-element-i/
//
// algorithms
// Easy (61.91%)
// Total Accepted: 127,813
// Total Submissions: 206,445


class Solution {

    private static final int PLACEHOLDER = -1;

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();

        for (int n : nums2) {
            while (!stack.isEmpty() && n > stack.peekLast()) {
                map.put(stack.pollLast(), n);
            }

            stack.offer(n);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                res[i] = map.get(nums1[i]);
            } else {
                res[i] = PLACEHOLDER;
            }
        }

        return res;
    }
}