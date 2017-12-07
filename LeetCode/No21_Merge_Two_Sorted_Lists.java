/**
 * No21_Merge_Two_Sorted_Lists
 */
public class No21_Merge_Two_Sorted_Lists {

    /**
     * 常规的方法：遍历一遍两个链表，分别判断，每次取小的一个元素
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 设置一个dummy节点
         * 以便最后直接返回头结点
         * 这是链表相关题目中常用技巧，
         * 多练习体会
         */
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode node = dummy;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
                node = node.next;
            }
            else {
                node.next = l2;
                l2 = l2.next;
                node = node.next;
            }
        }
        
        if(l1 != null)
            node.next = l1;
        if(l2 != null)
            node.next = l2;
            
        return dummy.next;   
    }
    

    /**
     * 递归版
     * 很巧妙，值得多思考体会
     */
    public ListNode mergeTwoLists_Recursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
} 