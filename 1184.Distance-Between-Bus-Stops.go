// https://leetcode.com/problems/distance-between-bus-stops/
//
// algorithms
// Easy (56.89%)
// Total Accepted:    3,759
// Total Submissions: 6,608
// beats 100.0% of golang submissions

package leetcode

func distanceBetweenBusStops(distance []int, start int, destination int) int {
	if start == destination {
		return 0
	}

	length := len(distance)
	clockwise, counterclockwise := 0, 0

	for i := start; i != destination; i = (i + 1) % length {
		clockwise += distance[i]
	}

	for i := destination; i != start; i = (i + 1) % length {
		counterclockwise += distance[i]
	}

	return min(clockwise, counterclockwise)
}

func min(a, b int) int {
	if a < b {
		return a
	}

	return b
}
