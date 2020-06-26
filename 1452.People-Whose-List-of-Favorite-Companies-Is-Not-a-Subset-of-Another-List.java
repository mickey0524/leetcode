// https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/
// algorithms
// Medium (52.92%)
// Total Accepted: 10,890
// Total Submissions: 20,578


class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<String, Set<Integer>> map = new HashMap<>();
        int len = favoriteCompanies.size();
        for (int i = 0; i < len; i++) {
            List<String> l = favoriteCompanies.get(i);
            for (String s : l) {
                Set<Integer> set = map.computeIfAbsent(s, k -> new HashSet<>());
                set.add(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            List<String> l = favoriteCompanies.get(i);
            Set<Integer> intersection = new HashSet<>();
            for (String s : l) {
                if (intersection.isEmpty()) {
                    intersection.addAll(map.get(s));
                } else {
                    intersection.retainAll(map.get(s));
                }
            }

            boolean isFound = false;
            if (!intersection.isEmpty()) {
                for (int idx : intersection) {
                    if (idx != i) {
                        isFound = true;
                        break;
                    }
                }
            }
            if (!isFound) {
                res.add(i);
            }
        }

        return res;
    }
}