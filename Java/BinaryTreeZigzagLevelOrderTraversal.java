import java.util.*;
// first attempt creating tree in order then reversing specific levels afterwards
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        traverse(root, list, 0);
        return list;
    }
    
    private void traverse(TreeNode root, List<List<Integer>> list, int level) {
        if (root == null) {
            return;
        }
        
        if (level == list.size()) {
            list.add(new ArrayList<Integer>());
        }
        
        if (level % 2 != 0) {
            list.get(level).add(0, root.val);
        } else {
            list.get(level).add(root.val);
        }
        
        traverse(root.left, list, level + 1);
        traverse(root.right, list, level + 1);
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