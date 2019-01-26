// https://leetcode.com/problems/open-the-lock/
//
// algorithms
// Medium (43.66%)
// Total Accepted:    14,779
// Total Submissions: 33,852
// beats 100.0% of golang submissions

package leetcode

type lockState struct {
	lock  string
	level int
}

func openLock(deadends []string, target string) int {
	deadHashMap := make(map[string]bool)

	for _, dead := range deadends {
		deadHashMap[dead] = true
	}
	if deadHashMap["0000"] {
		return -1
	}
	deadHashMap["0000"] = true

	queue := []lockState{
		{
			lock:  "0000",
			level: 0,
		},
	}
	for len(queue) > 0 {
		cntLockState := queue[0]
		queue = queue[1:]
		for i := 0; i < 4; i++ {
			lockByteArr := []byte(cntLockState.lock)
			for _, delta := range []int{1, -1} {
				k := (int(cntLockState.lock[i]-'0') + delta) % 10
				if k == -1 {
					k = 9
				}
				lockByteArr[i] = byte(k + '0')
				nextLock := string(lockByteArr)
				if nextLock == target {
					return cntLockState.level + 1
				}
				if !deadHashMap[nextLock] {
					deadHashMap[nextLock] = true
					queue = append(queue, lockState{
						lock:  nextLock,
						level: cntLockState.level + 1,
					})
				}
			}
		}
	}

	return -1
}
