package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.LinkedList;

public class Q101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        stack.offer(root);
        stack.poll();
        stack.pop();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val+"  ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
