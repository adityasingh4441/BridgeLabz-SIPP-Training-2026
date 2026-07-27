public class BSTLcaDemo {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node lowestCommonAncestor(Node root, int p, int q) {
        Node current = root;
        while (current != null) {
            if (p < current.val && q < current.val) {
                current = current.left;
            } else if (p > current.val && q > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        Node lca = lowestCommonAncestor(root, 2, 7);
        System.out.println(lca.val);
    }
}
