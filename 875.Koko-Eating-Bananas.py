# https://leetcode.com/problems/koko-eating-bananas/
#
# algorithms
# Medium (42.92%)
# Total Accepted:    7,634
# Total Submissions: 17,786
# 我的思路是 binary search，由于要找最小的满足要求的数值，因此需要找 k 不满足，k + 1 满足的情况
# 因此我用 hash_map 保存满足条件的结果

class Solution(object):
    def minEatingSpeed(self, piles, H):
        """
        :type piles: List[int]
        :type H: int
        :rtype: int
        """
        length = len(piles)

        if length == 1:
            return piles[0] / H if piles[0] % H == 0 else piles[0] / H + 1

        piles.sort()

        if length == H:
            return piles[-1]

        head, tail, middle = 0, piles[-1] + 1, None

        hash_map = {}

        while head <= tail:
            middle = head + (tail - head) / 2
            need_h = 0

            for p in piles:
                if p <= middle:
                    need_h += 1
                else:
                    div, mod = p / middle, p % middle
                    need_h += div if mod == 0 else (div + 1)

            if need_h == H:
                hash_map[middle] = True
                tail = middle if tail > middle else middle - 1
            elif need_h > H:
                if (middle + 1) in hash_map:
                    return middle + 1
                head = middle if middle > head else middle + 1
            else:
                tail = middle if tail > middle else middle - 1

        return middle

# 这是 ac 后，看别人的做法，觉得非常 nice，其实我也考虑到数学公式，但是我没有往下想
# 第一行得到的 k 是肯定会小的，然后循环 k++ 去尝试就行了

class Solution(object):
    def minEatingSpeed(self, piles, H):
        k = max(1.0, float(sum(piles)/H))

        while True:
            steps = sum([math.ceil(pile/k) for pile in piles])
            if steps <= H:
                return int(k)
            k += 1
