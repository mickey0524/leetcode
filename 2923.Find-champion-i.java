// https://leetcode.com/problems/find-champion-i/description/
// algorithms
// Easy (71.64%)
// Total Accepted: 24K
// Total Submissions: 33.5K

class Solution {

    public int findChampion(int[][] grid) {
        Set<Integer> loserSet = new HashSet<>();
        Set<Integer> winnerSet = new HashSet<>();
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (!loserSet.contains(j)) {
                        winnerSet.add(j);
                    }
                    winnerSet.remove(i);
                    loserSet.add(i);
                } else {
                    if (!loserSet.contains(i)) {
                        winnerSet.add(i);
                    }
                    winnerSet.remove(j);
                    loserSet.add(j);
                }
            }
        }

        List<Integer> res = new ArrayList<>(winnerSet);
        return res.get(0);
    }

}