package com.huayu.study.algorithmStudy;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * Created by zhaohuayu on 17/1/1.
 * 深度优先搜索方式获取图中连续的方块个数(为1标识方块,相邻的作为一个算)
 */
public class GraphSearch {

    int[][] mat ;
    int[][] vis ;

    public int getNum(int[][] mat) {
        int count = 0 ;
        this.mat = mat ;
        int height = this.mat.length ;
        int width = this.mat[0].length ;
        vis = new int[height][width];
        for (int y=0; y< height; y++) {
            for(int x=0; x< width;x++) {
                if (mat[x][y] == 0 || vis[x][y] == 1) {
                    continue;
                } else {
                    count++ ;
                    dfs(x, y) ;
                }
            }
        }
        return count ;
    }

    public void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= this.mat[0].length || y >= this.mat.length) {
            return ;
        }
        if (mat[x][y] == 0 || vis[x][y] == 1) {
            return ;
        }
        vis[x][y] = 1 ;
        dfs(x+1, y) ;
        dfs(x+1, y-1);
        dfs(x,y-1) ;
        dfs(x-1,y-1) ;
        dfs(x-1,y);
        dfs(x-1,y+1);
        dfs(x,y+1) ;
        dfs(x+1,y+1) ;

    }

    public static void main(String[] args) {
        int[][] mat = new int[][] {
                {1,0,0,1,0,0},
                {0,0,1,0,1,0},
                {0,0,0,0,0,0},
                {1,1,0,0,1,0},
                {1,1,1,0,0,0},
                {0,1,0,1,0,0}
        } ;
        System.out.println(new GraphSearch().getNum(mat));
    }
}
