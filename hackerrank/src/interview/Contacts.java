package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ashevenkov 11.04.17 18:10.
 */
public class Contacts {

    private class Node {
        Node[] children = new Node['z' - 'a' + 1];
        boolean isFinish = false;
        private int count = 0;

        public void addString(char[] str, int from) {
            count++;
            char current = str[from];
            Node node = children[current - 'a'];
            if(node == null) {
                node = new Node();
                children[current - 'a'] = node;
            }
            if(str.length == from + 1) {
                node.isFinish = true;
                node.count++;
            } else {
                node.addString(str, from + 1);
            }
        }

        public Node find(char[] str, int from) {
            char current = str[from];
            Node node = children[current - 'a'];
            if(node == null) {
                return null;
            } else {
                if(str.length == from + 1) {
                    return node;
                } else {
                    return node.find(str, from + 1);
                }
            }
        }

        public int countChildren() {
            return count;
        }
    }

    private Node root = new Node();

    public static void main(String[] args) {
        Contacts contacts = new Contacts();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add")) {
                contacts.addContact(contact);
            } else if(op.equals("find")) {
                int count = contacts.findPartial(contact);
                System.out.println(count);
            }
        }
    }

    private void addContact(String contact) {
        root.addString(contact.toCharArray(), 0);
    }

    private int findPartial(String part) {
        Node node = root.find(part.toCharArray(), 0);
        if(node == null) {
            return 0;
        } else {
            return node.countChildren();
        }
    }

}
