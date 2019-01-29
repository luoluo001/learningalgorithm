package com.lcy.algorithm.structure.string;

/**
 * Created by： luochengyue
 * date: 2018/12/4.
 * desc：kml数组
 * @version:
 */
public class KmlString {
    /**
     * 获取kml算法的next数组
     * @param str
     * @return
     */
    public static int[] getNext(String str){
        int[] next = new int[str.length()];
        int i = 1;//字符串下标
        int j = 0;//表示最大匹配长度
        next[0] = 0;
        while (i<str.length()-1){
            //每次匹配上了都需要+1 包括对应的下标和最大前后缀前度
            if(str.charAt(i) == str.charAt(j)){//charAt j 前缀的单个字符  i为后缀的单个字符
                //相等的话设置next数组的值+1 同时串移到下一位再判断
                j++;
                next[i] = j;
                i++;
            }else{
                //如果不匹配的话则需要依据下面条件进行判断
                if(j>0){
                    j = next[j-1];//找一个子串看下是否 前后缀的字符一致
                }else{
                    i++;
                }
            }

        }
        return next;
    }



    /**
     * 获取kml算法的next数组
     * @param str
     * @return
     */
    public static int[] getNextNew(String str){
        int[] next = new int[str.length()];
        int i = 1;//字符串下标
        int j = 0;//表示最大匹配长度
        next[0] = 0;
        while (i<str.length()-1){
            //每次匹配上了都需要+1 包括对应的下标和最大前后缀前度
            if(str.charAt(i) == str.charAt(j)){//charAt j 前缀的单个字符  i为后缀的单个字符
                //相等的话设置next数组的值+1 同时串移到下一位再判断
                j++;
                if(str.charAt(i+1)!=str.charAt(j)){
                    next[i] = j;
                }else{
                    next[i] = next[j];
                }
                i++;
            }else{
                //如果不匹配的话则需要依据下面条件进行判断
                if(j>0){
                    j = next[j-1];//找一个子串看下是否 前后缀的字符一致
                }else{
                    i++;
                }
            }

        }
        return next;
    }
    /**
     * 第二种next方法 其实都是一样的
     * @param P
     * @param next
     */
    public static void makeNext(String P,int next[])
    {
        int q,k;//q:模版字符串下标；k:最大前后缀长度
        int m = P.length();//模版字符串长度
        next[0] = 0;//模版字符串的第一个字符的最大前后缀长度为0
        for (q = 1,k = 0; q < m; ++q)//for循环，从第二个字符开始，依次计算每一个字符对应的next值
        {
            while(k > 0 && P.charAt(q) != P.charAt(k))//递归的求出P[0]···P[q]的最大的相同的前后缀长度k
                k = next[k-1];          //获取p[0] p[k]的最大前缀子串，然后再判别是否p[j] = p[k] 如果相同
            if (P.charAt(q) == P.charAt(k))//如果相等，那么最大相同前后缀长度加1
            {
                k++;
            }
            next[q] = k;
        }
    }


    public static void main(String[] args) {
//        String str = "abcabx";
////        int[] next = getNext(str);
//        int[] next = new int[str.length()];
//        makeNext(str,next);
//        StringBuilder sb = new StringBuilder();
//        for (int i:
//             next) {
//            sb.append(i);
//        }
//        System.out.println(sb.toString());

        String s = "aaaabcd";
        String t = "aaaax";
        System.out.println(index(s,t,1));
        System.out.println(s.indexOf(t,1));

    }



    /**
     * @param s 父串
     * @param t 子串
     * @param pos 起始位置
     * @return
     */
    public static int index(String s,String t ,int pos){
        int i = pos;//父串所在位置
        int j =0;
        //获取部分匹配表
//        int[] next =new int[t.length()];
        int[] next = getNextNew(t);
        //都未超过串的长度则继续遍历
        while (i<s.length()&&j<t.length()){
            if(j==0||s.charAt(i)==t.charAt(j)){
                j++;
                i++;
            }else{
                //j值退回合适的位置 i值不回退
                j= next[j-1];
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


}
