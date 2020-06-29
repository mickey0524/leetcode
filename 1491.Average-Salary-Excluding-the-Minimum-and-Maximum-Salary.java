// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
// algorithms
// Easy (72.8%)
// Total Accepted: 7,051
// Total Submissions: 9,686
// beats 100.0% of java submissions


class Solution {
    public double average(int[] salary) {
        int sum = 0;
        int maxSalary = Integer.MIN_VALUE;
        int minSalary = Integer.MAX_VALUE;
        int len = salary.length;

        for (int n : salary) {
            sum += n;
            maxSalary = Math.max(maxSalary, n);
            minSalary = Math.min(minSalary, n);
        }

        return (double) (sum - maxSalary - minSalary) / (len - 2);
    }
}