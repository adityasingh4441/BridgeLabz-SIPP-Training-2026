public class BSTDeleteDemo {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node delete(Node node, int sku) {
        if (node == null) {
            return null;
        }
        if (sku < node.val) {
            node.left = delete(node.left, sku);
        } else if (sku > node.val) {
            node.right = delete(node.right, sku);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            node.val = successor.val;
            node.right = delete(node.right, successor.val);
        }
        return node;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(18);

        root = delete(root, 5);
        System.out.println(root.left.val);
    }
}
