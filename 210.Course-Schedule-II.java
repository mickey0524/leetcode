// https://leetcode.com/problems/course-schedule/
//
// algorithms
// Medium (34.53%)
// Total Accepted:    143,237
// Total Submissions: 414,869

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            int source = prerequisites[i][1], target = prerequisites[i][0];
            if (map.containsKey(source)) {
                map.get(source).add(target);
            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(target);
                map.put(source, l);
            }
            indegree[target]++;
        }
        
        for (int i = 0; i < numCourses; i++) {
            int zeroInEdgeIdx = -1;
            for (int j = 0; j < numCourses; j++) {
                if (indegree[j] == 0) {
                    zeroInEdgeIdx = j;
                    break;
                }
            }
            if (zeroInEdgeIdx == -1) {
                return new int[]{};
            }
            res[i] = zeroInEdgeIdx;
            indegree[zeroInEdgeIdx] = -1;
            if (map.containsKey(zeroInEdgeIdx)) {
                for (int v : map.get(zeroInEdgeIdx)) {
                    indegree[v]--;
                }
            }
        }
        
        return res;
    }
}