// https://leetcode.com/problems/reduce-array-size-to-the-half/
// algorithms
// Easy (66.72%)
// Total Accepted: 5,305
// Total Submissions: 7,951
// beats 100.0% of java submissions


class Solution {
    public int minSetSize(int[] arr) {
        int len = arr.length;
        int threshold = len >>> 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        ArrayList<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);

        int res = 0, sum = 0;
        for (int i = values.size() - 1; i >= 0; i--) {
            sum += values.get(i);
            res++;

            if (sum >= threshold) {
                break;
            }
        }

        return res;
    }
}