// https://leetcode.com/problems/count-unhappy-friends/
// algorithms
// Medium (51.44%)
// Total Accepted: 7,018
// Total Submissions: 13,644


class Solution {

    private static final char SEPARATOR = '#';

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<String, Integer> preferenceMap = buildMap(preferences);
        Map<Integer, Integer> pairMap = new HashMap<>();
        for (int[] p : pairs) {
            pairMap.put(p[0], p[1]);
            pairMap.put(p[1], p[0]);
        }

        int res = 0;

        for (int[] p : pairs) {
            int x = p[0], y = p[1];
            if (preferences[x][0] != y) {
                int idx = preferenceMap.get(buildKey(x, y));
                for (int i = 0; i < idx; i++) {
                    int prefer = preferences[x][i];
                    int preferY = pairMap.get(prefer);
                    if (preferenceMap.get(buildKey(prefer, preferY)) > preferenceMap.get(buildKey(prefer, x))) {
                        res++;
                        break;
                    }
                }
            }

            if (preferences[y][0] != x) {
                int idx = preferenceMap.get(buildKey(y, x));
                for (int i = 0; i < idx; i++) {
                    int prefer = preferences[y][i];
                    int preferX = pairMap.get(prefer);
                    if (preferenceMap.get(buildKey(prefer, preferX)) > preferenceMap.get(buildKey(prefer, y))) {
                        res++;
                        break;
                    }
                }
            }
        }

        return res;
    }

    private Map<String, Integer> buildMap(int[][] p) {
        Map<String, Integer> map = new HashMap<>();

        int len = p.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1; j++) {
                String key = buildKey(i, p[i][j]);
                map.put(key, j);
            }
        }

        return map;
    }

    private String buildKey(int x, int y) {
        StringBuilder sb = new StringBuilder();

        sb.append(x);
        sb.append(SEPARATOR);
        sb.append(y);

        return sb.toString();
    }

}