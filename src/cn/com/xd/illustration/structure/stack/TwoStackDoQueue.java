package cn.com.xd.illustration.structure.stack;

import java.util.Stack;

/**
 * @ClassName ： TwoStackDoQueue
 * @Author ：寻道
 * @date ：Created in 2021/1/22 22:38
 * @Description 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * <p>
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * 1 <= values <= 10000
 * 最多会对appendTail、deleteHead 进行10000次调用
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5d3i87/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Modified By：
 * @version: V1.0
 */
public class TwoStackDoQueue {

    /**
     * 时间复杂度分析：O(N) 进队列方法的时间复杂度是O(1), 出队列的时间复杂的是第一个栈中的数据进入第二个中 最
     *  坏的情况下是总长度为N的数据 所以是O(N)
     *  空间复杂度分析：O(N) 空间复杂度是两个栈当最坏的情况下最多会占用N个空间 所以是O(N)
     *
     * 执行用时：58 ms, 在所有 Java 提交中击败了55.16%的用户
     * 内存消耗：46.7 MB, 在所有 Java 提交中击败了53.78%的用户
     */

    /**
     * 定义两个栈也可以是集合用来存储数据。
     * 第一个栈用来做进队列的操作，第二个用来做出队列的操作
     * 当来数据的时候进第一个栈，当需要出队列的时候，先判断第二栈中是否有数据如果有，就进行出栈 就相对于整体是出队列
     * 如果没有，第一个栈的数据进入第二个栈去 然后出栈。当两个栈中都没有数据的时候。抛出异常。
     */
    private Stack<Integer> enterStack;
    private Stack<Integer> outStack;

    /**
     * 初始化栈
     */
    public TwoStackDoQueue() {
        this.enterStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    /**
     * 进队列
     * @param value
     */
    public void appendTail(int value) {
        enterStack.push(value);
    }

    /**
     * 出队列
     * @return
     */
    public int deleteHead() {
        // 数据进行迁移
        exchange();
        // 如果第二个栈不为空出栈
        if (outStack.isEmpty()) {
            return outStack.pop();
        }
        return -1;
    }

    /**
     * 当第二个栈为空 第一个栈部位空的情况 第一个栈的数据进入第二栈中
     */
    public void exchange() {
        if (outStack.isEmpty()) {
            while (!enterStack.isEmpty()) {
                outStack.push(enterStack.pop());
            }
        }
    }
}
