package com.huayu.study.algorithmStudy;

import java.util.*;

/**
 * Created by zhaohuayu on 17/1/2.
 * 最小生成树 kruskal克鲁斯卡尔
 * 核心:
 * 环的判断:每个顶点作为一个树,两个点在不同的树上,连接后合成一个树,最后形成一个大树。如果两个点在一个树种,
 * 则会形成环,排除掉这样的变。
 * 边得选取:所有边按照权重排序,每次取最小权重的边,如果没有行成环,则加入生成树,并把订单设为同一个树。选取
 * 条数为顶点数-1(最后形成一个树,数的顶点数-1=边数)
 *
 */
public class Kruskal {





    int n = 7 ; //顶点个数
    int[][] edgs = new int[n][n] ; //邻接矩阵,记录点的连通性及权重
    int[] vertex = new int[n] ;//顶点表,不同顶点初始化为不同的集合

    public void init() {
        edgs[0][1] = 7 ;
        edgs[0][3] = 5 ;
        edgs[1][2] = 8 ;
        edgs[1][3] = 9 ;
        edgs[1][4] = 7 ;
        edgs[2][4] = 5 ;
        edgs[3][4] = 15 ;
        edgs[3][5] = 6 ;
        edgs[4][5] = 8 ;
        edgs[4][6] = 9 ;
        edgs[5][6] = 11 ;

        for (int i=0; i< n; i++) {
            vertex[i] = i ;
        }
    }

    public void kruskal() {
        List<Edge> list = new ArrayList<Edge>() ;
        for (int i=0; i< n; i++) {
            for (int j=i; j< n; j++) {
                if (edgs[i][j] != 0) {
                    list.add(new Edge(i,j,edgs[i][j])) ;
                }
            }
        }
        Collections.sort(list ,new Comparator<Edge>() {
            public int compare(Edge o1, Edge o2) {
                return o1.w - o2.w ;
            }
        });

        int k = 0 ;
        int e = 0 ;
        while (k < n -1) {
            int v1 = vertex[list.get(e).getU()];
            int v2 = vertex[list.get(e).getV()];
            if (v1 != v2) {
                System.out.println("edge:" + list.get(e).getU() + " " + list.get(e).getV() + " " +list.get(e).getW());
                for (int i=0 ; i< n; i++) {
                    if (vertex[i] == v2) {
                        vertex[i] = v1 ;
                    }
                }
                k++ ;
            }
            e++ ;


        }
    }




    class Edge implements Comparator<Edge> {
        int u;
        int v;
        int w;

        public int compare(Edge o1, Edge o2) {
            return o1.w - o2.w ;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public int getU() {
            return u;
        }

        public void setU(int u) {
            this.u = u;
        }

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal() ;
        kruskal.init();
        kruskal.kruskal();
    }
}
