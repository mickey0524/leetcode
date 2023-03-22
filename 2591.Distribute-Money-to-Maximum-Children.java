// https://leetcode.com/problems/distribute-money-to-maximum-children/
// algorithms
// Easy (17.9%)
// Total Accepted: 13.3K
// Total Submissions: 74.3K

class Solution {
    
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }

        if (money < children + 7) {
            return 0;
        }

        money -= children;
        int a = money / 7;
        int b = money % 7;
        
        if (a > children) {
            b += (a - children) * 7;
            a = children;
        }

        if (a == children && b > 0) {
            a -= 1;
        } else if (b == 3 && a == children - 1) {
            a -= 1;
        }

        return Math.max(0, a);
    }

}


// 23 2
// 1 1 21

a = 3
b = 0