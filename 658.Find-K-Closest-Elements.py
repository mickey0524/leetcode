# https://leetcode.com/problems/find-k-closest-elements/description/
#
# algorithms
# Medium (34.83%)
# Total Accepted:    28.7k
# Total Submissions: 82.4k
# beats 77.85% of python submissions


class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        def get_insert_idx(length):
            head, tail, middle = 0, length - 1, None

            while head < tail:
                middle = head + (tail - head) / 2
                if arr[middle] == x:
                    return middle
                elif arr[middle] < x:
                    head = middle + 1
                else:
                    tail = middle

            return tail

        length = len(arr)
        x_idx = get_insert_idx(length)

        if x_idx == 0:
            return arr[:k]

        elif x_idx == length - 1:
            return arr[-k:]

        else:
            if arr[x_idx] != x:
                x_idx = x_idx - \
                    1 if abs(arr[x_idx - 1] -
                             x) <= abs(arr[x_idx + 1] - x) else x_idx + 1
            left, right = x_idx - 1, x_idx + 1

            for i in xrange(k - 1):
                if left < 0:
                    right += (k - 1 - i)
                    break
                elif right == length:
                    left -= (k - 1 - i)
                    break
                else:
                    if abs(arr[left] - x) <= abs(arr[right] - x):
                        left -= 1
                    else:
                        right += 1

            return arr[left + 1:right]
