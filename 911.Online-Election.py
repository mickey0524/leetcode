# https://leetcode.com/problems/online-election/description/
#
# algorithms
# Medium (43.48%)
# Total Accepted:    5k
# Total Submissions: 11.5k


from bisect import bisect_left
from collections import defaultdict


class TopVotedCandidate(object):

    def __init__(self, persons, times):
        """
        :type persons: List[int]
        :type times: List[int]
        """
        hash_map = {}
        vote = defaultdict(int)
        cnt_max = float('-inf')
        cnt_person = -1

        for idx, t in enumerate(times):
            vote[persons[idx]] += 1
            if vote[persons[idx]] >= cnt_max:
                cnt_person = persons[idx]
                cnt_max = vote[persons[idx]]
            hash_map[t] = cnt_person

        self.hash_map = hash_map
        self.times = times

    def q(self, t):
        """
        :type t: int
        :rtype: int
        """
        if t in self.hash_map:
            return self.hash_map[t]

        left_idx = bisect_left(self.times, t) - 1

        return self.hash_map[self.times[left_idx]]


# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)
