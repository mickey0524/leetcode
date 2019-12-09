// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
// algorithms
// Medium (85.43%)
// Total Accepted: 4,431
// Total Submissions: 5,187
// beats 100.0% of java submissions


class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int g = groupSizes[i];
            if (!map.containsKey(g)) {
                map.put(g, new ArrayList<>());
            }

            ArrayList<Integer> l = map.get(g);
            l.add(i);

            if (l.size() == g) {
                res.add(new ArrayList<>(l));
                l.clear();
            }
        }

        return res;
    }
}