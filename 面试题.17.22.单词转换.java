// https://leetcode-cn.com/problems/word-transformer-lcci/
// algorithms
// Medium (32.36%)
// Total Accepted: 2,085
// Total Submissions: 6,444


class Solution {

    private static List<String> res = null;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return Collections.emptyList();
        }

        res = null;
        List<String> path = new ArrayList<>();
        Set<String> visitSet = new HashSet<>();
        visitSet.add(beginWord);

        recursive(beginWord, endWord, wordSet, path, visitSet);
        if (res != null) {
            res.add(0, beginWord);
        } else {
            res = Collections.emptyList();
        }

        return res;
    }

    private void recursive(String curWord, String endWord, Set<String> wordSet, List<String> path,
            Set<String> visitSet) {
        if (res != null) {
            return;
        }

        if (curWord.equals(endWord)) {
            res = new LinkedList<>(path);
            return;
        }

        int len = curWord.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 26; j++) {
                sb.setLength(0);
                sb.append(curWord.substring(0, i)).append((char) (j + 'a')).append(curWord.substring(i + 1));
                String tmp = sb.toString();

                if (visitSet.contains(tmp)) {
                    continue;
                }

                if (!wordSet.contains(tmp)) {
                    continue;
                }

                visitSet.add(tmp);
                path.add(tmp);
                recursive(tmp, endWord, wordSet, path, visitSet);
                path.remove(path.size() - 1);

                if (res != null) {
                    return;
                }
            }
        }

    }

}