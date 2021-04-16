package question.leetcode.easy.range1to100;

import question.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// Same Tree
//  - https://leetcode.com/problems/same-tree/
public class LP100 {
    public static void main(String[] args) {
//        String[] a = new String[]{"1", "2'"};
//        String[] b = new String[]{"1", null, "2'"};
    }

    // Simple한 정답
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null) {
            return false;
        }

        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /*
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null ^ q == null) {
            return false;
        }

        if(p != null) {
            if(p.val != q.val) {
                return false;
            }

            Queue<TreeNode> q1 = new LinkedList<>();
            Queue<TreeNode> q2 = new LinkedList<>();

            q1.offer(p);
            q2.offer(q);
            while(!q1.isEmpty() || !q2.isEmpty()) {
                TreeNode a = q1.poll();
                TreeNode b = q2.poll();

                if(a.left == null ^ b.left == null) {
                    return false;
                }

                if(a.left != null) {
                    if(a.left.val != b.left.val) {
                        return false;
                    }
                    else {
                        q1.offer(a.left);
                        q2.offer(b.left);
                    }
                }

                if(a.right == null ^ b.right == null) {
                    return false;
                }

                if(a.right != null) {
                    if(a.right.val != b.right.val) {
                        return false;
                    }
                    else {
                        q1.offer(a.right);
                        q2.offer(b.right);
                    }
                }
            }
        }

        return true;
    }
    */
}
