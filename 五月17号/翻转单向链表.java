package CodeForOffer.五月十七号;

public class ReverseList {

    /*
    题目：
    反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

    思路：见下面这种函数
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /*
    思路：使用三个指针进行滑动反转。注意滑动窗口的赋值顺序，特别注意头部和尾部的指针
     */
//     public ListNode reverseList(ListNode head) {
//         if(head == null || head.next == null) return head;
//         ListNode pre = null;
//         ListNode cur = head;
//         ListNode next = cur.next;
//         cur.next = null;
//         while(next != null){
//             pre = cur;
//             cur = next;
//             next = next.next;
//             cur.next = pre;
//         }
//         return cur;
//     }

    /*
   思路：使用创建一个新的链表，每次取出原先的链表放在当前链表的前面
    */
    public ListNode reverseList(ListNode head) {
        if(head == null ) return head;
        ListNode newHead = null;
        ListNode cur = head;
        ListNode next = cur.next;//注意：一定要引入这个next来过渡一下。
        while(cur != null){
            cur.next = newHead;
            newHead = cur;
            cur = next;
            if(cur != null) next = next.next;  //注意为空的情况
        }
        return newHead;
    }

}
