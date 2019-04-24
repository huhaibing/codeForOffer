package CodeForOffer.四月24号;

import java.util.*;
public class FindFirstCommonNode{
    /*
    题目：输入两个链表，找出它们的第一个公共结点。
    思路：出现公共节点以后，那么后面的节点都是一样的，所以可以从后面开始比较。所以用栈
    也可以将两个链表变成一样的长度，开始同时向后，直到找到同一个。
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            if(pHead1 == null || pHead2 == null) return null;
            Stack<ListNode> stack1 = new Stack<>();
            Stack<ListNode> stack2 = new Stack<>();
            ListNode cur = pHead1;
            while(cur != null){
                stack1.push(cur);
                cur = cur.next;
            }
            cur = pHead2;
            while(cur != null){
                stack2.push(cur);
                cur = cur.next;
            }
            ListNode commom = null;
            while(!stack1.isEmpty() && !stack2.isEmpty()){
                ListNode tmp1 = stack1.pop();
                ListNode tmp2 = stack2.pop();
                if(tmp1 != tmp2){
                    break;
                }else{
                    commom = tmp2;
                }
            }
            return commom;
        }
}
