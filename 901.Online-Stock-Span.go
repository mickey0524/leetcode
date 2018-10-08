// https://leetcode.com/problems/online-stock-span/description/
//
// algorithms
// Medium (41.75%)
// Total Accepted:    4.3k
// Total Submissions: 10.3k
// beats 44.12% of golang submissions

package leetcode

type SpanDaily struct {
	price int
	span  int
}

type StockSpanner struct {
	CntLen  int
	SpanArr []SpanDaily
}

func Constructor() StockSpanner {
	return StockSpanner{}
}

func (this *StockSpanner) Next(price int) int {
	cntIdx, span := this.CntLen-1, 1
	this.CntLen++
	for {
		if cntIdx < 0 || this.SpanArr[cntIdx].price > price {
			break
		}
		span = span + this.SpanArr[cntIdx].span
		cntIdx = cntIdx - this.SpanArr[cntIdx].span
	}
	this.SpanArr = append(this.SpanArr, SpanDaily{
		price: price,
		span:  span,
	})

	return span
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Next(price);
 */
