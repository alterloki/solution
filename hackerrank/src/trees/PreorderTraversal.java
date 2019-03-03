package trees;

import java.util.*;
import java.io.*;


public class PreorderTraversal {

    public static void preOrder(Node root) {
        StringBuilder sb = new StringBuilder();
        doPreorder(root, sb);
        String s = sb.toString();
        System.out.println(s.substring(0, s.length() - 1));
    }

    private static void doPreorder(Node root, StringBuilder sb) {
        sb.append(root.data).append(" ");
        doPreorder(root.left, sb);
        doPreorder(root.right, sb);
    }

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}
