package com.lcy.algorithm.greedy.sweets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by： luochengyue
 * date: 2019/1/15.
 * desc：分糖果案例首先需要初始化糖果和孩子的列表
 * @version:
 */
public class Solution {
    /**
     * 分糖果案例的实施步骤
     * 1.首先构造包含孩子 和糖果的两个集合
     * 2.通过快排排序孩子和糖果
     * 3.将孩子抽取出最小的m个数据分配糖果
     * 4.每个孩子获取对应的苹果，每个孩子获取的都是第一个大于该大小的苹果
     * 5.输出打印
     * @param args
     */
    public static void main(String[] args) {
        List<Children> childrens = initChild();
        List<Sugar> sugars = initSugar();
        greedyAlg(childrens,sugars);
    }

    /**
     * 初始化糖果
     * @return
     */
    private static List<Sugar> initSugar() {
        List<Sugar> sugars = new ArrayList<>();
        sugars.add(new Sugar(1,7));
        sugars.add(new Sugar(2,3));
        sugars.add(new Sugar(3,2));
        sugars.add(new Sugar(4,5));
        sugars.add(new Sugar(5,6));
        return sugars;
    }

    /**
     * 初始化孩子
     * @return
     */
    private static List<Children> initChild() {
        List<Children> childrens = new ArrayList<>();
        childrens.add(new Children("a",10));
        childrens.add(new Children("b",3));
        childrens.add(new Children("c",6));
        childrens.add(new Children("d",8));
        childrens.add(new Children("e",6));
        childrens.add(new Children("f",5));
        childrens.add(new Children("g",9));
        return childrens;
    }


    public static void greedyAlg(List<Children> children,List<Sugar> sugars){
        QSort qSort = new QSort<>();
        //对孩子进行需求大小排序
        qSort.quickSort(children,0,children.size()-1);
        //对糖果进行需求大小排序
        qSort.quickSort(sugars,0,sugars.size()-1);
        children.forEach(e-> System.out.print(e.getReqSize()+","));
        System.out.println("==========");
        sugars.forEach(e-> System.out.print(e.getSize()+","));
        //取前m位需求小的孩子发糖果
        children = children.subList(0,sugars.size());
        System.out.println("========");
        children.forEach(e-> System.out.print(e.getReqSize()+","));

        //通过二分查找法，查找大于等于需求值的苹果 取出打印展示下结果
        BSearch bSearch = new BSearch();
        int ind=0;
        Children child = null;
        Sugar sugar = null;
        for (int i =0;i<children.size();i++){
            child = children.get(i);
            ind = bSearch.searchTransform2(sugars, new Sugar(children.get(i).getReqSize()));
            if(ind>-1){
                sugar = sugars.remove(ind);
            }else{
                //这里其实无所谓了 删除掉最小的 剩下的糖果比较大
                sugar = sugars.remove(0);
            }
            //打印孩子及对应分到的糖果的相关信息
            System.out.println(child.getName()+","+child.getReqSize()+"："+ sugar.getNum()+","+sugar.getSize());
        }


    }
}
