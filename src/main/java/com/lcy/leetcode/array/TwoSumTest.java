package com.lcy.leetcode.array;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by：luo
 * date: 2020/3/30.
 * desc：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
 * 并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class TwoSumTest {
    /**
     * 第一种暴力解决 遍历数组去找另一个配对的数据 最好为O(1) 最坏为O(n2)=平均
     * 第二种方法，Map记录对应数值去映射索引 我们即可用一次遍历找出数据 通过map[target-current] !=null即可判定找到数据了
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> valud2Ind = new HashMap<>();
        Integer ind = null;
        for (int i = 0; i < nums.length; i++) {
            ind = valud2Ind.get(target - nums[i]);
            if (ind!=null) {
                return new int[]{i,ind};
            }else{
                valud2Ind.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        TwoSumTest tst = new TwoSumTest();
        int[] result = tst.twoSum(nums, 22);
        if(result!=null){
            for (int i :result) {
                System.out.println(i);
            }
        }
    }
}
