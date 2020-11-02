import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import sun.tools.tree.ThisExpression;

public class MergeTwoList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
    }

}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tempNode = new ListNode(0);
        ListNode finalNode = tempNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tempNode.next = l1;
                l1  = l1.next;
            }else{
                tempNode.next = l2;
                l2 = l2.next;
            }
            tempNode = tempNode.next;
        }
        tempNode.next = (l1 == null) ? l2 : l1;

        return finalNode.next;
    }
}

/**
 * Definition for singly-linked list.
 */
 
 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 