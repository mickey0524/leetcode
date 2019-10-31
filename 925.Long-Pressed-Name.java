// https://leetcode.com/problems/long-pressed-name/
//
// algorithms
// Easy (44.43%)
// Total Accepted: 23,196
// Total Submissions: 52,205


class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int nameLen = name.length(), typedLen = typed.length();
        if (typedLen < nameLen) {
            return false;
        }
        int nameIdx = 0, typedIdx = 0;

        while (nameIdx < nameLen && typedIdx < typedLen) {
            char nameCh = name.charAt(nameIdx);
            char typedCh = typed.charAt(typedIdx);

            if (nameCh != typedCh) {
                if (typedIdx == 0 || typed.charAt(typedIdx) != typed.charAt(typedIdx - 1)) {
                    return false;
                }

                while (typedIdx < typedLen && typed.charAt(typedIdx) == typed.charAt(typedIdx - 1)) {
                    typedIdx++;
                }

            } else {
                nameIdx++;
                typedIdx++;
            }
        }

        if (nameIdx < nameLen) {
            return false;
        }

        if (typedIdx < typedLen && typedIdx > 0) {
            while (typedIdx < typedLen && typed.charAt(typedIdx) == typed.charAt(typedIdx - 1)) {
                typedIdx++;
            }
        }

        return typedIdx == typedLen;
    }
}