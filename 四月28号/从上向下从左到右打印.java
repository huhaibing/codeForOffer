package CodeForOffer.四月28号;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class OrderPrint {

    /*
    题目：从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

    思路：使用标志位控制一层的结束。
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > arrayList = new ArrayList<>();
        if(pRoot == null) return arrayList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        TreeNode layer = new TreeNode(Integer.MAX_VALUE);
        queue.offer(layer);
        ArrayList<Integer> list = new ArrayList<>();
        while(queue.size() > 1){
            TreeNode node = queue.poll();
            if(node.val == Integer.MAX_VALUE){
                arrayList.add(list);
                list = new ArrayList<>();
                queue.offer(node);
            }
            else{
                list.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        arrayList.add(list);
        return arrayList;
    }

}
