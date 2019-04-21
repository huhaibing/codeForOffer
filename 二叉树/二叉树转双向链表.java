package CodeForOffer;

public class SearchTreeToDoubleList {

    /*
    题目：
    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

    思路：
    正常：利用的是中序遍历，因为中序遍历对于搜索二叉树，产生的结果是排序输出的。

    非正常：先从底部开始做转换，那么基于左右子树都连接好了，那么该节点的左边一定是连接现在指向左边节点
    （原二叉树指向的）所在的双向链表（现在这一侧已经完成转换）的最右端的节点，右边也是同理

    相比于上面的做法，这种做法的时间复杂度会高一些，因为连接左边和右边的时候，存在一个遍历的过程，如果很长
    就很慢了
     */

    //非正常
    /*
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        TreeNode left = pRootOfTree;
        while(left.left != null)
            left = left.left;
        TreeNode right = pRootOfTree;
        while(right.right != null)
            right = right.right;
        link(pRootOfTree);
        left.left = right;
        right.right = left;
        return pRootOfTree;
    }
    public void link(TreeNode node){
        if(node.left != null) link(node.left);
        if(node.right != null) link(node.right);
        if(node.left != null){
            TreeNode max = node.left; //左边最大
            while(max.right != null)
                max = max.right;
            node.left = max;
            max.right = node;
        }

        if(node.right != null){
            TreeNode min = node.right; // 右边最小
            while(min.left != null)
                min = min.left;
            node.right = min;
            min.left = node;
        }
    }
    */
    //正常：

    protected TreeNode leftLast = null;  //引入一个中间变量来标记左边最小值
    public TreeNode Convert(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null){
            leftLast = root;// 最后的一个节点可能为最右侧的叶节点
            return root;
        }
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            leftLast.right = root;
            root.left = leftLast;
        }
        leftLast = root;// 当根节点只含左子树时，则该根节点为最后一个节点
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;
    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    TreeNode buildTree(){
        TreeNode head = new TreeNode(30);
        head.left = new TreeNode(20);
        head.right = new TreeNode(40);
        head.left.left = new TreeNode(10);
        head.left.right = new TreeNode(25);
        head.left.left.left = new TreeNode(7);
        head.left.left.right = new TreeNode(13);
        head.left.left.right.left = new TreeNode(11);
        head.right.left = new TreeNode(35);
        head.right.right = new TreeNode(60);

//        TreeNode head = new TreeNode(10);
//        head.left = new TreeNode(6);
//        head.right = new TreeNode(14);
//        head.left.left = new TreeNode(4);
//        head.left.right = new TreeNode(8);
//        head.right.left = new TreeNode(12);
//        head.right.right = new TreeNode(16);
        return head;
    }
    public static void main(String[] args){
        SearchTreeToDoubleList main = new SearchTreeToDoubleList();
        TreeNode head = main.buildTree();
        main.Convert(head);
        main.print(head,9);

    }
    void print(TreeNode node, int num){
        TreeNode cur = node;
        for (int i = 0 ; i <= num; i++){
            System.out.print(cur.val + "  ");
            cur = cur.right;
        }
        System.out.println();
        cur = node;
        for (int i = 0 ; i <= num; i++){
            System.out.print(cur.val + "  ");
            cur = cur.left;
        }
    }
}
