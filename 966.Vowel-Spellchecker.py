# https://leetcode.com/problems/vowel-spellchecker/
# Medium (39.81%)
# Total Accepted:    3,889
# Total Submissions: 9,768
# beats 100.0% of python submissions


class Solution(object):

    def replace_vowel(self, s):
        vowels = 'aeiou'
        res = ''

        for ch in s:
            if ch in vowels:
                res += '#'
            else:
                res += ch

        return res

    def spellchecker(self, wordlist, queries):
        """
        :type wordlist: List[str]
        :type queries: List[str]
        :rtype: List[str]
        """
        hash_map_1 = {}
        hash_map_2 = {}

        for w in wordlist:
            hash_map_1[w] = True
            lower_w = w.lower()
            if lower_w not in hash_map_2:
                hash_map_2[lower_w] = w
            vowel_w = self.replace_vowel(lower_w)
            if vowel_w not in hash_map_2:
                hash_map_2[vowel_w] = w

        res = []

        for q in queries:
            if q in hash_map_1:
                res += q,
                continue

            lower_q = q.lower()
            if lower_q in hash_map_2:
                res += hash_map_2[lower_q],
                continue

            vowel_q = self.replace_vowel(lower_q)
            if vowel_q in hash_map_2:
                res += hash_map_2[vowel_q],
                continue

            res += '',

        return res
