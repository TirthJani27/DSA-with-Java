class LCAinBTree{
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p){
            return root;
        }
        if(root == q){
            return root;
        }
        TreeNode leftRes = lowestCommonAncestor(root.left,p,q);
        TreeNode rightRes = lowestCommonAncestor(root.right,p,q);
        if(leftRes == null && rightRes == null ){
            return null;
        }
        else if(leftRes != null && rightRes == null ){
            return leftRes;
        }
        else{
            return rightRes;
        }
    }
    public static void main(String[] args) {
        int[] nodes={15,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree BT = new BinaryTree();
        TreeNode root = BT.build(nodes);

    }
}