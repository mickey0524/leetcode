# https://leetcode.com/problems/word-pattern/
#
# algorithms
# Easy (35.62%)
# Total Accepted:    155,351
# Total Submissions: 436,191


class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        arr = str.split(' ')
        if len(arr) != len(pattern):
            return False

        ch_2_word, word_2_ch = {}, {}

        for idx, ch in enumerate(pattern):
            if ch not in ch_2_word:
                ch_2_word[ch] = arr[idx]

            elif ch_2_word[ch] != arr[idx]:
                return False

            if arr[idx] not in word_2_ch:
                word_2_ch[arr[idx]] = ch

            elif word_2_ch[arr[idx]] != ch:
                return False

        return True
