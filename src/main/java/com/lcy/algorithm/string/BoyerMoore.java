package com.lcy.algorithm.string;

/**
 * Created by： luochengyue
 * date: 2019/1/9.
 * desc：NM算法
 * @version:
 */
public class BoyerMoore {
    /**
     * @param bc 坏字符hash数组
     * @param m  模式串
     */
    private static final int SIZE= 256;
    /**
     * 首先我们来看下坏字符规则：
     * 我们需要用一个类hash结构存储字符集中模式串的对应的索引下标位置 让坏字符的查找效率变为O(1)
     */
    private void generateBC(int[] bc,char[] m){
        //先设置默认值为-1 就是在模式串中木有下标
        for (int i = 0 ;i <SIZE;i++){
            bc[i] = -1;
        }
        for(int i= 0 ;i<m.length;i++){
            bc[(int) m[i]] = i;
        }
    }

    /**
     * 查找匹配按坏字符规则
     * @param a 主串字符
     * @param mc 模式串字符
     * @param n 主串长度
     * @param m 模式串长度
     * @return
     */
    public int searchMatchBC(char[] a,char[] mc,int n ,int m){
        /**
         * 便捷条件
         */
        if(a==null||mc==null||n<1||m<1||n<m){
            return -1;
        }
        //生成模式串hash结构
        int[] bc = new int[256];
        generateBC(bc,mc);
        int i =0;
        //主要i的长度木有超过n-m 就继续匹配
        while (i<n-m){
            int j = m-1;
            while (j>=0&&a[i+j]==mc[j]){
                j--;
            }
            //已经匹配到
            if(j<0){
                return i;
            }
            //往后滑动
            i = j-bc[(int)mc[j]]+i;
        }
        //说明没有匹配上
        return -1;
    }


    /**
     * 查找匹配全局的方式
     * @param a 主串字符
     * @param mc 模式串字符
     * @param n 主串长度
     * @param m 模式串长度
     * @return
     */
    public int searchMatch(char[] a,char[] mc,int n ,int m){
        /**
         * 便捷条件
         */
        if(a==null||mc==null||n<1||m<1||n<m){
            return -1;
        }
        //生成模式串hash结构
        int[] bc = new int[256];
        generateBC(bc,mc);
        /**
         * 好后缀规则需要查找匹配模式串 及模式串前缀子串与好后缀后缀子串计算位移需要的数组
         */
        int[] suffix = new int[m];//好后缀在模式串中的位置
        boolean[] preffix = new boolean[m];//模式串前缀子串与好后缀的后缀子串是否匹配
        gengerateGC(suffix,preffix,mc,m);
        int i =0;
        //主要i的长度木有超过n-m 就继续匹配
        int x,y;//x代表的是坏字符规则获取到的移动位置 y代表是好后缀匹配到的移动位置
        while (i<=n-m){
            int j = m-1;
            while (j>=0&&a[i+j]==mc[j]){
                j--;
            }
            //已经匹配到
            if(j<0){
                return i;
            }
            //往后滑动
            x = j-bc[(int)a[j+i]];
            y = 0;
            //如果j<m-1 则表示出现好后缀了需要用好后缀的形式计算 ，如果只有好后缀的话
            if(j<m-1){
                y = getMoveGC(m, suffix, preffix, j);
            }
            i = i+ Math.max(x,y);
        }
        //说明没有匹配上
        return -1;
    }

    /**
     * 获取移动部署
     * @param m
     * @param suffix
     * @param preffix
     * @param j
     * @return
     */
    private int getMoveGC(int m, int[] suffix, boolean[] preffix, int j) {
        int index;
        //获取当前好后缀的长度
        int k = m - 1 -j;
        index = suffix[k];//获取对应索引值
        if(index!=-1){return j - index+1;}//因为好后缀在坏字符的后一位 所以要+1
        //上方是好后缀无法再模式串中匹配到，那么我们就从好后缀的后缀子串中查找能匹配前缀子串的最长后缀子串
        //k=m-r就是子串长度 r是从坏字符+2到m-1，如果有能匹配上的话就需要移动r位
        for( int r = j + 2;r<m-1;r++){
            if(preffix[m-r]){
               return r;
            }
        }
        //如果都匹配不上则就直接移动数组长度位
        return m;
    }


    /**
     * 好后缀模式串预处理
     * 生成好后缀需要的两个数组信息
     * 首先第一步对suffix和preffix进行默认赋值-1 和false代表木有位置并与前缀子串不匹配
     * 之后计算suffix和preffix
     * @param suffix
     * @param preffix
     * @param mc
     */
    private void gengerateGC(int[] suffix, boolean[] preffix, char[] mc,int m) {
        for(int i =0;i<m;i++){
            suffix[i] = -1;
            preffix[i] = false;
        }
        /**
         * i属于递增 主要是我们需要找到与好后缀匹配的 最靠后的索引下标 m-1开始是因为前缀至少要肯定是在最后一个字符之前
         */
        for(int i = 0;i<m-1;i++){
           int j = i;
           int k = 0;
           //当能匹配的话就往前递推 直到字符串不能匹配为止
           while (j>=0&&mc[j]==mc[m-1-k]){
               k++;
               //记录好后缀的匹配下标 后面的会覆盖前面的 所以最后记录的是好后缀最后面的索引位置
               suffix[k] = j;
               j--;
           }
           //说明与这个号后缀与模式串前缀子串相匹配
           if(j<0){
               preffix[k] = true;
           }
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        BoyerMoore bm = new BoyerMoore();
        String a ="abceabceab";
        String b = "ab";
        System.out.println(bm.searchMatch(a.toCharArray(),b.toCharArray(),a.length(),b.length()));

    }

}
