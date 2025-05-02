package Binary_trees;

public class Kth_level {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }

    static class BinaryTree {

        public static class info {
            int h;
            int d;

            info(int h, int d) {
                this.h = h;
                this.d = d;
            }
        }
    }

    public static void kth_level(int k, int level, Node root) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.println(root.data + " ");
            return;

        }
        kth_level(k, level + 1, root.left);
        kth_level(k, level + 1, root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.left.left = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        BinaryTree r = new BinaryTree();
        kth_level(3, 1, root);

    }
}
