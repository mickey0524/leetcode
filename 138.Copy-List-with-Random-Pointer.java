// https://leetcode.com/problems/copy-list-with-random-pointer/
//
// algorithms
// Medium (26.56%)
// Total Accepted:    237,259
// Total Submissions: 893,310
// beats 83.35% of java submissions

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        HashMap<Node, Node> map = new HashMap<>();
        Node node = head;
        while (node != null) {
            Node tmp = new Node();
            tmp.val = node.val;
            map.put(node, tmp);
            node = node.next;
        }
        
        node = head;
        while (node != null) {
            Node nodeTmp = map.get(node);
            Node nextTmp = map.get(node.next);
            Node randomTmp = map.get(node.random);
            nodeTmp.next = nextTmp;
            nodeTmp.random = randomTmp;
            node = node.next;
        }
        
        return map.get(head);
    }
}