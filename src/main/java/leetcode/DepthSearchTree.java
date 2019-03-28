package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.LinkedList;

public class DepthSearchTree {
    public void depthSearchTree(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode now = stack.pop();
            System.out.println(now.val);
            if (now.right != null) {
                stack.push(now.right);
            }
            if (now.left != null) {
                stack.push(now.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        DepthSearchTree tree = new DepthSearchTree();
        tree.depthSearchTree(node);

    }
}
