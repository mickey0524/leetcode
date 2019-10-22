// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
//
// algorithms
// Medium (51.99%)
// Total Accepted: 4,721
// Total Submissions: 9,081


class Solution {
    public List<String> removeSubfolders(String[] folder) {
        HashSet<String> set = new HashSet<>();

        Arrays.sort(folder, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] arr1 = o1.split("/");
                String[] arr2 = o2.split("/");

                return arr1.length - arr2.length;
            }
        });

        int separator = -1;
        boolean needDelete = false;
        for (String f : folder) {
            separator = 1;
            needDelete = false;

            while ((separator = f.indexOf('/', separator)) != -1) {
                if (set.contains(f.substring(0, separator))) {
                    needDelete = true;
                    break;
                }
                separator++;
            }

            if (!needDelete) {
                set.add(f);
            }
        }

        return new ArrayList<>(set);
    }
}


// 这是我的做法，贼蠢，直接按下面这种做法就行。。。

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);  
        String unique = folder[0];
        List<String> result = new ArrayList<>();
        for (String f : folder) {
            if (!f.startsWith(unique + "/")) {
                result.add(f);
                unique = f;
            }
        }
        return result;
    }
}