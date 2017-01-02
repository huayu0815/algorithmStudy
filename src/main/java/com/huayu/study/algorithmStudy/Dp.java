package com.huayu.study.algorithmStudy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaohuayu on 17/1/2.
 * 给定硬币面额3,4,5,求获取value的最多硬币组合方式
 * (动态规划:图中,获取当前状态=前一状态+1,递归)
 */
public class Dp {

    int[] coins = new int[]{3,4,5} ;


    //到达value的最大组合方式的次数。计算方式为根据银币面额,分别获取(value-面额)的不同次数的最大值+1
    public int dpMax(int value) {
        if (value < 3) {
            return 0 ;
        }
        int sort = Integer.MIN_VALUE ;
        for(int i=0;i<coins.length;i++) {
            if (coins[i] <= value) {
                int times = dpMax(value - coins[i]) + 1 ;
                if (times > sort) {
                    sort = times ;
                }
            }
        }
        return sort;
    }

    public static void main(String[] args) {
        Dp dp = new Dp() ;
        int value = 20 ;
        System.out.println(dp.dpMax(value)) ;
    }
}
