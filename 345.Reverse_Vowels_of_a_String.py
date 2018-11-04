# https://leetcode.com/problems/reverse-vowels-of-a-string/description/
#
# algorithms
# Easy (40.01%)
# Total Accepted:    128.8k
# Total Submissions: 321.5k
# beats 79.21% of python submissions


class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        hash_map = {}

        for ch in ['a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U']:
            hash_map[ch] = True

        head, tail = 0, len(s) - 1
        arr = list(s)

        while head < tail:
            while head < tail and arr[head] not in hash_map:
                head += 1
            while head < tail and arr[tail] not in hash_map:
                tail -= 1
            if head == tail:
                break
            arr[head], arr[tail] = arr[tail], arr[head]
            head += 1
            tail -= 1

        return ''.join(arr)
