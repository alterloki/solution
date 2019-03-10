package trees;

import java.util.Scanner;

public class HeightBinaryTree {

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

    public static int height(Node root) {
        int maxLeft = 0;
        if(root.left != null) {
            maxLeft = height(root.left) + 1;
        }
        int maxRight = 0;
        if(root.right != null) {
            maxRight = height(root.right) + 1;
        }
        return Math.max(maxLeft, maxRight);
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
        int height = height(root);
        System.out.println(height);
    }
}
