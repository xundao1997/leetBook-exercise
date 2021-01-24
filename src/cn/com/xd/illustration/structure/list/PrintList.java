package cn.com.xd.illustration.structure.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ： PrintList
 * @Author ：寻道
 * @date ：Created in 2021/1/22 22:13
 * @Description 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：
 * 0 <= 链表长度 <= 10000
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dt66m/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Modified By：
 * @version: V1.0
 */
public class PrintList {

    /**
     * 时间复杂度分析：O(N) 我们只遍历了2次长度为N，一次是链表。另一次是遍历集合
     * 空间复杂度分析：O(N) 只使用了空间为N的集合，占这么多的空间。虽然使用数组但是空间是没有变的
     * <p>
     * 执行用时：2 ms, 在所有 Java 提交中击败了36.24%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了61.17%的用户
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        // 首先定义一个集合来接收链表中的数据
        List<Integer> list = new LinkedList<>();
        // 遍历链表
        while (head != null) {
            // 取出链表中的值
            list.add(head.val);
            // 指向下一个节点
            head = head.next;
        }
        // 定义一个返回的数组
        int[] arr = new int[list.size()];
        int length = list.size() - 1;
        // 遍历集合
        for (int val : list) {
            arr[length--] = val;
        }
        return arr;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        System.out.println(Arrays.toString(new PrintList().reversePrint(node)));
    }
}
