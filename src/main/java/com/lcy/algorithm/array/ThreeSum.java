package com.lcy.algorithm.array;

import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;

/**
 * Created by：luo
 * date: 2020/3/2.
 * desc：三数之和
 */
public class ThreeSum {

    public List<List<Integer>> sumThreeAllResult(int[] nums){
        //给定一个数组 我们可以对它进行快排 让数组有序

        //之后根据我们利用双指针 取一个值放中间，左右各取一个值 如果三者相加>0的话 则左+1 如果<0则右+1 如果满足了存数据左右各+1
        //同时如果左+1和左数据一致则再+1 因为要不同组合
       List<List<Integer>> outList = new ArrayList<>(3);
       Arrays.sort(nums);
       if(nums==null||nums.length<3||nums[0]>0){
           return outList;
       }
       List<Integer> interList =null;
       int l,r;
        for (int i = 0; i < nums.length; i++) {
           //num[i]==num[i-1]继续 这个数据不要
            l = i+1;//偏左的位置
            r = nums.length-1;
            if(nums[i]>0){//最左边大于0没必要继续
                return outList;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            //先决条件 l<r
            while (l<r){
                //左边的都或者等0就没必要循环了
                if(nums[l]+ nums[i] + nums[r]==0){
                    interList = new ArrayList<Integer>(3);
                    interList.add(nums[l]);
                    interList.add(nums[i]);
                    interList.add(nums[r]);
                    outList.add(interList);
                    while (l<r && nums[r] == nums[r-1]){
                        r--;
                    }
                    while (l<r && nums[l] == nums[l+1]){
                        l++;
                    }
                    l++;
                    r--;
                }else if (nums[l]+ nums[i] + nums[r]>0){
                    r--;
                }else{
                    l++;
                }

            }

        }
        return outList;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> outList = threeSum.sumThreeAllResult(new int[]{-2,0,1,1,2});
        outList.forEach(l -> {
            System.out.println();
            l.forEach( i ->{
                System.out.print(i+","); });
        });
    }
}
