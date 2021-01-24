package cn.com.xd.illustration.structure.list;

/**
 * @ClassName ： ReverseList
 * @Author ：寻道
 * @date ：Created in 2021/1/23 18:41
 * @Description 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 限制：
 * 0 <= 节点个数 <= 5000
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9pdjbm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Modified By：
 * @version: V1.0
 */
public class ReverseList {

    /**
     * 方法一：引用一个链表和一个临时节点
     * <p>
     * 时间复杂度分析：O(N) 当前只遍历了一遍链表 所以时间复杂度为 O(N)
     * 空间复杂度分析：O(N) 引用了一个新的链表 和一个临时节点 这个新的链表的空间复杂度是O(N)
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了79.82%的用户
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 用来反转的链表
        ListNode node = null;
        // 用来传过来的链表
        ListNode pre = head;
        if (head == null) {
            return null;
        }
        /**
         * 就是相当于 给在反转链表的首节点加一个节点 这个加的节点就原链表遍历的当前节点
         */
        while (pre != null) {
            // 把原链表的下一个节点 赋值给临时节点
            ListNode temp = pre.next;
            // 把反转的链表赋值给原链表上
            pre.next = node;
            // 把原链表 现在赋值给反转链表上，
            node = pre;
            // 在指向原链表的下一个节点
            pre = temp;
        }
        return node;
    }

    public ListNode reverseList2(ListNode head) {
        return recur(head,null);
    }

    private ListNode recur(ListNode cur, ListNode pre){
        // 递归终止条件
        if (cur == null){
                return pre;
        }
        // 递归后续的节点
        ListNode res = recur(cur.next,cur);
        // 修改节点后的引用
        cur.next = pre;
        // 返回反转链表的头节点
        return res;
    }
}
