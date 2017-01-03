package com.huayu.study.algorithmStudy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhaohuayu on 17/1/3.
 * 弗洛伊德 floyd
 * 动态规划的实现:d[i][j] = min{d[i][k] + d[k][j], d[i][j]}
 */
public class Floyd {

    int n = 7 ; //顶点个数
    int[][] edgs = new int[n][n] ; //邻接矩阵,记录点的连通性及权重

    public void showEdgs() {
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                System.out.print(edgs[i][j] + ",");
            }
            System.out.println("");
        }
    }
    public void init() {
        for (int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i == j) {
                    edgs[i][j] = 0 ;
                } else {
                    edgs[i][j] = Integer.MAX_VALUE ;
                }
            }
        }
        edgs[0][1] = edgs[1][0] = 7 ;
        edgs[0][3] = edgs[3][0] =5 ;
        edgs[1][2] = edgs[2][1] =8 ;
        edgs[1][3] = edgs[3][1] =9 ;
        edgs[1][4] = edgs[4][1] =7 ;
        edgs[2][4] = edgs[4][2] =5 ;
        edgs[3][4] = edgs[4][3] =15 ;
        edgs[3][5] = edgs[5][3] =6 ;
        edgs[4][5] = edgs[5][4] =8 ;
        edgs[4][6] = edgs[6][4] =9 ;
        edgs[5][6] = edgs[6][5] =11 ;

    }

    public void floyd() {
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    if (edgs[i][k] == Integer.MAX_VALUE || edgs[k][j] == Integer.MAX_VALUE) {
                        continue ;
                    }
                    if (edgs[i][j] > edgs[i][k] + edgs[k][j]) {
                        edgs[i][j] = edgs[i][k] + edgs[k][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Floyd floyd = new Floyd();
        floyd.init();
        floyd.showEdgs();
        floyd.floyd();
        System.out.println();
        floyd.showEdgs();
    }
}
