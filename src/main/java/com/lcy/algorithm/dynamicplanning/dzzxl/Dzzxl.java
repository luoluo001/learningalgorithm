package com.lcy.algorithm.dynamicplanning.dzzxl;

/**
 * Created by： luochengyue
 * date: 2019/2/18.
 * desc：递增子序列的求解
 * @version:
 */
public class Dzzxl {


    //求解步骤：
    // 1.这个问题需要获取每个数组中的每个数据，判断当前数据所在位置与之前记录的那个所在位置的数据进行对比，
    // （需要一个数据记录来源），如果比之大则位置i=j,j=j+1 数据量+1，如果没有比之大则i不变，
    // j=j+1，数据量还是不变。最后递归出一个数据量最大的值就是最长子序列了。
    //这个问题就可以属于多阶段决策模型 ，因为涉及到的数组中的每个数据都需要比较做决策
    int[] array = {};
    public void backtrack(){

    }
}

