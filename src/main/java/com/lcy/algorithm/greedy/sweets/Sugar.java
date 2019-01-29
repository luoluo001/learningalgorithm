package com.lcy.algorithm.greedy.sweets;

/**
 * Created by： luochengyue
 * date: 2019/1/15.
 * desc：
 *
 * @version:
 */
public class Sugar implements Comparable<Sugar> {

    public Sugar(Integer num, Integer size) {
        this.num = num;
        this.size = size;
    }

    public Sugar(Integer size) {
        this.size = size;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * 编号
     */
    private Integer num;
    /**
     * 大小
     */
    private Integer size;


    @Override
    public int compareTo(Sugar o) {
        if(size==o.size){
            return 0;
        }else if (size>o.size){
            return 1;
        }else{
            return -1;
        }
    }
}
