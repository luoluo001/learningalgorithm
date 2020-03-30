package com.lcy.algorithm.dynamicplanning.progressincrease;

import com.lcy.algorithm.structure.linetable.LinkedList;
import com.lcy.algorithm.structure.linetable.List;

import java.util.Arrays;

/**
 * Created by： luochengyue
 * date: 2019/2/18.
 * desc：回溯算法获取递增数列的最长长度
 * @version:
 */
public class BTIncrease {

    private int[] originArray= {2,9,3,6,5,1, 7};
    private Integer maxInc = Integer.MIN_VALUE;
    private int[] increaseA = new int[originArray.length];
    private int[] increaseReal;
    public void btIncreaseReal(int i ,int j,int mInc){
        //边界条件
        if(i==originArray.length||j==originArray.length){
            if(mInc>maxInc){
                maxInc = mInc;
                increaseReal = Arrays.copyOfRange(increaseA,0,maxInc);
            }
            return ;
        }

        if(originArray[j]>originArray[i]){
            //插入
            increaseA[mInc] = originArray[j];
            btIncreaseReal(j,j+1,mInc+1);
            //不插入
            increaseA[mInc] = -1;
            btIncreaseReal(i,j+1,mInc);
        }else{
            //肯定不能插入
            increaseA[mInc] = -1;
            btIncreaseReal(i,j+1,mInc);
        }
    }

    public void btIncrease(){
        for(int i =0;i<originArray.length;i++){
            for(int j =i+1;j<originArray.length;j++){
                increaseA[0] = originArray[i];
                btIncreaseReal(i,j,1);
            }
        }
    }
    public static void main(String[] args) {
        BTIncrease btIncrease = new BTIncrease();
        btIncrease.btIncrease();
        System.out.println(btIncrease.maxInc);
        for(int i = 0;i<btIncrease.maxInc;i++){
            System.out.print(btIncrease.increaseReal[i]);
        }
    }


//    public int lengthOfLIS(vector nums)
    {
    /*const int size = nums.size();
        if (size < 1)
            return 0;
        int max_length = 1;
        // lengthOfLISEndAtI[i]存储了：以nums[i]结尾的LIS的长度。
        vector<int> lengthOfLISEndAtI(size, 1);

        for (int i = 1; i < size; i++)
        {
            // 当前扫描到的元素是nums[i]
            for (int j = 0; j < i; j++)
            {
                // 找出那些在nums[i]左边且比nums[i]小的元素
                if (nums[j] >= nums[i])
                    continue;
                // 以nums[j]结尾的LIS与nums[i]组合，是否能产生更长的LIS（以nums[i]结尾）
                if (lengthOfLISEndAtI[i] < lengthOfLISEndAtI[j] + 1)
                {
                    lengthOfLISEndAtI[i] = lengthOfLISEndAtI[j] + 1;
                }
            }
            // 以哪个元素结尾的LIS最长
            if (max_length < lengthOfLISEndAtI[i])
            {
                max_length = lengthOfLISEndAtI[i];
            }
        }*/
//        return 0;
    }

}
