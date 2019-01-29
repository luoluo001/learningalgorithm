package com.lcy.algorithm.string;

/**
 * Created by： luochengyue
 * date: 2018/12/4.
 * desc：串一般用的是数组类型，因为链表类型本身的结构决定了
 * 如果一个链表的数据太小了浪费空间，如果数据大了 计算效率比较低
 * @version:
 */
public class SimpleString {

    /**
     * @param s 父串
     * @param t 子串
     * @param pos 起始位置
     * @return
     */
    public static int index(String s,String t ,int pos){
        int i = pos;//父串所在位置
        int j =0;
        //都未超过串的长度则继续遍历
        while (i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                j++;
                i++;
            }else{
                //如果不相等回到起始位置的下一位
                i = i-j+1;
                //与第子串的第0位位置的字符开始做比较
                j= 0;
            }
        }
        //需要根据是否遍历完了 子串
        if(j==t.length()){
            //需要将位置减去长度
            return i - t.length();
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        String s = "abcabcdeg";
        String t = "ab";
        System.out.println(index(s,t,1));
        System.out.println(s.indexOf(t,1));
    }
}
