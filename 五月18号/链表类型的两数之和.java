package CodeForOffer.五月十八号;

public class AddTwoNumbers {
    /*题目：两个
    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
     */
    public static void main(String[] args) {
        AddTwoNumbers main = new AddTwoNumbers();
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node2.next = node4;
        node4.next = node3;

        ListNode node = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node44 = new ListNode(4);
        node.next = node6;
        node6.next = node44;
        ListNode res = main.addTwoNumbers(node2,node);
        while (res != null)
        {
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode cur = null;
        int add1 = 0, add2 = 0;
        ListNode cur1 = l1 , cur2 = l2;
        while(cur1 != null || cur2 != null){
            if(cur1 != null) {
                add1 = cur1.val;
                cur1 = cur1.next;
            }
            else
            {
                add1 = 0 ;
            }
            if(cur2 != null){
                add2 = cur2.val;
                cur2 = cur2.next;
            }
            else
            {
                add2 = 0;
            }
            int sum = add1 + add2 + carry;
            carry = sum / 10;
            int val = sum % 10;
            if(head == null){
                head = new ListNode(val);
                cur = head;
            }
            else{
                cur.next = new ListNode(val);
            }
        }
        if(carry == 1) cur.next = new ListNode(1);
        return head;
    }
}
