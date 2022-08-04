class Solution {
    public Node connect(Node root) {
        traverse(root);
        return root;
    }
    
    private void traverse(Node root) {
        if (root == null) {
            return;
        }
        
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        
        traverse(root.left);
        traverse(root.right);
    }
}

// previous attempt at solution
// class Solution {
//     public Node connect(Node root) {
//         backtrack(root, null, null);
//         return root;
//     }
    
//     private void backtrack(Node root, Node prev, Node prevRight) {
//         if (root == null) {
//             return;
//         }
        
//         if (prev == null) {
//             root.next = null;
//             prevRight = root;
//         }  else {
//             if (prev.right.val != root.val) {
//                 root.next = prev.right;
//             } else if (root.val < prevRight.left.val) {
//                 root.next = prevRight.left;
//             }
//             prevRight = prev.right;
//         }
        
//         backtrack(root.left, root, prevRight);
//         backtrack(root.right, root, prevRight);
//     }
// }

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

