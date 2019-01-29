package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // first attempt
//    public List<List<Integer>> levelOrder(Node root) {
//        if (root == null || root.children == null) return new LinkedList<>();
//
//        Queue<Node> q = new LinkedList<>();
//        Queue<Node> q2 = new LinkedList<>();
//
//        List<List<Integer>> ret = new LinkedList<>();
//
//        q.add(root);
//
//        while (! q.isEmpty()) {
//            List<Integer> row = new LinkedList<>();
//
//            for (int i = 0; i < q.size(); i++) {
//                Node n = ((LinkedList<Node>) q).get(i);
//                if (n != null)
//                    row.add(n.val);
//            }
//            ret.add(row);
//
//            while (! q.isEmpty()) {
//                Node n = q.poll();
//                if (n != null && n.children != null) {
//                    q2.addAll(n.children);
//                }
//            }
//
//            q = q2;
//            q2 = new LinkedList<>();
//        }
//
//        return ret;
//    }

    public List<List<Integer>> levelOrder(Node root) {
        /*
            Time Complexity - O(n) where n is the number of nodes in the tree
            Space Complexity - O(n)
         */
        if (root == null) return new LinkedList<>();

        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> ret = new LinkedList<>();

        q.add(root);

        while (! q.isEmpty()) {
            List<Integer> row = new LinkedList<>();

            int qlen = q.size();
            for (int i = 0; i < qlen; i++) {
                Node n = q.poll();
                if (n != null) {
                    row.add(n.val);
                    if (n.children != null) {
                        q.addAll(n.children);
                    }
                }
            }
            ret.add(row);
        }

        return ret;
    }

}
