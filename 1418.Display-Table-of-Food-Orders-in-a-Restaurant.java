// https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/
// algorithms
// Medium (62.19%)
// Total Accepted: 7,297
// Total Submissions: 11,733
// beats 100.0% of java submissions


class Solution {

    private static final String TABLE = "Table";

    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Map<String, Integer>> orderMap = new TreeMap<>(Comparator.comparingInt(Integer::valueOf));
        Set<String> menu = new HashSet<>();

        for (List<String> order : orders) {
            String tableNum = order.get(1), menuName = order.get(2);
            Map<String, Integer> tableOrder = orderMap.computeIfAbsent(tableNum, k -> new HashMap<>());
            tableOrder.put(menuName, tableOrder.getOrDefault(menuName, 0) + 1);
            menu.add(menuName);
        }

        List<String> sortedMenu = new ArrayList<>(menu);
        Collections.sort(sortedMenu);
        List<String> tmp = new ArrayList<>();
        tmp.add(TABLE);
        tmp.addAll(sortedMenu);
        res.add(tmp);

        for (Map.Entry<String, Map<String, Integer>> entry : orderMap.entrySet()) {
            tmp = new ArrayList<>();

            tmp.add(entry.getKey());
            Map<String, Integer> map = entry.getValue();
            for (String m : sortedMenu) {
                tmp.add(String.valueOf(map.getOrDefault(m, 0)));
            }

            res.add(tmp);
        }

        return res;
    }
}