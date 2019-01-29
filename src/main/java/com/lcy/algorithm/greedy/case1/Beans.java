package com.lcy.algorithm.greedy.case1;

/**
 * Created by： luochengyue
 * date: 2019/1/15.
 * desc：豆子的类
 * @version:
 */
public class Beans implements Comparable<Beans> {

    private String name;
    private Integer weight;
    private Double totalVal;
    private Double unitPrice;
    @Override
    public int compareTo(Beans o) {
        //使用优先级队列 默认小顶堆 插入数据的排序为O(nlogn)
        if(o.unitPrice==this.unitPrice){
            return 0;
        }else if(unitPrice>o.unitPrice){
            return -1;
        }else{
            return 1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
        this.totalVal = unitPrice*weight;
    }

    public Double getTotalVal() {
        return totalVal;
    }

    public Beans(String name, Integer weight, Double totalVal) {
        this.name = name;
        this.weight = weight;
        this.totalVal = totalVal;
        this.unitPrice = totalVal/weight;
    }
}
