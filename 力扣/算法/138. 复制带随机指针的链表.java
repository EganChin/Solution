//2020-03-18 22:20:52
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    Map<Node, Node> nodeMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node oldNode = head;
        Node newNode = new Node(head.val);
        nodeMap.put(head, newNode);
        while (oldNode != null){
            newNode.random = getNewNode(oldNode.random);
            newNode.next = getNewNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return nodeMap.get(head);
    }

    private Node getNewNode(Node oldNode) {
        if(oldNode != null && !nodeMap.containsKey(oldNode)){
            nodeMap.put(oldNode, new Node(oldNode.val));
        }
        return nodeMap.get(oldNode);
    }
}
//2020-03-18 22:36:20
