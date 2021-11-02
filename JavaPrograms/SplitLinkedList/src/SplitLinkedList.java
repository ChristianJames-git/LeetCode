/*
 * https://leetcode.com/problems/split-linked-list-in-parts/
 * 9/29/21
 *
 * Inputs: head of singly linked list of ListNode, int number of linked list parts
 * Output: Split input list into k consecutive parts in ListNode[]
 * Equal length parts, differing by no more than 1. Greater sized might occur earlier
 */
public class SplitLinkedList {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr = new ListNode[k];
        for (int i = 0 ; i < k ; i++)
            arr[i] = createBlankNode();
        ListNode curr = head;
        int totalNodes = 0;
        while (curr != null) {
            totalNodes++;
            curr = curr.next;
        }
        int minSize = totalNodes/k;
        int excess = totalNodes%k;
        curr = head;
        for (int i = 0 ; i < k ; i++) {
            arr[i] = curr;
            int addExcess = 0;
            if (excess-- > 0)
                addExcess = 1;
            for (int j = 0; j < minSize+addExcess ; j++) {
                head = curr;
                curr = curr.next;
            }
            if (head != null)
                head.next = null;
        }
        return arr;
    }
    public ListNode createBlankNode() {
        return new ListNode(-1, null);
    }
    public void printOutput(ListNode[] output) {
        System.out.print("[");
        for (int i = 0 ; i < output.length ; i++) {
            System.out.print("[");
            while (output[i] != null) {
                System.out.print(output[i].val);
                if (output[i].next != null)
                    System.out.print(",");
                output[i] = output[i].next;
            }
            System.out.print("]");
            if (i != output.length-1)
                System.out.print(",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        test1(); // [[1],[2],[3],[],[]]
        test2(); // [[1,2,3,4],[5,6,7],[8,9,10]]
    }
    static void test1() {
        SplitLinkedList a = new SplitLinkedList();
        ListNode x = new ListNode(3, null);
        ListNode y = new ListNode(2, x);
        ListNode z = new ListNode(1, y);
        a.printOutput(a.splitListToParts(z, 5));
    }
    static void test2() {
        SplitLinkedList a = new SplitLinkedList();
        ListNode x = new ListNode(10, null);
        for (int i = 9; i > 0; i--) {
            x = new ListNode(i, x);
        }
        a.printOutput(a.splitListToParts(x, 3));
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
