package com.zl.heap;

import com.zl.tiku._99_对数器;

import java.util.Arrays;

/**
 */
public class _2_购买商品前K名问题 {

    // 得奖区
    private MyEnhanceHeap<Player> yes = new MyEnhanceHeap<>(
            (o1, o2) -> o1.getNum() == o2.getNum() ? o1.time - o2.time : o1.getNum() - o2.getNum());
    // 候选区
    private MyEnhanceHeap<Player> no = new MyEnhanceHeap<>(
            (o1, o2) -> o1.getNum() == o2.getNum() ? o1.time - o2.time : o2.getNum() - o1.getNum());

    /**
     *【题目】给定一个整数数组int[] arr，和布尔类型数组boolean[] op，arr和op等长。
     *       arr: 代表客户编号。
     *       op: 代表客户操作  true 为购买 false 为退货。
     *       arr[i] 和 op[i] 为一对事件，表示 arr[i] 客户，操作了 op[i]。
     *       发生购买事件，购买商品+1。发生退货事件，购买商品-1。
     *       规则一: 某个用户之前的购买记录为0，且操作了退货，事件无效。
     *       规则二: 客户退货后，购买数量为0时，客户即使之前在得奖区或候选区，也要移除。
     *       规则三: 有两个区域: 得奖区和候选区。
     *                a. 进入候选区的时间为当前事件的时间。
     *                b. 进入得奖区的时间为当前事件的时间。
     *       规则四: 当候选区购买的数量 大于 得奖区最小的购买数量，进行替换。
     *                a. 选择候选区数量最多且最早进入候选区的。
     *                b. 替换得奖区购买数量最少且最早进入得奖区的。
     *       规则五: 重复购买的用户，时间不会变。
     *       诉求: 每个事件到来时候，获得得奖区名单。
     *
     */
    public int[] question(int[] arr, boolean[] op, int K) {
        if (arr == null || op == null
                || arr.length == 0
                || op.length == 0
                || arr.length != op.length
                || K <= 0) {
            return new int[0];
        }
        for (int i = 0; i < arr.length; i++) {
            if (op[i]) {
                add(arr[i], i, K);
            } else {
                cancle(arr[i], i, K);
            }
        }
        int[] ans = new int[yes.size()];
        int index = 0;
        while (!yes.isEmpty()) {
            ans[index++] = yes.poll().getId();
        }
        return ans;
    }

    public void add(int id, int time, int K) {
        Player player = new Player(id, time, 1);
        // 在获奖区
        if (yes.contains(player)) {
            int oldIndex = yes.getIndex(player);
            player = yes.get(oldIndex);
            player.setNum(player.getNum() + 1);
            yes.resign(player); // 平衡
        }
        // 在候选区
        else if (no.contains(player)) {
            int oldIndex = no.getIndex(player);
            player = no.get(oldIndex);
            player.setNum(player.getNum() + 1);
            no.resign(player);
        }
        // 两个都没在
        else {
            if (yes.size() < K) {
                yes.add(player);
            } else {
                no.add(player);
            }
        }
        tiao(K);
    }

    public void cancle(int id, int time, int K) {
        Player player = new Player(id, time, 0);
        // 在获奖区
        if (yes.contains(player)) {
            int oldIndex = yes.getIndex(player);
            player = yes.get(oldIndex);
            player.setNum(player.getNum() - 1);
            if (player.getNum() == 0) {
                yes.remove(player);
            }
        }
        // 在候选区
        else if (no.contains(player)) {
            int oldIndex = no.getIndex(player);
            player = no.get(oldIndex);
            player.setNum(player.getNum() - 1);
            if (player.getNum() == 0) {
                no.remove(player);
            }
        }
        // 两个都没在
        else {
            return;
        }
        tiao(K);
    }

    // 候选区可能去得奖区
    public void tiao(int K) {
        if (no.isEmpty()) {
            return;
        }
        if (yes.size() < K) {
            yes.add(no.poll());
            return;
        }
        // 调整
        Player noPlayer = no.peek();
        Player yesPlayer = yes.peek();
        if (noPlayer.getNum() > yesPlayer.getNum()) {
            no.set(0, yesPlayer);
            yes.set(0, noPlayer);
            no.resign(yesPlayer);
            yes.resign(noPlayer);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5, 2,1,4,3,2};
        boolean[] op = new boolean[]{true, false, false, true, true, true, false, false, true, false};
        _2_购买商品前K名问题 a = new _2_购买商品前K名问题();
        int[] question = a.question(arr, op, 2);
        System.out.println(Arrays.toString(question));
    }

    private static class Player {
        public int id;
        public int time;

        private int num;

        public Player(int id, int time, int num) {
            this.id = id;
            this.time = time;
            this.num = num;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Player)) {
                return false;
            }
            return id == ((Player) obj).getId();
        }

        @Override
        public String toString() {
            return "Player{" +
                    "id=" + id +
                    ", time=" + time +
                    ", num=" + num +
                    '}';
        }
    }
}
