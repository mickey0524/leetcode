# https://leetcode.com/problems/accounts-merge/
#
# algorithms
# Medium (39.62%)
# Total Accepted:    29,950
# Total Submissions: 75,585
# beats 100.0% of python submissions


class Solution(object):
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        hash_map = {}

        for arr in accounts:
            person = arr[0]
            mails = set(arr[1:])
            if person in hash_map:
                is_found = False
                idxs = []
                for idx, s in enumerate(hash_map[person]):
                    if len(s & mails) > 0:
                        mails = s | mails
                        is_found = True
                        idxs += idx,
                if is_found:
                    hash_map[person][idxs[0]] = mails
                    diff = 0
                    for idx in idxs[1:]:
                        hash_map[person].pop(idx - diff)
                        diff += 1
                else:
                    hash_map[person].append(mails)
            else:
                hash_map[person] = [mails]

        res = []
        for k, v in hash_map.iteritems():
            for s in v:
                res.append([k] + sorted(list(s)))

        return res
