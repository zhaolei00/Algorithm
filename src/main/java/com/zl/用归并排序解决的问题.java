package com.zl;

/**
 */
public class 用归并排序解决的问题 {

    public static void main(String[] args) {
//        int[] arr = {1, 9, 3, 4, 6, 3, 1, 2}; // 5 + 1 + 1 + 2 + 1
        int[] arr = {1, 9, 5, 2};
//        System.out.println(ReverseOrderPairQuestion.reverseOrderPair(arr));
//        System.out.println(SmallSumQuestion.smallSum(arr));
        System.out.println(BiggerThanRightTwiceQuestion.biggerThanRightTwice(arr));
    }

    //===============【题目1】小和问题 给定一个arr数组，让每个位置左边比他小的数相加，所有位置算出来的和再相加，求这个和数=====================
    private static class SmallSumQuestion {

        private static int smallSum(int[] arr) {
            if (arr == null || arr.length < 2) {
                return 0;
            }
            return mergeSort2(arr);
        }

        private static int mergeSort2(int[] arr) {
            if (arr == null || arr.length < 2) {
                return 0;
            }
            int smallSum = 0;
            int N = arr.length;
            int step = 1;
            while (step < N) {
                int L = 0;
                while (L < N) {
                    if (step >= N - L) {
                        break;
                    }
                    int mid = L + step - 1;
                    int R = Math.min(mid + step, N - 1);
                    smallSum += merge(arr, L, mid, R);
                    L = R + 1;
                }
                if (step > N / 2) {
                    break;
                }
                step <<= 1;
            }
            return smallSum;
        }

        private static int merge(int[] arr, int l, int m, int r) {
            int smallSum = 0;
            int[] help = new int[r - l + 1];
            int index = 0;
            int p1 = l;
            int p2 = m + 1;
            while (p1 <= m && p2 <= r) {
                smallSum += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
                help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            }
            while (p1 <= m) {
                help[index++] = arr[p1++];
            }
            while (p2 <= r) {
                help[index++] = arr[p2++];
            }
            for (int i = 0; i < help.length; i++) {
                arr[l + i] = help[i];
            }
            return smallSum;
        }
    }

    //===============【题目2】逆序对问题 给定一个arr数组，每个位置右边比他小的数的个数相加，得出逆序对数量===========
    private static class ReverseOrderPairQuestion {

        private static int reverseOrderPair(int[] arr) {
            if (arr == null || arr.length < 2) {
                return 0;
            }
            return mergeSort2(arr);
        }

        private static int mergeSort2(int[] arr) {
            if (arr == null || arr.length < 2) {
                return 0;
            }
            int pair = 0;
            int N = arr.length;
            int step = 1;
            while (step < N) {
                int L = 0;
                while (L < N) {
                    if (step >= N - L) {
                        break;
                    }
                    int mid = L + step - 1;
                    int R = Math.min(mid + step, N - 1);
                    pair += merge(arr, L, mid, R);
                    L = R + 1;
                }
                if (step > N / 2) {
                    break;
                }
                step <<= 1;
            }
            return pair;
        }

        private static int merge(int[] arr, int l, int m, int r) {
            int pair = 0;
            int[] help = new int[r - l + 1];
            int index = help.length - 1;
            int p1 = m;
            int p2 = r;
            while (p1 >= l && p2 >= m + 1) {
                pair += arr[p1] > arr[p2] ? p2 - m : 0;
                help[index--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
            }
            while (p1 >= l) {
                help[index--] = arr[p1--];
            }
            while (p2 >= m + 1) {
                help[index--] = arr[p2--];
            }
            for (int i = 0; i < help.length; i++) {
                arr[l + i] = help[i];
            }
            return pair;
        }
    }

    //===============【题目2】给定一个arr数组，每个位置右边乘2比他小的数的个数相加，得出这个数量===========
    private static class BiggerThanRightTwiceQuestion {

        private static int biggerThanRightTwice(int[] arr) {
            if (arr == null || arr.length < 2) {
                return 0;
            }
            return mergeSort2(arr);
        }

        private static int mergeSort2(int[] arr) {
            if (arr == null || arr.length < 2) {
                return 0;
            }
            int num = 0;
            int N = arr.length;
            int step = 1;
            while (step < N) {
                int L = 0;
                while (L < N) {
                    if (step >= N - L) {
                        break;
                    }
                    int mid = L + step - 1;
                    int R = Math.min(mid + step, N - 1);
                    num += merge(arr, L, mid, R);
                    L = R + 1;
                }
                if (step > N / 2) {
                    break;
                }
                step <<= 1;
            }
            return num;
        }

        private static int merge(int[] arr, int l, int m, int r) {
            int num = 0;
            int[] help = new int[r - l + 1];
            int index = 0;
            int p1 = l;
            int p2 = m + 1;
            int z2 = m + 1;
            for (int i = l; i <= m; i++) {
                while (z2 <= r && arr[i] > arr[z2] * 2) {
                    z2++;
                }
                num += z2 - m - 1;
            }
            while (p1 <= m && p2 <= r) {
                help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            }
            while (p1 <= m) {
                help[index++] = arr[p1++];
            }
            while (p2 <= r) {
                help[index++] = arr[p2++];
            }
            for (int i = 0; i < help.length; i++) {
                arr[l + i] = help[i];
            }
            return num;
        }

    }
}
