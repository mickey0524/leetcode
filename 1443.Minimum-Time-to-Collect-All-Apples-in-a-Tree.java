// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
// algorithms
// Medium (56.12%)
// Total Accepted: 10,821
// Total Submissions: 19,283


class Solution {

    private static int res;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        res = 0;

        Map<Integer, List<Integer>> childMap = new HashMap<>();
        for (int[] e : edges) {
            int from = e[0], to = e[1];

            List<Integer> fromTmp = childMap.get(from);
            if (fromTmp == null) {
                fromTmp = new ArrayList<>();
                childMap.put(from, fromTmp);
            }
            fromTmp.add(to);

            List<Integer> toTmp = childMap.get(to);
            if (toTmp == null) {
                toTmp = new ArrayList<>();
                childMap.put(to, toTmp);
            }
            toTmp.add(from);
        }

        recursive(0, n, hasApple, childMap, -1);

        return res;
    }

    private boolean recursive(int curNode, int n, List<Boolean> hasApple, Map<Integer, List<Integer>> childMap,
            int parent) {
        if (curNode >= n) {
            return false;
        }

        List<Integer> children = childMap.get(curNode);
        boolean isChildHasApple = false;

        if (children != null) {
            for (int child : children) {
                if (child == parent) {
                    continue;
                }

                boolean tmp = recursive(child, n, hasApple, childMap, curNode);
                isChildHasApple |= tmp;
            }
        }

        if (isChildHasApple || hasApple.get(curNode)) {
            if (curNode != 0) {
                res += 2;
            }
            return true;
        }

        return false;
    }

}