// https://leetcode.com/problems/split-linked-list-in-parts/
//
// algorithms
// Medium (49.87%)
// Total Accepted: 33,210
// Total Submissions: 66,591
// beats 100.0% of java submissions


/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode tmp = root;
        int nodeNum = 0;

        while (tmp != null) {
            nodeNum++;
            tmp = tmp.next;
        }

        int[] segmentNum = new int[k];
        Arrays.fill(segmentNum, nodeNum / k);
        for (int i = 0; i < nodeNum % k; i++) {
            segmentNum[i]++;
        }

        tmp = root;
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k; i++) {
            if (segmentNum[i] == 0) {
                break;
            }
            res[i] = tmp;
            for (int j = 0; j < segmentNum[i] - 1; j++) {
                tmp = tmp.next;
            }
            ListNode next = tmp.next;
            tmp.next = null;
            tmp = next;
        }

        return res;
    }
}