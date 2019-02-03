/**
 * 题目：
 *     给出两个非空的链表用来表示两个非负的整数。其中它们各自的位数按照逆序的方式存储的，
 *     并且它们的每个节点只能存储一位数字。
 *     返回一个新的链表表示它们的和。
 */
public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 新建一个-1节点，为了输出时，直接从dummy.next输出就是结果。
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;   // 引用复制，cur的变化也是dummy的变化。
        int carry = 0;          // 得十进位
        while (l1 != null || l2 != null) {
            int d1 = l1 == null ? 0 : l1.val;  //l1的值
            int d2 = l2 == null ? 0 : l2.val;  //l2的值
            int sum = d1 + d2 + carry;  //计算当前位置得和，需要考虑上一位所得得进位。
            carry = sum >= 10 ? 1 : 0;  //如果当前位置和大于10，需要更新进位标识。
            cur.next = new ListNode(sum % 10);  //新建链表节点。

            // 准备下一轮循环
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // 如果最高位有进位，则新增最高为链表节点。
        if (carry == 1) cur.next = new ListNode(1);

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(6);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        AddTwoNumbers_2 leetCode = new AddTwoNumbers_2();
        ListNode res = leetCode.addTwoNumbers(l1, l2);
        System.out.println("The result of AddTwoNumbers is ");
        while(res != null) {
            System.out.println(res.val + "");
            res = res.next;
        }
    }
}

