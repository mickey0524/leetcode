// https://leetcode.com/problems/maximum-number-of-pairs-in-array/
// algorithms
// Easy (77.26%)
// Total Accepted: 16,330
// Total Submissions: 21,136

package leetcode



func numberOfPairs(nums []int) []int {
    numMap := make(map[int]int)
    
    pairNum := 0
    for _, n := range nums {
        v, ok := numMap[n]
        if ok && v > 0 {
            pairNum++
            numMap[n] = v - 1
        } else {
            numMap[n] = 1
        }
    }
    
    return []int{pairNum, len(nums) - pairNum * 2}
}