// https://leetcode.com/problems/course-schedule/
//
// algorithms
// Medium (37.44%)
// Total Accepted:    206,293
// Total Submissions: 550,957


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> inMap = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> outMap = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (!inMap.containsKey(prerequisites[i][j])) {
                    inMap.put(prerequisites[i][j], new HashSet<Integer>());
                }
                if (!outMap.containsKey(prerequisites[i][j])) {
                    outMap.put(prerequisites[i][j], new HashSet<Integer>());
                }
            }
            outMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
            inMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        while (true) {
            boolean hasNoIndegreePoint = false;
            for (Map.Entry entry : inMap.entrySet()) {
                HashSet<Integer> l = (HashSet<Integer>) entry.getValue();
                Integer key = (Integer) entry.getKey();
                if (l.size() == 0) {
                    hasNoIndegreePoint = true;
                    inMap.remove(key);
                    for (Integer p : outMap.get(key)) {
                        inMap.get(p).remove(key);
                    }
                    outMap.remove(key);
                    break;
                }
            }
            if (!hasNoIndegreePoint) {
                break;
            }
        }
        
        return inMap.size() == 0;
    }
}