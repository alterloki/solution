package thirtydays;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ashevenkov 07.04.17 1:02.
 */
public class BinarySearchTrees {

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }

    public static int getHeight(Node root){
        int[] maxHeight = new int[1];
        getNodeHeight(root, 0, maxHeight);
        return maxHeight[0];
    }

    private static void getNodeHeight(Node node, int currentHeight, int[] maxHeight) {
        if(currentHeight > maxHeight[0]) {
            maxHeight[0] = currentHeight;
        }
        if(node.left != null) {
            getNodeHeight(node.left, currentHeight + 1, maxHeight);
        }
        if(node.right != null) {
            getNodeHeight(node.right, currentHeight + 1, maxHeight);
        }
    }
}
