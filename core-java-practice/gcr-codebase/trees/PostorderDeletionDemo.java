public class PostorderDeletionDemo {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void deleteFolderTree(Node node) {
        if (node == null) {
            return;
        }
        deleteFolderTree(node.left);
        deleteFolderTree(node.right);
        System.out.println("Deleting node " + node.val);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        deleteFolderTree(root);
    }
}
