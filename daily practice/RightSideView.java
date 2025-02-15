import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
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
    List<List<Integer>> res = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();  
        }
        
        levelOrder(root);
        
        List<Integer> ans = new ArrayList<>();
        for (var each : res) {
            ans.add(each.get(each.size() - 1));  
        }
        return ans;
    }

    public void levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> help = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                
                if (curr != null) {
                    help.add(curr.val);
                    
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                    
                }
            }
            res.add(help); 
        }
    }
    public static void main(String[] args) {
        int[] nodes={15,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree BT = new BinaryTree();
        TreeNode root = BT.build(nodes);       
    }
}
