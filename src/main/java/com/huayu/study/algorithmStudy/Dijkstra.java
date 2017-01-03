package com.huayu.study.algorithmStudy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhaohuayu on 17/1/3.
 */
public class Dijkstra {

    int n = 7 ; //顶点个数
    int[][] edgs = new int[n][n] ; //邻接矩阵,记录点的连通性及权重
    Set<Integer> Vnew = new HashSet<Integer>() ;//取得的新点
    Map<Integer,Integer> distinct = new HashMap<Integer,Integer>() ;

    public void showDis() {
        System.out.println(distinct);
    }

    public void init() {
        for (int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                edgs[i][j] = Integer.MAX_VALUE ;
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

        distinct.put(0, 0) ;
        for (int i=1; i< n; i++) {
            distinct.put(i, edgs[0][i]) ;

        }
    }

    public void dijkstra() {
        int u = 0 ;//选中点

        int k = 0 ;
        while (k < n) {
            int minDis = Integer.MAX_VALUE ;//遍历后的最小边
            int minU = 0 ;//遍历选中的新的点(距离最短)
            for(int i=0;i<n;i++) {
                if(!Vnew.contains(i)) {
                    if (edgs[u][i] < Integer.MAX_VALUE) { //无法到达的点无需判断
                        int newDistinct = edgs[u][i] + distinct.get(u) ;
                        if(newDistinct < distinct.get(i)) { //更新距离
                            distinct.put(i, newDistinct) ;
                        }
                    }

                    int min = distinct.get(i) ;
                    if (min < minDis) { //取最小距离点入Vnew
                        minDis = min ;
                        minU = i ;
                    }
                }
            }
            Vnew.add(minU) ;
            u = minU;
            k++;
        }
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra() ;
        dijkstra.init();
        dijkstra.showDis();
        dijkstra.dijkstra() ;
        dijkstra.showDis();
    }

}
