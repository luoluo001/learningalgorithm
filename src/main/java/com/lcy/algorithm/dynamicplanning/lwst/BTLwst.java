package com.lcy.algorithm.dynamicplanning.lwst;

/**
 * Created by： luochengyue
 * date: 2019/2/18.
 * desc：回溯算法完成莱文斯坦的相关距离算法
 * @version:
 */
public class BTLwst {
    /**
     * 两个数组
     */
    char[] a = "mitcmu".toCharArray();
    char[] b = ",matcnu".toCharArray();
    int n = a.length;
    int m = b.length;
    private Integer minDist = Integer.MAX_VALUE;
    public void lwstBT(int i,int j,int dist){
        //边界条件
        if(i==n||j==m){
            if(i==n){
                dist += m-j;
            }
            if(j==m){
                dist+= n-i;
            }
            if(dist<minDist){
                minDist = dist;
            }
            return;
        }
        //判断两个数组当前字符是否一致
        /*
         *1.如果a[i]=b[j] 递归判断a[i+1]是否=b[j+1]
        2.如果不相同
        2.1.删除a[i]，递归比较a[i+1] b[j]
        2.2.删除b[j] 递归比较a[i] b[j+1]
        2.3.在a[i]前面添加一个与b[j],相同的字符 递归判断a[i] b[j+1]
        2.4.在b[j]前面添加一个与a[i]一致的字符，递归判断a[i+1],b[j]
        2.5.将a[i]替换成b[j]或者将b[j]替换成a[i]，递归判断a[i+1] b[j+1]
         */
        if(a[i]==b[j]){
            lwstBT(i+1,j+1,dist);
        }else{
            lwstBT(i+1,j,dist+1);
            lwstBT(i,j+1,dist+1);
            lwstBT(i+1,j+1,dist+1);
        }
    }

    public static void main(String[] args) {
        BTLwst btLwst = new BTLwst();
        btLwst.lwstBT(0,0,0);
        System.out.println(btLwst.minDist);
    }

}
