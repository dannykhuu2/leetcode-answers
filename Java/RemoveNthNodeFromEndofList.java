//Definition for singly-linked list.
import java.util.*;
// one pass solution using two pointers and moving the faster one n positions ahead to find the target node
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0, head);
        ListNode fast = start;
        ListNode slow = start;
        
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return start.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}

// two pass solution using an additional array list to keep track of nodes
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ArrayList<Integer> list = new ArrayList<>();
//         ListNode temp = new ListNode();
//         ListNode result = temp;
        
//         while (head != null) {
//             list.add(head.val);
//             head = head.next;
//         }
        
//         for (int i = 0; i < list.size() ; i++) {
//             if (i != list.size() - n) {
//                 temp.next = new ListNode(list.get(i));
//                 temp = temp.next;
//             }
//         }
        
//         return result.next;
//     }
// }