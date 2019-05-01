// https://leetcode.com/problems/word-search-ii/
//
// algorithms
// Hard (28.27%)
// Total Accepted:    108,169
// Total Submissions: 382,655
// beats 81.01% of golang submissions

package leetcode

type TrieNode struct {
	word     string
	children []*TrieNode
}

var res []string
var isVisited [][]bool

func findWords(board [][]byte, words []string) []string {
	trieTree := buildTrieTree(words)

	res = []string{}
	row, col := len(board), len(board[0])
	isVisited = make([][]bool, row)
	for i := 0; i < row; i++ {
		isVisited[i] = make([]bool, col)
	}

	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			isVisited[i][j] = true
			recursive(board, i, j, trieTree)
			isVisited[i][j] = false
		}
	}

	return res
}

func recursive(board [][]byte, i, j int, node *TrieNode) {
	row, col := len(board), len(board[0])
	idx := (int)(board[i][j] - 'a')

	if node.children[idx] == nil {
		return
	}

	node = node.children[idx]
	if node.word != "" {
		res = append(res, node.word)
		node.word = ""
	}

	if i > 0 && !isVisited[i-1][j] {
		isVisited[i-1][j] = true
		recursive(board, i-1, j, node)
		isVisited[i-1][j] = false
	}

	if i < row-1 && !isVisited[i+1][j] {
		isVisited[i+1][j] = true
		recursive(board, i+1, j, node)
		isVisited[i+1][j] = false
	}

	if j > 0 && !isVisited[i][j-1] {
		isVisited[i][j-1] = true
		recursive(board, i, j-1, node)
		isVisited[i][j-1] = false
	}

	if j < col-1 && !isVisited[i][j+1] {
		isVisited[i][j+1] = true
		recursive(board, i, j+1, node)
		isVisited[i][j+1] = false
	}

}

func buildTrieTree(words []string) *TrieNode {
	root := &TrieNode{
		children: make([]*TrieNode, 26),
	}

	for _, w := range words {
		tmp := root
		for _, ch := range w {
			idx := (int)(ch - 'a')
			if tmp.children[idx] == nil {
				tmp.children[idx] = &TrieNode{
					children: make([]*TrieNode, 26),
				}
			}
			tmp = tmp.children[idx]
		}
		tmp.word = w
	}

	return root
}
