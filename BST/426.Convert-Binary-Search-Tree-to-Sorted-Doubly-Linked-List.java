/*
Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {    
    Node previous = null;
    
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        Node dummy = new Node(0, null, null);
        previous = dummy;
        treeToDoublyListH(root);
        previous.right = dummy.right;
        dummy.right.left = previous;
        return dummy.right;
    }
    private void treeToDoublyListH(Node root) {
        if(root == null)
            return;
        treeToDoublyListH(root.left);
        previous.right = root;
        root.left = previous;
        previous = root;
        treeToDoublyListH(root.right);
    }
}