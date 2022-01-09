// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
// algorithms
// Easy (84.29%)
// Total Accepted: 8,372
// Total Submissions: 9,932

// solution 1

class Solution {
    
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head.next;
        ListNode pre = null;
        while (fast.next != null) {
            fast = fast.next.next;
            ListNode tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
        }        
        
        fast = slow.next;
        slow.next = pre;
        int res = fast.val + slow.val;
        while (fast != null) {
            res = Math.max(res, fast.val + slow.val);
            fast = fast.next;
            slow = slow.next;
        }
        
        return res;
    }
    
}


// solution 2

class Solution {
    
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        int i = 0, j = list.size() - 1;
        int res = list.get(i) + list.get(j);
        while (++i < --j) {
            int tmp = list.get(i) + list.get(j);
            res = Math.max(res, tmp);
        }
        
        return res;
    }
    
}