// https://leetcode.com/problems/most-common-word/
//
// algorithms
// Easy (66.88%)
// Total Accepted: 59,674
// Total Submissions: 89,223


class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        int pointIdx = -1;

        for (String domain : cpdomains) {
            String[] arr = domain.split(" ");
            String d = arr[1];
            int n = Integer.valueOf(arr[0]);

            map.put(d, map.getOrDefault(d, 0) + n);
            pointIdx = d.indexOf('.');
            while (pointIdx != -1) {
                String tmp = d.substring(pointIdx + 1);
                map.put(tmp, map.getOrDefault(tmp, 0) + n);
                pointIdx = d.indexOf('.', pointIdx + 1);
            }
        }

        ArrayList<String> res = new ArrayList<>(map.size());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String k = entry.getKey();
            int v = entry.getValue();

            StringBuilder sb = new StringBuilder();
            sb.append(v).append(' ').append(k);
            res.add(sb.toString());
        }

        return res;
    }
}