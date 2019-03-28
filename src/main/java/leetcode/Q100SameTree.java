package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.LinkedList;

public class Q100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (q != null && p == null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        LinkedList<TreeNode> pQueue = new LinkedList<>();
        LinkedList<TreeNode> qQueue = new LinkedList<>();
        pQueue.offer(p);
        qQueue.offer(q);
        while (!pQueue.isEmpty() || !qQueue.isEmpty()) {
            p = pQueue.poll();
            q = qQueue.poll();
            if (p == null && q != null) {
                return false;
            }
            if (q == null && p != null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            } else {
                if (p.left != null || q.left != null) {
                    pQueue.offer(p.left);
                    qQueue.offer(q.left);
                }
                if (p.right != null || q.right != null) {
                    pQueue.offer(p.right);
                    qQueue.offer(q.right);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        TreeNode p = new TreeNode(1);
//        p.left = new TreeNode(2);
//        p.right = new TreeNode(3);
//        p.left.left = new TreeNode(4);
//        p.left.right = new TreeNode(5);
//        p.right.left = new TreeNode(6);
//        p.right.right = new TreeNode(7);

        TreeNode p = null;

        TreeNode q = new TreeNode(1);
//        q.left = new TreeNode(2);
//        q.right = new TreeNode(3);
//        q.left.left = new TreeNode(4);
//        q.left.right = new TreeNode(5);
//        q.right.left = new TreeNode(6);
//        q.right.right = new TreeNode(89);

//        TreeNode q = null;

        Q100SameTree t = new Q100SameTree();
        boolean sameTree = t.isSameTree(p, q);
        System.out.println(sameTree);
    }
}
