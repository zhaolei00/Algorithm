package com.zl.greedy;

import java.util.List;

/**
 *
 */
public class _1_字符串拼接字典序最小问题 {

    /**
     * 【题目】一个字符串数组，任意方式进行连接，得到字典序最小的方式。
     *  最先想到的思路是，把数组进行排序，再进行连接肯定得到的是最小。但是有反例。例如: [b, ba] -> bba > bab。
     *  排序策略: 两个字符串A，B  A.B < B.A 谁小先放谁。那就需要证明这个排序有传递性。
     *  想到贪心思路，不用证明。直接用比较器进行验证。
     */
    public static List<String> question(List<String> list) {
        return null;
    }

}
