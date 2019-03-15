package trees;

import java.util.*;

public class TopView {

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

    public static void topView(Node root) {
        Map<Integer, Integer> view = new HashMap<>();
        Map<Integer, Integer> nodeIndex = new HashMap<>();
        view.put(0, root.data);
        nodeIndex.put(root.data, 0);
        Queue<Node> queue = new LinkedList<>();
        addChildren(root, queue, nodeIndex);
        while(!queue.isEmpty()) {
            Node element = queue.poll();
            Integer elementIndex = nodeIndex.get(element.data);
            if(!view.containsKey(elementIndex)) {
                view.put(elementIndex, element.data);
            }
            addChildren(element, queue, nodeIndex);
        }
        Map<Integer, Integer> sortedView = new TreeMap<>(view);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : sortedView.entrySet()) {
            sb.append(entry.getValue());
            sb.append(" ");
        }
        String result = sb.toString();
        System.out.println(result.substring(0, result.length() - 1));
    }

    private static void addChildren(Node root, Queue<Node> queue, Map<Integer, Integer> nodeIndex) {
        Integer rootIndex = nodeIndex.get(root.data);
        if(root.left != null) {
            queue.add(root.left);
            nodeIndex.put(root.left.data, rootIndex - 1);
        }
        if(root.right != null) {
            queue.add(root.right);
            nodeIndex.put(root.right.data, rootIndex + 1);
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
        topView(root);
    }
}
