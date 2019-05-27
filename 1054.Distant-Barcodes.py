# https://leetcode.com/problems/distant-barcodes/
# Medium (34.24%)
# Total Accepted:    2,331
# Total Submissions: 6,808


from heapq import heappush, heappop


class Solution(object):
    def rearrangeBarcodes(self, barcodes):
        """
        :type barcodes: List[int]
        :rtype: List[int]
        """
        length = len(barcodes)
        if length < 3:
            return barcodes

        hash_map = {}

        for n in barcodes:
            hash_map[n] = hash_map.get(n, 0) + 1

        h = []

        for k, v in hash_map.iteritems():
            heappush(h, (-v, k))

        i = 0
        while h:
            tmp = []
            j = 2
            while j > 0 and h:
                item = heappop(h)
                barcodes[i] = item[1]
                i += 1
                if item[0] + 1 != 0:
                    tmp += (item[0] + 1, item[1]),
                j -= 1
            if tmp:
                for item in tmp:
                    heappush(h, item)
            

        return barcodes