package com.lcy.algorithm.compare;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by： luochengyue
 * date: 2019/1/2.
 * desc：
 * @version:
 */
public class ComparebleTest implements Comparable<ComparebleTest>{

    private Integer num;
    public ComparebleTest(Integer num){
        this.num = num;
    }
    @Override
    public int compareTo(ComparebleTest o) {
        if(this.num==o.num){
            return 0;
        }else if(this.num>o.num){
            return -1;
        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "ComparebleTest{" +
                "num=" + num +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<ComparebleTest> list = new ArrayList();
        list.add(new ComparebleTest(1));
        list.add(new ComparebleTest(2));
//        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);
        System.out.println(list.get(0).compareTo(list.get(1)));
        Queue queue = new LinkedList();
    }
}
