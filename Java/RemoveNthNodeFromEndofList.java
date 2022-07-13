//Definition for singly-linked list.
import java.util.*;
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = new ListNode();
        ListNode result = temp;
        
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        for (int i = 0; i < list.size() ; i++) {
            if (i != list.size() - n) {
                temp.next = new ListNode(list.get(i));
                temp = temp.next;
            }
        }
        
        return result.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}