package CodeForOffer.四月28号;

import java.util.ArrayList;
import java.util.Stack;

public class Print {

    /*
    题目：
    请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

    思路：使用一个标志位，来交换两个栈，一个栈要求左子树先压，另一个要求右子树先压。
     */
        public class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;

            }

        }
        public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
            if(pRoot == null) return arrayList;
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            int flag = 1;
            stack1.push(pRoot);
            while(!stack1.isEmpty()||!stack2.isEmpty()){
                if(flag == 1){
                    flag = 0;
                    ArrayList<Integer> list = new ArrayList<>();
                    while(!stack1.isEmpty()){
                        TreeNode tmp = stack1.pop();
                        list.add(tmp.val);
                        if(tmp.left != null) stack2.push(tmp.left);
                        if(tmp.right != null) stack2.push(tmp.right);
                    }
                    arrayList.add(list);
                }
                else{
                    flag = 1;
                    ArrayList<Integer> list = new ArrayList<>();
                    while(!stack2.isEmpty()){
                        TreeNode tmp = stack2.pop();
                        list.add(tmp.val);
                        if(tmp.right != null) stack1.push(tmp.right);
                        if(tmp.left != null) stack1.push(tmp.left);
                    }
                    arrayList.add(list);
                }
            }
            return arrayList;
        }

}
