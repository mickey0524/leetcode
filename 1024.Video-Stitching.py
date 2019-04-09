# https://leetcode.com/problems/video-stitching/
# Medium (62.89%)
# Total Accepted:    3,342
# Total Submissions: 7,020
# beats 100.0% of python submissions


class Solution(object):
    def videoStitching(self, clips, T):
        """
        :type clips: List[List[int]]
        :type T: int
        :rtype: int
        """
        length = len(clips)

        clips.sort()
        # print clips
        if clips[0][0] > 0:
            return -1

        cur_end = 0
        i, res, pre_idx, last_idx = 0, 0, -2, -1
        while i < length:
            if clips[i][0] == cur_end:
                res += 1
                j = i + 1
                while j < length and clips[j][0] == clips[i][0]:
                    j += 1
                if last_idx != -1 and clips[last_idx][1] > clips[j - 1][1]:
                    j = last_idx + 1
                cur_end = clips[j - 1][1]
                pre_idx = j - 1
                i = j
            elif clips[i][0] > cur_end:
                if i - 1 == pre_idx:
                    return -1
                else:
                    cur_end = clips[last_idx][1]
                    pre_idx = last_idx
                    last_idx = -1
                    res += 1
            else:
                if last_idx == -1:
                    last_idx = i
                elif clips[i][1] > clips[last_idx][1]:
                    last_idx = i
                i += 1
            if cur_end >= T:
                return res

        return -1 if clips[-1][1] < T else res + 1
