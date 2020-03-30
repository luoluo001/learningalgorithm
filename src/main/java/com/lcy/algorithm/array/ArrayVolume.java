package com.lcy.algorithm.array;

/**
 * Created by：luo
 * date: 2020/2/28.
 * desc：给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 说明：你不能倾斜容器，且 n 的值至少为 2。
 面积为 S(i,j) = (j-i) * min(h[i],h[j])  用两个指针哪边高度低哪边往中间靠（只有这样才能够有可能面积比之前的大）
 */
public class ArrayVolume {
    int[] height = new int[]{1,8,6,2,5,4,8,3,7};
    public int calcuResult(){
        int res = 0,i = 0,j = height.length -1;
        int tem ;
        while (i<j){
            tem =  (j-i) * Math.min(height[i],height[j]);
            if(tem>res){
                res = tem;
            }
            if(height[i]>height[j]){
                j--;
            }else {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayVolume av = new ArrayVolume();
        System.out.println(av.calcuResult());
    }
}
