// https://leetcode.com/problems/text-justification/
//
// algorithms
// Hard (22.02%)
// Total Accepted:    86,263
// Total Submissions: 391,701
// beats 100.0% of golang submission

package leetcode

import (
	"bytes"
	"strings"
)

func fullJustify(words []string, maxWidth int) []string {
	var cntWidth int
	var wordTmp []string
	var res []string

	for _, word := range words {
		wordLen := len(word)
		if len(wordTmp)+wordLen+cntWidth > maxWidth {
			space := maxWidth - cntWidth
			slot := len(wordTmp) - 1

			if slot > 0 {
				division := space / slot
				spaceArr := make([]int, slot)
				for i := 0; i < slot; i++ {
					spaceArr[i] = division
				}
				remainder := space % slot
				if remainder > 0 {
					for i := 0; i < slot && remainder != 0; i++ {
						spaceArr[i]++
						remainder--
					}
				}
				sb := bytes.NewBufferString("")
				for i := 0; i < slot; i++ {
					sb.WriteString(wordTmp[i])
					for j := 0; j < spaceArr[i]; j++ {
						sb.WriteString(" ")
					}
				}
				sb.WriteString(wordTmp[slot])
				res = append(res, sb.String())
			} else {
				sb := bytes.NewBufferString("")
				sb.WriteString(wordTmp[0])
				for j := 0; j < space; j++ {
					sb.WriteString(" ")
				}
				res = append(res, sb.String())
			}

			wordTmp = []string{word}
			cntWidth = wordLen
		} else {
			wordTmp = append(wordTmp, word)
			cntWidth += wordLen
		}
	}

	sb := strings.Join(wordTmp, " ")
	for i := len(sb); i < maxWidth; i++ {
		sb += " "
	}
	res = append(res, sb)

	return res
}
