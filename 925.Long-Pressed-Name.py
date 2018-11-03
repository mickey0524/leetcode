# https://leetcode.com/problems/long-pressed-name/description/
#
# algorithms
# Easy (44.53%)
# Total Accepted:    5.7k
# Total Submissions: 12.8k
# beats 100.0% of python submissions


class Solution(object):
    def isLongPressedName(self, name, typed):
        """
        :type name: str
        :type typed: str
        :rtype: bool
        """
        name_len, typed_len = len(name), len(typed)
        name_idx, typed_idx = 0, 0

        while name_idx < name_len:
            ch = name[name_idx]

            while typed_idx < typed_len:
                if typed[typed_idx] == ch:
                    typed_idx += 1
                    name_idx += 1
                    break
                else:
                    if typed_idx > 0 and typed[typed_idx] == typed[typed_idx - 1]:
                        typed_idx += 1
                    else:
                        return False

            if typed_idx >= typed_len:
                break

        return True if name_idx == name_len else False
