public class BSTInsertDemo {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node insert(Node node, int id) {
        if (node == null) {
            return new Node(id);
        }
        if (id < node.val) {
            node.left = insert(node.left, id);
        } else if (id > node.val) {
            node.right = insert(node.right, id);
        }
        return node;
    }

    public static void main(String[] args) {
        Node root = insert(null, 10);
        root = insert(root, 5);
        root = insert(root, 15);
        root = insert(root, 12);
        System.out.println(root.right.left.val);
    }
}
