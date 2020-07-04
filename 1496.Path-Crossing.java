// https://leetcode.com/problems/path-crossing/
// algorithms
// Easy (55.32%)
// Total Accepted: 7,322
// Total Submissions: 13,235
// beats 100.0% of java submissions


class Solution {

    private static final char SEPARATOR = '_';

    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> isVisited = new HashSet<>();
        isVisited.add("0_0");
        StringBuilder sb = new StringBuilder();

        for (char ch : path.toCharArray()) {
            if (ch == 'N') {
                y++;
            } else if (ch == 'S') {
                y--;
            } else if (ch == 'E') {
                x++;
            } else {
                x--;
            }
            sb.setLength(0);
            sb.append(x).append(SEPARATOR).append(y);
            String pointKey = sb.toString();
            if (isVisited.contains(pointKey)) {
                return true;
            }

            isVisited.add(pointKey);
        }

        return false;
    }

}