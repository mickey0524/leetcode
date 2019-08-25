# https://leetcode.com/problems/invalid-transactions/
# Easy (22.83%)
# Total Accepted:    2,216
# Total Submissions: 9,708
# beats 100.0% of python submissions


class Solution(object):
    def invalidTransactions(self, transactions):
        """
        :type transactions: List[str]
        :rtype: List[str]
        """
        length = len(transactions)
        if length == 0:
            return []

        tmp = []
        s = set()

        for idx, t in enumerate(transactions):
            name, time, amount, city = t.split(',')
            time, amount = int(time), int(amount)
            if amount > 1000:
                s.add(idx)

            tmp.append((name, time, city, idx))

        tmp.sort()
        cur_name = tmp[0][0]
        pre_idx = 0

        for i in xrange(1, length):
            if tmp[i][0] != cur_name:
                cur_name = tmp[i][0]
                pre_idx = i
                continue

            while pre_idx < i and tmp[pre_idx][1] + 60 < tmp[i][1]:
                pre_idx += 1

            for j in xrange(pre_idx, i):
                if tmp[j][2] != tmp[i][2]:
                    s |= {tmp[j][3], tmp[i][3]}

        return [transactions[i] for i in s]
