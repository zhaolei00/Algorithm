package com.zl.unionfind;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二维数组，a[i][j] == 1 代表i和j认识。认识的人放到一起组成一个朋友圈，返回朋友圈数量。
 * 例如: 1和2认识 2和3认识 4和5认识 6和7认识。123、45、67、为3个朋友圈
 */
public class _1_朋友圈问题 {

    public static int friendCircleNum(int[][] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        List<Integer> member = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            member.add(i);
        }
        UnionFind.UnionSet<Integer> unionSet = new UnionFind.UnionSet<>(member);
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i][j] == 1) {
                    unionSet.union(i, j);
                }
            }
        }
        return unionSet.size();
    }

}
