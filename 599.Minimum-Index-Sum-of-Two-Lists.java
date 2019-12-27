// https://leetcode.com/problems/minimum-index-sum-of-two-lists/
//
// algorithms
// Easy (49.31%)
// Total Accepted: 72,660
// Total Submissions: 147,358
// beats 100.0% of java submissions


class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        ArrayList<String> l = new ArrayList<>();
        int curIndex = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                int idx1 = map1.get(list2[i]);
                int tmp = idx1 + i;

                if (tmp < curIndex) {
                    l.clear();
                    l.add(list2[i]);
                    curIndex = tmp;
                } else if (tmp == curIndex) {
                    l.add(list2[i]);
                }
            }
        }

        return l.toArray(new String[0]);
    }
}