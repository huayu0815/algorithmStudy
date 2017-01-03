package com.huayu.study.algorithmStudy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaohuayu on 17/1/3.
 * 最小生成树 prim 普里姆算法
 * 核心:
 * 把所有点放到集合V中,任意取出一个点u放到Vnew中。查找Vnew中的点到V中的点的权重最小的边,
 * 把对应的点放到Vnew中,直到点全部放到Vnew中即可
 */
public class Prim {

    int n = 7 ; //顶点个数
    int[][] edgs = new int[n][n] ; //邻接矩阵,记录点的连通性及权重
    Set<Integer> Vnew = new HashSet<Integer>() ;//取得的新点

    public void init() {
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

    public void prim() {
        Vnew.add(0) ;
        while(Vnew.size() < n) {
            Edge edge = new Edge(0,0,Integer.MAX_VALUE) ;
            for (int v: Vnew) {
                for (int i=0;i<n;i++) {
                    if(edgs[v][i] != 0 && !Vnew.contains(i)) {
                        if (edgs[v][i] < edge.getW() ) {
                            edge.setU(v);
                            edge.setV(i);
                            edge.setW(edgs[v][i]);
                        }
                    }
                }
            }
            Vnew.add(edge.getV()) ;
            System.out.println("edge:" + edge.getU() + " " + edge.getV() + " " +edge.getW());

        }
    }

    public static void main(String[] args) {
        Prim prim = new Prim() ;
        prim.init();
        prim.prim();
    }

    class Edge implements Comparator<Kruskal.Edge> {
        int u;
        int v;
        int w;

        public int compare(Kruskal.Edge o1, Kruskal.Edge o2) {
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
}
