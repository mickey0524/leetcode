// https://leetcode.com/problems/the-k-strongest-values-in-an-array/
// algorithms
// Medium (56.31%)
// Total Accepted: 10,135
// Total Submissions: 17,997


class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int len = arr.length;
        int m = arr[(len - 1) / 2];

        List<Integer> list = new ArrayList<>(len);
        for (int n : arr) {
            list.add(n);
        }

        Collections.sort(list, (o1, o2) -> {
            int tmp1 = Math.abs(o1 - m);
            int tmp2 = Math.abs(o2 - m);
            if (tmp1 == tmp2) {
                return o2 - o1;
            }

            return tmp2 - tmp1;
        });

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

}