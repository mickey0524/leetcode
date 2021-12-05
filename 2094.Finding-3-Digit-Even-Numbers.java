// https://leetcode.com/problems/finding-3-digit-even-numbers/
// algorithms
// Easy (48.74%)
// Total Accepted: 5.8K
// Total Submissions: 11.9K


class Solution {

    private Set<Integer> set;

    public int[] findEvenNumbers(int[] digits) {
        List<Integer> digitList = trim(digits);
        if (digitList.isEmpty()) {
            return new int[]{};
        }

        Collections.sort(digitList);
        set = new HashSet<>();

        recursive(digitList, new boolean[digitList.size()], new StringBuilder());

        int[] res = new int[set.size()];
        int idx = 0;
        for (int n : set) {
            res[idx++] = n;
        }

        Arrays.sort(res);

        return res;
    }

    private void recursive(List<Integer> digitList, boolean[] visited, StringBuilder sb) {
        int len = digitList.size();

        if (sb.length() == 3) {
            set.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (sb.length() == 0 && digitList.get(i) == 0) {
                continue;
            }

            if (sb.length() == 2 && (digitList.get(i) & 1) == 1) {
                continue;
            }

            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            sb.append(digitList.get(i));
            recursive(digitList, visited, sb);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

    private List<Integer> trim(int[] digits) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean hasEven = false;
        List<Integer> list = new ArrayList<>();
        for (int n : digits) {
            if ((n & 1) == 0) {
                hasEven = true;
            }

            int curNum = map.getOrDefault(n, 0);
            if (curNum < 3) {
                list.add(n);
                map.put(n, curNum + 1);
            }
        }

        if (!hasEven) {
            return Collections.emptyList();
        }
        
        return list;
    }
}