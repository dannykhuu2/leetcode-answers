import java.util.*;
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        traverse(root, list, 0);
        return list;
    }
    
    private void traverse(TreeNode root,  List<List<Integer>> list, int level) {
        if (root == null) {
            return;
        }
        
        if (level == list.size()) {
            list.add(new ArrayList<Integer>());
        }
        
        list.get(level).add(root.val);
        traverse(root.left, list, level + 1);
        traverse(root.right, list, level+ 1);
    }

    //Definition for a binary tree node.
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