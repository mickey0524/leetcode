// https://leetcode.com/problems/queens-that-can-attack-the-king/
//
// algorithms
// Medium (69.74%)
// Total Accepted: 4,457
// Total Submissions: 6,391
// beats 100.0% of java submissions


class Direction {
    int x;
    int y;

    public Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Direction)) {
            return false;
        }
        Direction tmp = (Direction) o;
        if (tmp.x == this.x && tmp.y == this.y) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return x ^ y;
    }
}

class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        HashMap<Direction, int[]> resMap = new HashMap<>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                Direction key = new Direction(i, j);
                resMap.put(key, null);
            }
        }

        for (int[] queen : queens) {
            if (!onOneLine(queen, king)) {
                continue;
            }
            int xDelta = queen[0] - king[0];
            int yDelta = queen[1] - king[1];
            int x = xDelta > 0 ? 1 : (xDelta < 0 ? -1 : 0);
            int y = yDelta > 0 ? 1 : (yDelta < 0 ? -1 : 0);
            Direction key = new Direction(x, y);

            int[] curQueue = resMap.get(key);
            if (curQueue == null) {
                resMap.put(key, queen);
                continue;
            }

            if (getDis(king, queen) < getDis(king, curQueue)) {
                resMap.put(key, queen);
            }
        }

        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int[] queen : resMap.values()) {
            if (queen == null) {
                continue;
            }
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(queen[0]);
            tmp.add(queen[1]);
            res.add(tmp);
        }

        return res;
    }

    public boolean onOneLine(int[] king, int[] queen) {
        if (king[0] == queen[0]) {
            return true;
        }
        if (king[1] == queen[1]) {
            return true;
        }
        if ((king[1] - queen[1] == king[0] - queen[0]) || (king[1] - queen[1] == queen[0] - king[0])) {
            return true;
        }

        return false;
    }

    public int getDis(int[] king, int[] queen) {
        return Math.abs(king[0] - queen[0]) + Math.abs(king[1] - queen[1]);
    }

}