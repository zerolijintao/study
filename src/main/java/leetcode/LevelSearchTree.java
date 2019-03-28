package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.LinkedList;

public class LevelSearchTree {
    public void levelSearchTree(TreeNode node) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode now = queue.poll();
            System.out.println(now.val);
            if (now.left != null) {
                queue.offer(now.left);
            }
            if (now.right != null) {
                queue.offer(now.right);
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
        LevelSearchTree tree = new LevelSearchTree();
        tree.levelSearchTree(node);

    }
}
