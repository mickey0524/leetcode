// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//
// algorithms
// Easy (51.83%)
// Total Accepted:    321,838
// Total Submissions: 620,902
// beats 100.0% of golang submissions

package leetcode

func maxProfit(prices []int) int {
	length := len(prices)
	if length < 2 {
		return 0
	}

	var res int

	for i := 1; i < length; i++ {
		if prices[i] > prices[i-1] {
			res += prices[i] - prices[i-1]
		}
	}

	return res
}
