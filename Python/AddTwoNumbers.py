# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        temp = ListNode
        result = temp
        carry = 0
        while l1 and l2:
            total = carry + l1.val + l2.val
            carry = 1 if total >= 10 else 0
            total = total % 10
            l1 = l1.next
            l2 = l2.next
            temp.next = ListNode(total)
            temp = temp.next

        while l1:
            total = carry + l1.val
            carry = 1 if total >= 10 else 0
            total = total % 10
            l1 = l1.next
            temp.next = ListNode(total)
            temp = temp.next

        while l2:
            total = carry + l2.val
            carry = 1 if total >= 10 else 0
            total = total % 10
            l2 = l2.next
            temp.next = ListNode(total)
            temp = temp.next

        if carry:
            temp.next = ListNode(1)

        return result.next