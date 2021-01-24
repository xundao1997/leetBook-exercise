package cn.com.xd.illustration.structure.string;

/**
 * @ClassName ： ReplaceBlankSpace
 * @Author ：寻道
 * @date ：Created in 2021/1/20 7:56
 * @Description 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/50ywkd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Modified By：
 * @version: V1.0
 */
public class ReplaceBlankSpace {

    /**
     * 方法一 使用java的API方法
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了29.27%的用户
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    /**
     * 方法二：把字符串数组在遍历
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了64.76%的用户
     *
     * @param s
     * @return
     */
    public String replaceSpace2(String s) {
        char[] chars = new char[s.length() * 3];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                chars[size++] = c;
            }
        }
        return new String(chars, 0, size);
    }


    public static void main(String[] args) {
        ReplaceBlankSpace rbs = new ReplaceBlankSpace();
        System.out.println(rbs.replaceSpace2("We are happy."));
    }

}
