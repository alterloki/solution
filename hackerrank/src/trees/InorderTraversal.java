package trees;

import java.util.Scanner;

public class InorderTraversal {
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

    public static void inOrder(Node root) {
        StringBuilder sb = new StringBuilder();
        doInorder(root, sb);
        String s = sb.toString();
        System.out.println(s.substring(0, s.length() - 1));
    }

    private static void doInorder(Node root, StringBuilder sb) {
        if(root.left != null) {
            doInorder(root.left, sb);
        }
        sb.append(root.data).append(" ");
        if(root.right != null) {
            doInorder(root.right, sb);
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
        inOrder(root);
    }
}
