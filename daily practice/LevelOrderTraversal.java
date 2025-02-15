import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class LevelOrderTraversal{
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
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> help = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if(queue.peek().left != null){
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.add(queue.peek().right);
                }
                help.add(queue.poll().val);
            }
            ans.add(help);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nodes={15,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree BT = new BinaryTree();
        TreeNode root = BT.build(nodes);
        // System.out.println(levelOrder(root));
        for (var each : levelOrder(root)) {
            System.out.println(each.get(each.size() -1));
        }
    }
}