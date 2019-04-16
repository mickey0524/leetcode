package leetcode

import "strconv"

// https://leetcode.com/problems/walking-robot-simulation/
//
// algorithms
// Easy (29.36%)
// Total Accepted:    6,281
// Total Submissions: 21,395

func robotSim(commands []int, obstacles [][]int) int {
	obstacleMap := make(map[string]bool)

	for _, obstacle := range obstacles {
		key := strconv.Itoa(obstacle[0]) + "," + strconv.Itoa(obstacle[1])
		obstacleMap[key] = true
	}

	direction := 0
	x, y := 0, 0
	res := 0

	for _, c := range commands {
		if c == -2 {
			direction = direction - 1
			if direction == -1 {
				direction = 3
			}
		} else if c == -1 {
			direction = (direction + 1) % 4
		} else {
			for i := 0; i < c; i++ {
				xTmp, yTmp := x, y
				switch direction {
				case 0:
					y++
				case 1:
					x++
				case 2:
					y--
				case 3:
					x--
				}
				key := strconv.Itoa(x) + "," + strconv.Itoa(y)
				if obstacleMap[key] {
					x, y = xTmp, yTmp
					break
				}
				res = max(res, x*x+y*y)
			}
		}
	}

	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
