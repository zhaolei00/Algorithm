package com.zl.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class _7_记数排序 {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            max = Math.max(max, i);
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int index = 0;
        for (int i = 0; i <= max; i++) {
            Integer num = map.get(i);
            if (num == null) {
                continue;
            }
            for (int j = 0; j < num; j++) {
                arr[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 6, 1, 45, 23, 14, 15, 4, 2, 5};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
