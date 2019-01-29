package com.lcy.algorithm.greedy.sweets;

import java.util.List;

/**
 * Created by： luochengyue
 * date: 2019/1/15.
 * desc：二分查找法的具体应用
 * @version:
 */
public class BSearch<T extends Comparable> {

    /**
     * 变形2 查找第一个大于等于给定值的元素  查找最后一个小于等于给定值的元素 跟这很像 自己想想啦
     * @param a
     * @param sv
     * @return
     */
    public int searchTransform2(List<T> a, T sv){
        if(a.size()<1){
            return -1;
        }
        int low = 0;
        int hight = a.size()-1;
        int mid = 0;
        while (low<=hight){
            mid = ((hight-low)>>1)+low;
            if(a.get(mid).compareTo(sv)>=0){
                //注意这里需要变形了
                //1.注意边界条件
                if(mid==0){
                    return mid;
                }else{
                    //说明前面还存在于当前要查找元素相同的值
                    if(a.get(mid-1).compareTo(sv)>=0){
                        hight = mid -1;
                    }else{
                        return mid;
                    }
                }
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
