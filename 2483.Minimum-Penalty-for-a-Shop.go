// https://leetcode.com/problems/minimum-penalty-for-a-shop/description/
// algorithms
// Medium (54.9%)
// Total Accepted: 10.6K
// Total Submissions: 19.3K

func bestClosingTime(customers string) int {
    customerNum := len(customers)

    l2r := make([]int, customerNum + 1, customerNum + 1)
    r2l := make([]int, customerNum + 1, customerNum + 1)

    var yNum, nNum int
    for i := 0; i < customerNum; i++ {
        l2r[i] = nNum
        if customers[i] == 'Y' {
            l2r[i] += 1
        } else {
            nNum++
        }
    }
    l2r[customerNum] = nNum
    
    for i := customerNum - 1; i >= 0; i-- {
        r2l[i] = yNum
        if customers[i] == 'Y' {
            yNum++
        }
    }
    
    curpenalty := l2r[0] + r2l[0]
    res := 0

    for i := 1; i <= customerNum; i++ {
        tmp := l2r[i] + r2l[i]
        if tmp < curpenalty {
            curpenalty = tmp
            res = i
        }
    }

    return res
}