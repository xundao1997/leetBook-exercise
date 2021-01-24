package cn.com.xd.illustration.structure.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ： IsNumber
 * @Author ：寻道
 * @date ：Created in 2021/1/23 15:51
 * @Description 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5d6vi6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Modified By：
 * @version: V1.0
 */
public class IsNumber {


    /**
     *
     * 执行用时：8 ms, 在所有 Java 提交中击败了37.22%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了46.13%的用户
     *
     * 方法分析：按照字符串的定义从左至右的有以下状态
     * ① 0状态 开始的空格
     * ② 1状态 幂符号前的正负号
     * ③ 2状态 小数点前的数字
     * ④ 3状态 小数点、小数点后的数字
     * ⑤ 4状态 当前小数点前为空格时、小数点、小数点后的数字
     * ⑥ 5状态 幂符号
     * ⑦ 6状态 幂符号后的正负号
     * ⑧ 7状态 幂符号后的数字
     * ⑨ 8状态 结尾的空格
     * 合法的数字 结束的状态有 2、3、7、8
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        /**
         * 状态数组
         * s：正负号 - +
         * e：e E
         * n：数字
         * .：本身
         * 空格本身
         */
        Map[] states = {
                // 0状态
                new HashMap<>(16) {{
                    put(' ', 0);
                    put('s', 1);
                    put('n', 2);
                    put('.', 4);
                }},
                // 1状态
                new HashMap<>(16) {{
                    put('n', 2);
                    put('.', 4);
                }},
                // 2状态
                new HashMap<>(16) {{
                    put('n', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                // 3状态
                new HashMap<>(16) {{
                    put('n', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                // 4状态
                new HashMap<>(16) {{
                    put('n', 3);
                }},
                // 5状态
                new HashMap<>(16) {{
                    put('s', 6);
                    put('n', 7);
                }},
                // 6状态
                new HashMap<>(16) {{
                    put('n', 7);
                }},
                // 7状态
                new HashMap<>(16) {{
                    put('n', 7);
                    put(' ', 8);
                }},
                // 8状态
                new HashMap<>(16) {{
                    put(' ', 8);
                }}
        };
        // 状态转移
        int state = 0;
        // 记录字符
        char t;
        // 循环字符串数组
        for (char c : s.toCharArray()) {
            //遍历字符串 判断当前字符是哪个一个对应的状态
            if (c >= '0' && c <= '9') {
                t = 'n';
            } else if (c == '+' || c == '-') {
                t = 's';
            } else if (c == 'E' || c == 'e') {
                t = 'e';
            } else if (c == '.' || c == ' ') {
                t = c;
            } else {
                t = '?';
            }
            if (!states[state].containsKey(t)) {
                return false;
            }
            state = (int) states[state].get(t);
        }
        return state == 2 || state == 3 || state == 7 || state == 8;
    }

}

