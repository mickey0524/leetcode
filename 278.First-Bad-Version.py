# https://leetcode.com/problems/first-bad-version/
#
# algorithms
# Easy (28.14%)
# Total Accepted:    189,920
# Total Submissions: 674,806

# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool

def isBadVersion(version):
    return True

class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        head, tail, middle = 1, n, None
        hash_map = {}
        if n == 1 or isBadVersion(1):
            return 1
        
        while head <= tail:
            middle = head + (tail - head) / 2
            
            isMiddleBad = isBadVersion(middle)
            if isMiddleBad:
                if middle - 1 in hash_map and not hash_map[middle - 1]:
                    return middle
                tail = middle
                hash_map[middle] = True
            elif middle + 1 in hash_map and hash_map[middle + 1]:
                return middle + 1
            else:
                head = middle + 1
                hash_map[middle] = False
        
        return 1
        

class Solution1(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        l, r, m = 1, n, -1

        while l <= r:
            m = l + (r - l) / 2
            if isBadVersion(m):
                r = m - 1

            else:
                l = m + 1

        return l
