// https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
//
// algorithms
// Easy (33.4%)
// Total Accepted: 24,961
// Total Submissions: 73,423


class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : deck) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int base = -1, gcd = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value < 2) {
                return false;
            }

            if (base == -1) {
                base = value;
            } else if ((gcd = getGcd(base, value)) > 1) {
                base = gcd;
            } else {
                return false;
            }
        }

        return true;
    }

    private int getGcd(int x, int y) {
        int max, min;
        if (x > y) {
            max = x;
            min = y;
        } else {
            max = y;
            min = x;
        }

        if (max % min != 0) {
            return getGcd(min, max % min);
        }

        return min;
    }

}