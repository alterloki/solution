package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversal {

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

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        doLevelOrder(queue, sb);
        String result = sb.toString();
        System.out.println(result.substring(0, result.length() - 1));
    }

    private static void doLevelOrder(Queue<Node> queue, StringBuilder sb) {
        Queue<Node> children = new LinkedList<>();
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            sb.append(node.data).append(" ");
            if(node.left != null) {
                children.add(node.left);
            }
            if(node.right != null) {
                children.add(node.right);
            }
        }
        if(children.size() > 0) {
            doLevelOrder(children, sb);
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
        levelOrder(root);
    }
}
