package com.lcy.algorithm.backtrack;

/**
 * Created by： luochengyue
 * date: 2019/1/18.
 * desc：回溯算法之8皇后
 * @version:
 */
public class EightQueen {
    /**
     * 主入口 用于测试
     * @param args
     */
    public static void main(String[] args) {
        EightQueen eq = new EightQueen();
        eq.eQueenAlg(0);
    }
    private int[] result = new int[8];
    /**
     * 8皇后算法  枚举所有问题的求解方式，分每个阶段，每个阶段都有对应的岔口，如果这个岔口无法满足条件则选择另一个岔口
     * @param row 行数
     */
    public void eQueenAlg(int row){
        /**
         * 说明8行已经将数据放置完毕输出 终止条件
         */
        if(row==8){
            print(result);
            return;
        }
        //每个阶段的岔口都有8个
        for(int cloumn = 0;cloumn<8;++cloumn){
            //如果这个岔口可以走的通则往下走
            if(isOkCondition(row,cloumn)){
                result[row] = cloumn;
                //往下走
                eQueenAlg(row+1);//主要错误在这里 因为row++将row+1了 并且复制给row造成没法重新选择
//                eQueenAlg(row++);
            }
        }
    }
    /**
     * 如果满足条件则往下走 用于条件判断
     * @param row
     * @return
     */
    private boolean isOkCondition(int row,int column) {
        //左上 右上是否在对角线上判定
        int leftUp = column -1,rightUp = column+1;
        //逐层递减判断是否存在在同一列或者在对角线上的数据
        for(int i = row-1;i>=0;--i){
            if(result[i]==column){
                return false;
            }
            if(leftUp>=0){
                if(result[i]==leftUp){
                    return false;
                }
            }
            if(rightUp<8){
                if(result[i]==rightUp){
                    return false;
                }
            }

            leftUp--;
            rightUp++;
        }
        return true;
    }

    private void print(int[] result) {
        System.out.println();
        for (int i =0;i<result.length;i++){
            for(int j =0;j<8;j++){
                if(j==result[i]){
                    System.out.print(result[i]+" ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
