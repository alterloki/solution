package interview;

import java.util.*;

/**
 * @author ashevenkov 10.04.17 14:09.
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        new BinarySearchTree();
    }

    public BinarySearchTree() {
        Queue<Node> queue = new LinkedList<>();
        int[] ns = {3, 2, 6, 1, 4, 5, 7};
        Node root = new Node(ns[0]);
        queue.add(root);
        for(int i = 1; i < ns.length; i++) {
            int d = ns[i];
            Node node = queue.poll();
            node.left = new Node(d);
            queue.add(node.left);
            if(i < ns.length - 1) {
                d = ns[++i];
                node.right = new Node(d);
                queue.add(node.right);
            }
        }
        System.out.println(checkBST(root));
    }

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    boolean checkBST(Node root) {
        return tryNode(root.left, Integer.MIN_VALUE, root.data) &&
                tryNode(root.right, root.data, Integer.MAX_VALUE);
    }

    private boolean tryNode(Node node, int min, int max) {
        if(node == null) {
            return true;
        }
        if(node.data <= min || node.data >= max) {
            return false;
        }
        return tryNode(node.left, min, node.data) && tryNode(node.right, node.data, max);
    }

}
