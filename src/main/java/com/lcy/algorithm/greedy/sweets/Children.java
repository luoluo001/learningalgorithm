package com.lcy.algorithm.greedy.sweets;

/**
 * Created by： luochengyue
 * date: 2019/1/15.
 * desc：孩子
 * @version:
 */
public class Children implements Comparable<Children>{
    /**
     * 名字
     */
    private String name;
    /**
     * 需求大小
     */
    private Integer reqSize;

    public Children(String name, Integer reqSize) {
        this.name = name;
        this.reqSize = reqSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReqSize() {
        return reqSize;
    }

    public void setReqSize(Integer reqSize) {
        this.reqSize = reqSize;
    }

    @Override
    public int compareTo(Children o) {
        if(reqSize==o.reqSize){
            return 0;
        }else if (reqSize>o.reqSize){
            return 1;
        }else{
            return -1;
        }
    }
}
