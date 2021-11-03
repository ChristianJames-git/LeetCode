/*
 * https://leetcode.com/problems/add-two-numbers/
 * 9/25/21
 *
 * Input: 2 non-empty linked lists, 2 non-negative integers stored in reverse order.
 * Output: Linked list representing the sum in reverse order
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode temp = new ListNode(0);
        ListNode curr = temp;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum/10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        test1(); //[2,4,3] + [5,6,4] = [7,0,8]
        test2(); //[0] + [0] = [0]
    }
    static void test1() {
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode b = new ListNode(3,  null);
        ListNode c = new ListNode(4,  b);
        ListNode d = new ListNode(2,  c);
        ListNode e = new ListNode(4,  null);
        ListNode f = new ListNode(6,  e);
        ListNode g = new ListNode(5,  f);
        print(a.addTwoNumbers(d, g));
    }
    static void test2() {
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode d = new ListNode(0,  null);
        ListNode g = new ListNode(0, null);
        print(a.addTwoNumbers(d, g));
    }
    static void print(ListNode ans) {
        System.out.print("[");
        while (ans != null) {
            System.out.print(ans.val);
            if (ans.next != null)
                System.out.print(",");
            ans = ans.next;
        }
        System.out.println("]");
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
