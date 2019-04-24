package CodeForOffer.四月24号;

public class IsBalanceTree {

    /*
    题目：
    输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

    思路：就是深搜，但是要注意返回两种，一种是子树是否符合平衡，符合返回一个深度，这里可以使用一个数据结构返回，也可以使用-1 标定另外一种状态
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static class State{
        int depth ;
        boolean flag;
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        State res = dfs(root);
        return res.flag;
    }
    public State dfs(TreeNode node){
        State state = new State();
        if(node.left == null && node.right == null){
            state.depth = 1;
            state.flag = true;
        }
        int left = 0, right = 0;
        if(node.left != null){
            State leftState = dfs(node.left);
            if(leftState.flag == false) {
                state.flag = false;
                return state;
            }
            left = leftState.depth;
        }
        if(node.right != null){
            State rightState = dfs(node.right);
            if(rightState.flag == false){
                state.flag = false;
                return state;
            }
            right = rightState.depth;
        }
        if(Math.abs(left-right) > 1) {
            state.flag = false;
        }
        else{
            state.flag = true;
            state.depth = (left > right ? left : right) + 1;
        }

        return state;
    }

}
