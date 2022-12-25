// https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/description/
// algorithms
// Easy (43.86%)
// Total Accepted: 7.5K
// Total Submissions: 17.1K


class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        int len = words.length;
        Map<String, List<Integer>> idxListMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            List<Integer> idxList = idxListMap.get(words[i]);
            if (idxList == null) {
                idxList = new ArrayList<>();
            }

            idxList.add(i);
            idxListMap.put(words[i], idxList);
        }

        List<Integer> idxList = idxListMap.get(target);
        if (idxList == null) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (int idx : idxList) {
            int tmp;
            if (idx == startIndex) {
                return 0;
            } else if (idx > startIndex) {
                tmp = Math.min(idx - startIndex, startIndex + len - idx);
            } else {
                tmp = Math.min(startIndex - idx, len - startIndex + idx);
            }

            res = Math.min(res, tmp);
        }

        return res;
    }
}