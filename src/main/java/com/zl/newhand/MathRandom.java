package com.zl.newhand;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/8 10:20
 * @Description :
 * 随机数
 * Math.random() 等概率返回 [0,1) 中的一个小数
 */
public class MathRandom {

    // 等概率返回[0,1)区间的小数
    private static double equalProbability1() {
        return Math.random();
    }

    // 等概率返回[0,N)区间的小数
    private static double equalProbability2(int n) {
        // 考虑边界
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return 0;
        }
        return equalProbability1() * n;
    }

    // [0, 1) 中，返回[0,x)的概率是x，现在要求是返回[0,x)的概率是x^2
    private static double equalProbability3() {
        return Math.max(equalProbability1(), equalProbability1());
    }

    // [0, 1) 中，返回[0,x)的概率是x，现在要求是返回[0,x)的概率是 1-(1-x)^2
    private static double equalProbability4() {
        return Math.min(equalProbability1(), equalProbability1());
    }

    // 等概率返回[0,N] 中的一个整数
    private static int equalProbability5(int N) {
        // 考虑边界
        if (N < 0) {
            throw new IllegalArgumentException();
        }
        // 等概率 [0,1)
        // *N+1 等概率[0,N+1)
        // 取整 [0,N]
        return (int) (equalProbability1() * (N + 1));
    }

    public static void main(String[] args) {
        int total = 1000000;
        int hit = 0;
        for (int i = 0; i < total; i++) {
            if (FN2.gn1() == 0) {
                hit++;
            }
        }
        System.out.println((double) hit / total);
        System.out.println((double) 5 / 18);
    }

    //===============【题目】 给一个f(n)函数是等概率返回[a,b], 构造出一个等概率返回[c,b]的函数g(n) =====================
    private static class FN1 {
        private static final int a = 4;
        private static final int b = 17;

        // 给定的条件不可以改
        // 等概率返回[a,b]中的一个整数。
        private static int fn() {
            int a = FN1.a;
            int b = FN1.b;
            if (a < 0 || a > b) {
                throw new IllegalArgumentException();
            }
            // [0, b-a] 等概率
            // +a 就是 [a, b] 等概率
            return equalProbability5(b - a) + a;
        }

        /**
         * 根据fn函数，等概率返回[c,d]中的一个整数
         */
        public static int gn(int c, int d) {
            // 考虑边界
            if (c < 0 || c > d) {
                throw new IllegalArgumentException();
            }
            if (d == 0) {
                return 0;
            }
            // 第一步: hn函数:根据fn获得[0,1]等概率
            // 第二步: 根据hn函数获得[0,大于等于d最近的一个2^n] 等概率返回函数sn
            // 第三步: 根据sn, 构建[0, d-c] 等概率函数tn
            // 第四步: tn + c 就构建出 [c,d] 等概率返回
            return tn(c, d) + c;
        }

        // 根据fn函数，构建等概率返回[0,1] 函数
        public static int hn() {
            // 考虑边界
            if (a < 0 || a > b || b == 0) {
                throw new IllegalArgumentException();
            }
            int fnValue;
            int mid = (a + b) >> 1;
            // 奇数
            if (((b - a + 1) & 1) == 1) {
                do {
                    fnValue = fn();
                } while (fnValue == mid); // 中间数重新取数
            } else {
                fnValue = fn();
            }
            if (fnValue <= mid) {
                return 0;
            } else {
                return 1;
            }
        }

        // 根据hn函数获得[0,大于等于d最近的一个2^n] 等概率返回函数sn
        public static int sn(int d) {
            // d小于等于0, [0,0]等概率返回没有意义
            if (d <= 0) {
                throw new IllegalArgumentException();
            }
            // 记录最高位为1是哪位
            int finalBit = 0;
            // 获取d的最高位为1的位置
            for (int i = 30; i >= 0; i--) {
                if ((d & (1 << i)) > 0) {
                    finalBit = i + 1;
                    break;
                }
            }
            int res = 0;
            for (int i = 0; i < finalBit; i++) {
                res |= (hn() << i);
            }
            return res;
        }

        // 根据sn, 构建[0, d-c] 等概率函数tn
        private static int tn(int c, int d) {
            int res;
            do {
                res = sn(d);
            } while (res > d - c);
            return res;
        }
    }

    //===================== 0、1不等概率，随机到0、1等概率=====================
    //===============【题目】给一个f(n)函数 返回0概率为P，返回1的概率为1-P, 构造一个g(n)函数，等概率返回0,1。=====================
    private static class FN2 {

        private static double a = 0.3;

        // 给定的条件不可以改
        // 0.3概率返回0 0.7概率返回1
        private static int fn() {
            return equalProbability1() < a ? 0 : 1;
        }

        private static int gn() {
            // P * 1-P 是相等的
            int res;
            do {
                res = 0;
                res |= fn();
                res |= fn() << 1;
            } while (res != 1 && res != 2);
            return res == 1 ? 0 : 1;
        }

        private static int gn1() {
            // P * 1-P 是相等的
            int res;
            do {
                res = fn();
            } while (res == fn());
            return res;
        }

    }
}
