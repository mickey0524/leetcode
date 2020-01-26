// https://leetcode.com/problems/rank-transform-of-an-array/
// algorithms
// Easy (55.65%)
// Total Accepted: 2,374
// Total Submissions: 4,266
// beats 100.0% of java submissions


class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            List<Integer> l = map.get(arr[i]);
            if (l == null) {
                l = new ArrayList<>();
                map.put(arr[i], l);
            }

            l.add(i);
        }

        ArrayList<Integer> l = new ArrayList<>(map.keySet());
        Collections.sort(l);
        for (int i = 0; i < l.size(); i++) {
            for (int idx : map.get(l.get(i))) {
                arr[idx] = i + 1;
            }
        }

        return arr;
    }
}