public class BTreeMaxPath {
    static class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.val=data;
            right=null;
            left=null;
        }
    }
    static class BinaryTree{
        static int i=-1;
        public static TreeNode build(int[] arr){
            i++;
            if(arr[i]==-1){
                return null;
            }
            TreeNode newNode = new TreeNode(arr[i]);
            newNode.left=build(arr);
            newNode.right=build(arr);
            return newNode;
        }
    }
    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        if(root == null)
        return 0;
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        if(left+right+root.val > max)
            max = left+right+root.val;
        return left+right+root.val;
    }
    public static void main(String[] args) {
        int[] nodes={-10,-9,-1,-1,-1,15,-1,-20,-7,-1,-1};
        BinaryTree BT = new BinaryTree();
        TreeNode root = BT.build(nodes);
        System.out.println(maxPathSum(root));
    }
}
