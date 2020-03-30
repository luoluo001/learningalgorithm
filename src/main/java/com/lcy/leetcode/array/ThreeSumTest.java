package com.lcy.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by：luo
 * date: 2020/3/30.
 * desc：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。注意：答案中不可以包含重复的三元组。
 */
public class ThreeSumTest {
    /**
     * 第一种 暴力解题 三层遍历 O(n3)
     * 第二种：数组排序 排序完了之后 采用双指针解法 循环数组 令左侧=L+1 右侧R=n-1 本身是i做循环找其他两个数相加=0 其他另个数通过双指针就不用三层遍历了
     * 跳出或者判定条件 如果出现nums[i] >0则没有必要再继续 如果出现nums[i]==nums[i-1]可继续
     * 指针移动 当L<R时  内部循环 根据条件三者相加=0 添加到集合里  因为不能同元素所以如果如果nums[R-1] = nums[R-1]则继续R-- L反之
     * 当 三者相加>0 R--
     * 当三者小于0 L++
     * 本体的难点在于找出我们要的双指针 根据一个数找另外两个数 这两个数可以通过指针对应的数据找到 而只有有了顺序后我们才好针对指针做移动
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>(3);
        if(nums==null|| nums.length<3){
            return list;
        }
        //快排 O(logn)
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0) {
                return list;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int L = i+1;
            int R = nums.length-1;
            while (L<R){
                if(nums[i]+nums[R]+ nums[L]==0){
                    list.add(Arrays.asList(new Integer[]{nums[i],nums[L],nums[R]}));
                    while (L<R && nums[R-1]==nums[R]){
                        R--;
                    }
                    R--;
                    while (L<R && nums[L+1]==nums[L]){
                        L++;
                    }
                    L++;
                }else if (nums[i]+nums[R]+ nums[L]<0){
                    L++;
                }else{
                    R--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ThreeSumTest tst = new ThreeSumTest();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(tst.threeSum(nums));
    }
}
