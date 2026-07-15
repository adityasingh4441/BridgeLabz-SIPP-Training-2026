import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class BSTIterator {
        private List<Integer> values = new ArrayList<>();
        private int index = 0;

        BSTIterator(TreeNode root) {
            inorder(root);
        }

        private void inorder(TreeNode node) {
            if (node == null) {
                return;
            }

            inorder(node.left);
            values.add(node.val);
            inorder(node.right);
        }

        public int next() {
            return values.get(index++);
        }

        public boolean hasNext() {
            return index < values.size();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
