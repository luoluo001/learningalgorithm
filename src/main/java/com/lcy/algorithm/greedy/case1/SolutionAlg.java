package com.lcy.algorithm.greedy.case1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by： luochengyue
 * date: 2019/1/15.
 * desc：解决算法
 * @version:
 */
public class SolutionAlg {
    /**
     * 由于快排等数据结构需要自己构造 这里使用优先级队列其实是不合适的  这种结构比较适合TOPN
     * 因为快排排序依次就行了
     */
    private PriorityQueue<Beans> priorityQueue = new PriorityQueue<>();

    public void addBeans(Beans data){
        priorityQueue.add(data);
    }

    public List<Beans> solution(Integer limitWeight){
        int total = 0;
        List<Beans> strategy = new ArrayList<>();
        Beans beans = null;
        while (total<limitWeight){
            beans = priorityQueue.poll();
            /**
             * 需要判断小于 大于 或者等于三种策略
             */
            if(beans.getWeight()+total<limitWeight){
                strategy.add(beans);
                total += beans.getWeight();
            }else if(beans.getWeight()+total>limitWeight){
                beans.setWeight(limitWeight-total);
                total+=beans.getWeight();
                strategy.add(beans);
            }else{
                strategy.add(beans);
                total += beans.getWeight();
            }
        }
        return strategy;
    }

    public static void main(String[] args) {
        /**
         * 黄豆           100               100
           绿豆           30                90
           红豆           60                120
           黑豆           20                80
           青豆           50                75
         */
        SolutionAlg sa = new SolutionAlg();
        sa.addBeans(new Beans("黄豆",100,100d));
        sa.addBeans(new Beans("绿豆",30 ,90d));
        sa.addBeans(new Beans("红豆",60 ,120d));
        sa.addBeans(new Beans("黑豆",20 ,80d));
        sa.addBeans(new Beans("青豆",50 ,75d));
        List<Beans> list = sa.solution(100);
        list.forEach(e -> System.out.println(e.getName()+","+e.getWeight()+","+e.getTotalVal()));
    }
}
