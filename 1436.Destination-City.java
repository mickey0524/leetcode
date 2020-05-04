// https://leetcode.com/problems/destination-city/
// algorithms
// Easy (80.43%)
// Total Accepted: 8,311
// Total Submissions: 10,333
// beats 100.0% of java submissions


class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, Boolean> map = new HashMap<>();

        for (List<String> p : paths) {
            String source = p.get(0);
            String target = p.get(1);

            map.put(source, Boolean.TRUE);
            if (!map.containsKey(target)) {
                map.put(target, Boolean.FALSE);
            }
        }

        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()) {
                return entry.getKey();
            }
        }

        return null;
    }
}