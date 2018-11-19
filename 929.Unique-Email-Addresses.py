# https://leetcode.com/problems/unique-email-addresses/description/
#
# algorithms
# Easy (80.4%)
# Total Accepted:    20.1k
# Total Submissions: 25.3k
# beats 98.82% of python submissions


class Solution(object):
    def numUniqueEmails(self, emails):
        """
        :type emails: List[str]
        :rtype: int
        """
        s = set()

        for email in emails:
            local, domain = email.split('@')
            plus_idx = local.find('+')
            if plus_idx != -1:
                local = local[:plus_idx]
            local = local.replace('.', '')

            s.add((local, domain))

        return len(s)
