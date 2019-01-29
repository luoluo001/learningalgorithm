package com.lcy.algorithm.graph;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by： luochengyue
 * date: 2019/1/3.
 * desc：邻接表形式的图 无向图 这种结构如果是针对具体数据的话就需要以id作为数组下标  这种数据结构
 * @version:
 */
public class GraphAdjacencyList {
    int v;//定点个数
    private LinkedList<Integer> adj[];//邻接表结构
    public GraphAdjacencyList(int v){
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i =0;i<adj.length;i++){
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 由于是无向图两个顶点之间需要互相构建关系
     * @param a 顶点a
     * @param b 顶点b
     */
    public void insert(int a,int b){
        adj[a].add(b);
        adj[b].add(a);
    }

    /**
     * 这里默认的搜索的s和t不是一个数据
     * 广度优先搜索算法
     * @param s 开始点
     * @param t 结束点
     */
    public void bfs(int s,int t){
        if(s==t){
            return;
        }
        //构建一个逐层搜索的需要的数据结构队列 从第一层开始
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        //这里是是否拜访过的标识，因为搜索的时候会有边是连接到上一层的如果已经访问过则不再访问
        boolean[] isVisit = new boolean[v];
        isVisit[s] = true;
        //prev是作为访问路径记录的一个数组，用于记录是当前数据是从哪里访问过来的
        int[] prev = new int[v];
        for(int p :prev){
            p = -1;
        }
        //只要队列中不为空则说明还有层木有访问
        while (!queue.isEmpty()){
            int w = queue.poll();
            for (int i =0;i<adj[w].size();i++){
                Integer q = adj[w].get(i);
                //如果木有访问过
                if(!isVisit[q]){
                    prev[q] = w;
                    //如果已搜索到路径了了则没有必要继续按层搜索了
                    if(q==t){
                        print(prev,s,t);
                        return;
                    }
                    isVisit[q] = true;
                    //这里是记录当前层的下一层的队列
                    queue.add(q);
                }
            }
        }

    }

    /**
     * 深度优先搜索：
     * 深度优先搜索都是从某个起点出发，之后不会逐层递进而是一条道走到黑，如果木有找到出口就往回走，
     * 知道所有的岔口都走完看是否有找到出口
     * @param s 深度优先
     * @param t 搜索结束节点
     */
    private boolean isFound = false;
    public void dfs(int s ,int t){
        //本身就相等就木有必要再找了
        if(s==t){
            return ;
        }
        //也是需要记录路径
        int[] prev = new int[v];
        for(int i =0;i<prev.length;i++){
            //默认都是-1
            prev[i] = -1;
        }
        //需要记录是否拜访过的
        boolean[] visit = new boolean[v];
        visit[s] = true;
        bfsReal(s, prev, visit,t);
        if(isFound){
            print(prev,s,t);
        }

    }


    /**
     * 这里默认的搜索的s和t不是一个数据
     * 广度优先搜索算法
     * @param s 开始点
     * @param edge 几度
     */
    public void bfsEdge(int edge,int s){
        if(edge<=0){
            return;
        }
        //prev是作为访问路径记录的一个数组，用于记录是当前数据是从哪里访问过来的
        int[] prev = new int[v];
        for(int i =0;i<prev.length;i++){
            //默认都是-1
            prev[i] = -1;
        }
        //构建一个逐层搜索的需要的数据结构队列 从第一层开始
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        //这里是是否拜访过的标识，因为搜索的时候会有边是连接到上一层的如果已经访问过则不再访问
        boolean[] isVisit = new boolean[v];
        isVisit[s] = true;
        //prev是作为访问路径记录的一个数组，用于记录是当前数据是从哪里访问过来的
        //读书
        int j = 0;
        //存储几度列表
        LinkedList<Integer> edgeList[] = new LinkedList[edge];
        for (int e =0;e<edge;e++){
            edgeList[e] = new LinkedList<>();
        }
        //只要队列中不为空则说明还有层木有访问
        while (!queue.isEmpty()){
            int w = queue.poll();
            //获取第几度 如果首次是-1开始，那么下一层第一度就应该放到 0索引的数据链表中 如果是索引=度-1
            j = getEdge(prev,s,w);
            if(j==edge-1){
                break;
            }
            for (int i =0;i<adj[w].size();i++){
                Integer q = adj[w].get(i);
                //如果木有访问过
                if(!isVisit[q]){
                    //如果层数已抵达则停止
                    isVisit[q] = true;
                    //这里是记录当前层的下一层的队列
                    prev[q] = w;
                    //由于
                    edgeList[j+1].add(q);
                    queue.add(q);
                }
            }
        }
        printEdgeList(edgeList);
    }

    private void printEdgeList(LinkedList<Integer>[] edgeList) {
        for (int j = 0;j<edgeList.length;j++){
            System.out.print("第"+(j+1)+"度:");
            if(edgeList[j].size()>0){
                edgeList[j].forEach(e-> System.out.print(e+","));
            }
            System.out.println("==========");
        }
    }

    /**
     * 深度优先真正的代码 这部分需要考虑到一个判断结束的标志
     * @param s
     * @param prev
     * @param visit
     * @param t
     */
    private void bfsReal(int s, int[] prev, boolean[] visit,int t) {
        for (int i =0;i<adj[s].size();i++){
            if(isFound){
                return ;
            }
            Integer q = adj[s].get(i);
            //看是否拜访过 如果木有则往这条岔口的下一步走
            if(!visit[q]){
                //记录来时的路 回溯的时候这跳道就不再走第二遍
                prev[q] = s;
                if(q==t){
                    //记录是否发现了，如果发现了则不再往下搜索
                    isFound = true;
                    break;
                }
                visit[q] = true;
                //递归往下走
                bfsReal(q,prev,visit,t);
            }
        }
    }

    /**
     * 这里是打印来时路径
     * @param prev
     * @param s
     * @param t
     */
    private void print(int[] prev, int s, int t) {
        if(prev.length!=0&&s!=t){
            print(prev,s,prev[t]);
        }
        System.out.print(t+",");
    }


    /**
     * 这里是打印来时路径
     * @param prev
     * @param s
     * @param t
     */
    private int getEdge(int[] prev, int s,int t) {
        int j = 0;
        while (prev[t]!=-1&&prev[t]!=s){
            j++;
            t = prev[t];
        }
        //说明木有度 是刚开始的位置
        if(prev[t]==-1){
            return -1;
        }
        return j;
    }

    public static void main(String[] args) {
        GraphAdjacencyList list = new GraphAdjacencyList(8);
        list.insert(0,1);
        list.insert(1,2);
        list.insert(0,3);
        list.insert(3,4);
        list.insert(2,5);
        list.insert(4,5);
        list.insert(4,6);
        list.insert(5,7);
//        list.bfs(0,5);
        list.bfsEdge(4,0);
//        list.dfs(0,5);
    }
}
