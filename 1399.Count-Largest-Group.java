// https://leetcode.com/problems/count-largest-group/
// algorithms
// Easy (60.04%)
// Total Accepted: 4,625
// Total Submissions: 7,703
// beats 100.0% of java submissions


class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int bitSum = countBitSum(i);
            map.put(bitSum, map.getOrDefault(bitSum, 0) + 1);
        }

        ArrayList<Integer> l = new ArrayList<>(map.values());
        Collections.sort(l, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 1; i < l.size(); i++) {
            if (!l.get(i).equals(l.get(i - 1))) {
                return i;
            }
        }

        return l.size();
    }

    private int countBitSum(int n) {
        int res = 0;

        while (n != 0) {
            res += (n % 10);
            n /= 10;
        }

        return res;
    }
}