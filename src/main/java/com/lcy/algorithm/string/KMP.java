package com.lcy.algorithm.string;

/**
 * Created by： luochengyue
 * date: 2019/1/10.
 * desc：kmp算法
 * @version:
 */
public class KMP {
    /**
     * kmp算法实现
     * @param a 主串
     * @param mc 模式串
     * @param n 主串长度
     * @param m 模式串长度
     * @return
     */
    public int searchMatch(char[] a,char[] mc,int n ,int m){
        /**
         * 边界条件
         */
        if(a==null||mc==null||n<1||m<1||n<m){
            return -1;
        }
        //假设我们的next数组的求取方法已经实现的情况下
        int[] next = generateNext(mc,m);
        /**
         * 这里我们需要开始从头开始匹配 如果模式串都匹配完了我们就直接将数据返回
         * 我们每次开始前需要判断下上次匹配了多少个字符（好前缀） 通过好前缀获取从哪个下标开始匹配
         */
        int j = 0;
        for(int i = 0;i<n ;i++){
            //碰到坏字符了 我们就查下好前缀对应的最长匹配子串 a[i]这里如果≠mc[j]代表碰到坏字符了
            while (j>0&&mc[j]!=a[i]){
                j = next[j-1]+1;//找到对应的好前缀 最长可匹配子串下标 +1 = k （k代表长度的意思）
            }
            //如果相等就开始匹配下一个字符
            if(a[i]==mc[j]){
                j++;
            }
            if(j==m){
                //模式串全部匹配完了将对应的下标返回
                return i-m +1;
            }
        }
        //如果木有匹配上则返回-1 表示木有匹配上
        return -1;
    }

    private int[] generateNext(char[] mc, int m) {
        /**
         * 生成后缀子串
         */
        int[] next = new int[m];
        //默认next[0]子串为-1 因为都木有前后缀子串所以下标为0 最长匹配前缀子串为-1
        next[0] = -1;
        //我们从第一个开始 分两种情况求取最长子串 只要next数组的值大于-1就需要判断下一个next[k]是否=next[i]
        //如果相等则放开递归 否则找次长子串直到能匹配next[k]=next[i]
        int k = -1;
        for (int i =1;i<m;i++){
            //k就是 mc[i-1]的最长子串 如果下一个字符也相等则在后面进行+1操作，如果下一个字符不能匹配则求取 最长子串的最长子串
            while (k>-1&&mc[k+1]!=mc[i]){
                k = next[k];//获取次长子串
            }
            //如果相等则说明匹配了k的下标就往后递推 由于k是从-1开始的 所以每次都需要+1判断是否跟后面的最后一个字符是否相等
            //如果相等则 k++就是索引的下标
            if(mc[k+1]==mc[i]){
                k++;
            }
            //赋值 长度为i的好后缀 最长匹配前缀子串的下标为k
            next[i] = k;
        }
        return next;
    }


    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        BoyerMoore bm = new BoyerMoore();
        String a ="bceabceab";
        String b = "abc";
        System.out.println(bm.searchMatch(a.toCharArray(),b.toCharArray(),a.length(),b.length()));

    }
}
