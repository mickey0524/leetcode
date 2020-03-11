// https://leetcode.com/problems/time-needed-to-inform-all-employees/
// algorithms
// Medium (54.73%)
// Total Accepted: 6,147
// Total Submissions: 11,232


class Solution {

    private static int res;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, TreeNode> map = buildMap(manager);
        res = 0;

        recursive(headID, 0, map, informTime);

        return res;
    }

    private void recursive(int id, int curTime, HashMap<Integer, TreeNode> map, int[] informTime) {
        TreeNode tmp = map.get(id);
        if (tmp == null) {
            res = Math.max(res, curTime);
            return;
        }

        for (int n : tmp.getChildren()) {
            recursive(n, curTime + informTime[id], map, informTime);
        }
    }

    private HashMap<Integer, TreeNode> buildMap(int manager[]) {
        HashMap<Integer, TreeNode> map = new HashMap<>();

        for (int i = 0; i < manager.length; i++) {
            int m = manager[i];
            if (m == -1) {
                continue;
            }

            TreeNode tmp = map.get(m);
            if (tmp == null) {
                tmp = new TreeNode(m);
                map.put(m, tmp);
            }
            tmp.addChild(i);
        }

        return map;
    }

    class TreeNode {
        private int id;
        private List<Integer> children;

        TreeNode(int id) {
            this.id = id;
            this.children = new ArrayList<>();
        }

        public void addChild(int id) {
            this.children.add(id);
        }

        public List<Integer> getChildren() {
            return this.children;
        }
    }
}
