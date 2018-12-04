# algorithms
# Easy (30.52%)
# Total Accepted:    3,167
# Total Submissions: 10,376
# beats 100.0% of python submissions


class Solution(object):
    def largestTimeFromDigits(self, A):
        """
        :type A: List[int]
        :rtype: str
        """
        hash_map = {}
        for num in A:
            if num in hash_map:
                hash_map[num] = hash_map[num] + 1
            else:
                hash_map[num] = 1

        hour_high = [i for i in xrange(2, -1, -1)]
        hour_low = [i for i in xrange(3, -1, -1)]
        reverse_order = [i for i in xrange(9, -1, -1)]
        minute_high = [i for i in xrange(5, -1, -1)]

        res = [[], False]

        def resursive(cnt_idx, path):
            if res[1]:
                return
            if cnt_idx == 4:
                res[0] = path
                res[1] = True
                return

            arr = None
            if cnt_idx == 0:
                arr = hour_high
            elif cnt_idx == 1:
                arr = hour_low if path[0] == '2' else reverse_order
            elif cnt_idx == 2:
                arr = minute_high
            else:
                arr = reverse_order

            for i in arr:
                if hash_map.get(i, 0) > 0:
                    hash_map[i] = hash_map[i] - 1
                    resursive(cnt_idx + 1, path + [str(i)])
                    hash_map[i] = hash_map[i] + 1

        resursive(0, [])

        if len(res[0]) == 0:
            return ''

        res[0].insert(2, ':')

        return ''.join(res[0])
