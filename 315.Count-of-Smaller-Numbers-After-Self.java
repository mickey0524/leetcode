// https://leetcode.com/problems/count-of-smaller-numbers-after-self/
//
// algorithms
// Hard (37.96%)
// Total Accepted:    74,842
// Total Submissions: 197,164
// beats 92.20% of java submissions
// 这道题开始一直没有用 mapping 数值来保存下标，res 一直加错索引，后面断点调试发现了

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> l = new ArrayList<>(len);
        if (len == 0) {
            return l;
        }
        int[] res = new int[len];
        int[] mapping = new int[len];

        for (int i = 0; i < len; i++) {
            mapping[i] = i;
        }

        mergeSort(nums, mapping, res, 0, nums.length - 1);

        for (int i = 0; i < len; i++) {
            l.add(res[i]);
        }

        return l;
    }

    public void mergeSort(int[] nums, int[] mapping, int[] res, int head, int tail) {
        if (tail == head) {
            return;
        }

        int middle = head + (tail - head) / 2;
        mergeSort(nums, mapping, res, head, middle);
        mergeSort(nums, mapping, res,middle + 1, tail);

        int l = head, r = middle + 1;
        int[] tmp = new int[tail - head + 1];
        int idx = 0;
        while (l <= middle && r <= tail) {
            if (nums[mapping[l]] > nums[mapping[r]]) {
                tmp[idx] = mapping[l];
                res[mapping[l]] += (tail - r + 1);
                l++;
            } else {
                tmp[idx] = mapping[r];
                r++;
            }
            idx++;
        }

        while (l <= middle) {
            tmp[idx++] = mapping[l++];
        }
        while (r <= tail) {
            tmp[idx++] = mapping[r++];
        }

        for (int i = head; i <= tail; i++) {
            mapping[i] = tmp[i - head];
        }

    }

}