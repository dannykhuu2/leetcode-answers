import java.util.*;
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        TreeNode root = helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMap);
        return root;
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int preIndex, int preEnd, int inIndex, int inEnd, Map<Integer, Integer> inorderMap) {
        if (preIndex > preEnd || inIndex > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preIndex]);
        int inRoot = inorderMap.get(root.val);
        int leftTreeLen = inRoot - inIndex;
        
        root.left = helper(preorder, inorder, preIndex + 1, preIndex + leftTreeLen, inIndex, inRoot - 1, inorderMap);
        root.right = helper(preorder, inorder, preIndex + leftTreeLen + 1, preEnd, inRoot + 1, inEnd, inorderMap);
        
        return root;
    }

    // Definition for a binary tree node.
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}