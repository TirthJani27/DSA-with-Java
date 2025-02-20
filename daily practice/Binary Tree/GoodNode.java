import javax.swing.tree.TreeNode;

public class GoodNode {
    static class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
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
    public static int goodNodes(TreeNode root){
        if(root == null)
        return 0;
        return dfs(root,root.val);        
    }
    private static int dfs(TreeNode root, int max){
        if(root == null)
            return 0;
        
        max = Math.max(root.val,max);
        if(max <= root.val){
            return 1+dfs(root.left, max)+dfs(root.right, max);
        }else{
            return dfs(root.left, max)+dfs(root.right, max);
        }

    }
    public static void main(String[] args) {
        int[] nodes={3,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree BT = new BinaryTree();
        TreeNode root = BT.build(nodes);
    }
}
