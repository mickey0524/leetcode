// https://leetcode.com/problems/design-linked-list/
//
// algorithms
// Easy (20.84%)
// Total Accepted: 34,842
// Total Submissions: 167,186
// beats 100.0% of java submissions


class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {

    int size;
    ListNode head;
    ListNode tail;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is
     * invalid, return -1.
     */
    public int get(int index) {
        ListNode n = getNode(index);
        if (n == null) {
            return -1;
        }

        return n.val;
    }

    public ListNode getNode(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        if (index <= size / 2) {
            ListNode tmp = head;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp;
        }

        ListNode tmp = tail;
        for (int i = size - 1; i > index; i--) {
            tmp = tmp.prev;
        }

        return tmp;
    }

    /**
     * Add a node of value val before the first element of the linked list. After
     * the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode n = new ListNode(val);
        n.next = head;
        if (head != null) {
            head.prev = n;
        } else {
            tail = n;
        }
        head = n;
        size += 1;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode n = new ListNode(val);
        n.prev = tail;
        if (tail != null) {
            tail.next = n;
        } else {
            head = n;
        }
        tail = n;
        size += 1;
    }

    public void deleteAtHead() {
        if (size == 0) {
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size -= 1;
    }

    public void deleteAtTail() {
        if (size == 0) {
            return;
        }
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size -= 1;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index
     * equals to the length of linked list, the node will be appended to the end of
     * linked list. If index is greater than the length, the node will not be
     * inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        index = Math.max(index, 0);
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            ListNode n = getNode(index);
            ListNode newNode = new ListNode(val);
            newNode.prev = n.prev;
            n.prev.next = newNode;
            newNode.next = n;
            n.prev = newNode;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode n = getNode(index);
        if (n == null) {
            return;
        }
        if (index == 0) {
            deleteAtHead();
        } else if (index == size - 1) {
            deleteAtTail();
        } else {
            ListNode prev = n.prev, next = n.next;
            n = null;
            prev.next = next;
            next.prev = prev;
            size -= 1;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
 * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */