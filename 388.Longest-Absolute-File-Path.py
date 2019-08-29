# https://leetcode.com/problems/longest-absolute-file-path/
#
# algorithms
# Medium (39.59%)
# Total Accepted:    68,866
# Total Submissions: 173,936


class Solution(object):
    def lengthLongestPath(self, input):
        """
        :type input: str
        :rtype: int
        """
        file_arr = input.split('\n')
        length = len(file_arr)
        if length == 0:
            return 0

        prefix_arr = []
        res = 0

        for i in xrange(length):
            if file_arr[i][0] == '\t':
                file_len = len(file_arr[i])
                idx = 1
                while idx < file_len and file_arr[i][idx] == '\t':
                    idx += 1

                tab_num = idx
                name = file_arr[i][idx:]
                point_idx = name.find('.')

                if point_idx != -1:
                    res = max(
                        res, len('/'.join(prefix_arr[:tab_num])) + 1 + len(name))
                else:
                    if len(prefix_arr) == tab_num:
                        prefix_arr.append(name)
                    else:
                        prefix_arr[tab_num] = name

            elif file_arr[i].find('.') != -1:
                res = max(res, len(file_arr[i]))

            else:
                # 新的根目录
                prefix_arr = [file_arr[i]]

        return res
