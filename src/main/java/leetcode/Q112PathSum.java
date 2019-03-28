package leetcode;

import javafx.util.Pair;
import leetcode.datastructure.TreeNode;

import java.util.LinkedList;

public class Q112PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.push(new Pair<>(root, root.val));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            Integer value = pair.getValue();
            TreeNode treeNode = pair.getKey();
            if (treeNode.right != null || treeNode.left != null ) {
                if (treeNode.right != null) {
                    stack.push(new Pair<>(treeNode.right, value + treeNode.right.val));
                }
                if (treeNode.left != null) {
                    stack.push(new Pair<>(treeNode.left, value + treeNode.left.val));
                }
            } else if (value == sum) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = new TreeNode(4);
        p.left.right = new TreeNode(5);
        p.right.left = new TreeNode(6);
        p.right.right = new TreeNode(7);


        Q112PathSum t = new Q112PathSum();
        boolean sameTree = t.hasPathSum(p, 3);
        System.out.println(sameTree);
    }
}
