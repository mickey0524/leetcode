// https://leetcode.com/problems/word-ladder/description/
//
// algorithms
// Medium (21.64%)
// Total Accepted:    203.7K
// Total Submissions: 941K
// 我这种做法就是普通的BFS，简直是弟中弟的做法
package leetcode

func ladderLength(beginWord string, endWord string, wordList []string) int {
	queue := []string{beginWord, "#"}

	wordMap := make(map[string]bool)
	for _, word := range wordList {
		wordMap[word] = false
	}

	if _, ok := wordMap[endWord]; !ok {
		return 0
	}
	res := 0

	for {
		length := len(queue)
		if length == 0 {
			break
		}
		head := queue[0]
		if head == "#" {
			if length == 1 {
				break
			} else {
				res++
				queue = append(queue, "#")
			}
		} else {
			if head == endWord {
				return res + 1
			}
			for _, word := range wordList {
				if wordMap[word] {
					continue
				}
				if isLadder(head, word) {
					wordMap[word] = true
					queue = append(queue, word)
				}
			}
		}

		queue = queue[1:]
	}

	return 0
}

func isLadder(a, b string) bool {
	diff := 0

	for idx := range a {
		if a[idx] != b[idx] {
			diff++
		}
	}

	return diff == 1
}

// 下面是参考别人的做法，不用遍历整个wordList，应该逐个替换str的每一位(从a-z)，然后去map中查看
// 是否存在，这也复杂度大大降低

func ladderLength(beginWord string, endWord string, wordList []string) int {
	if beginWord == endWord {
		return 0
	}

	dict := make(map[string]bool, len(wordList))
	queue := make([]string, 0)
	for _, i := range wordList {
		dict[i] = true
	}
	if !dict[endWord] {
		return 0
	}

	queue = append(queue, beginWord)

	cnt := 1
	for len(queue) > 0 {
		queueLen := len(queue)
		for q := 0; q < queueLen; q++ {
			curt := queue[0]
			queue = queue[1:]
			bytes := []byte(curt)
			for i := 0; i < len(bytes); i++ {
				oldChar := bytes[i]
				for j := 0; j < 26; j++ {
					newChar := 'a' + byte(j)
					if newChar == oldChar {
						continue
					}
					bytes[i] = newChar
					if val, ok := dict[string(bytes)]; ok {
						if string(bytes) == endWord {
							return cnt + 1
						}
						if val == true {
							queue = append(queue, string(bytes))
							dict[string(bytes)] = false
						}
					}
				}
				bytes[i] = oldChar
			}
		}
		cnt++
	}

	return 0

}
