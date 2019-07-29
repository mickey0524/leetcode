# https://leetcode.com/problems/alphabet-board-path/
# Medium (41.23%)
# Total Accepted:    3,571
# Total Submissions: 8,661


class Solution(object):
    def alphabetBoardPath(self, target):
        """
        :type target: str
        :rtype: str
        """
        alpa = [None] * 26
        row, col = 0, 0
        for i in xrange(26):
            alpa[i] = (row, col)
            col += 1
            if col == 5:
                col = 0
                row += 1
        
        res = []
        x, y = 0, 0
        go_z = False
        
        for idx, ch in enumerate(target):
            if idx > 0 and ch == target[idx - 1]:
                res.append('!')
                continue
                
            if ch == 'z':
                go_z = True
                ch = 'u'
            
            idx = ord(ch) - 97
            target_x, target_y = alpa[idx]
            x_diff = target_x - x
            y_diff = target_y - y
            
            if x_diff > 0:
                res += ['D'] * x_diff
            elif x_diff < 0:
                res += ['U'] * (-x_diff)
            
            if y_diff > 0:
                res += ['R'] * y_diff
            elif y_diff < 0:
                res += ['L'] * (-y_diff)
            
            if go_z:
                res.append('D')
                target_x += 1
                
            res.append('!')
            x, y = target_x, target_y
            go_z = False    
            
        return ''.join(res)
        