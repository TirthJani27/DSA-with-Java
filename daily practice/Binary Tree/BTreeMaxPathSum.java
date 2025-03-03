public class BTreeMaxPathSum {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    class BinaryTree {
        int i = -1;

        public TreeNode build(int[] arr) {
            i++;
            if (arr[i] == -1) {
                return null;
            }
            TreeNode newNode = new TreeNode(arr[i]);
            newNode.left = build(arr);
            newNode.right = build(arr);
            return newNode;
        }
    }

    private int ans = -1001;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        ans = Math.max(ans, root.val + left + right);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, -1, -1, -1 };
        BTreeMaxPathSum checkSubTree = new BTreeMaxPathSum();
        BinaryTree BT = checkSubTree.new BinaryTree();
        TreeNode root = BT.build(nodes);
        // System.out.println(maxPathSum(root));

    }
}
