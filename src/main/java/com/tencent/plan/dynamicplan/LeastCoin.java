package com.tencent.plan.dynamicplan;

public class LeastCoin {

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        System.out.println(leastCoin(coins, 3, 9));

    }

    public static int leastCoin(int[] coins, int num, int limit) {
        int[] states = new int[limit + 1];// 要到达9，所以取状态在[0,9]之间

        for (int i = 0; i <= limit; i++) {// 初始化 -1 表示不能满足要求
            states[i] = -1;
        }
        states[0] = 0;

        for (int i = 1; i <= limit; i++) {
            for (int j = 0; j < num; j++) {
                if (i - coins[j] >= 0 && states[i - coins[j]] >= 0) {//角标不越界，并且前一个状态可达（比如：i = 9，4要可达才能加上5）
                    int count = states[i - coins[j]] + 1;//前一个值需要的硬币数加 1
                    if (states[i] < 0 || states[i] > count) {// states[i] = -1,或者之前记录的硬币数比现在的要多
                        states[i] = count;
                    }
                }
            }
        }

        return states[limit];
    }
}
