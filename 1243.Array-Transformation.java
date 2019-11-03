// https://leetcode.com/problems/array-transformation/
//
// algorithms
// Easy (50.1%)
// Total Accepted: 2,047
// Total Submissions: 4,086
// beats 100.0% of java submissions


class Solution {
    public List<Integer> transformArray(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];
        res[0] = arr[0];
        res[len - 1] = arr[len - 1];

        boolean change = false;
        while (true) {
            change = false;

            for (int i = 1; i < len - 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    res[i] = arr[i] - 1;
                    change = true;
                } else if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    res[i] = arr[i] + 1;
                    change = true;
                } else {
                    res[i] = arr[i];
                }
            }

            if (!change) {
                break;
            }

            arr = Arrays.copyOf(res, len);
        }

        List<Integer> r = new ArrayList<>();
        for (int n : res) {
            r.add(n);
        }

        return r;
    }
}