package com.lcy.algorithm.dynamicplanning;

/**
 * Created by： luochengyue
 * date: 2019/1/29.
 * desc：硬币找零
 * @version:
 */
public class CoinChange {
    int minNum = Integer.MAX_VALUE;
    int limitv = 9;

    /**
     * 通过回溯算法完成枚举搜索
     * @param va valueArray 钱币的类型
     * @param money 钱数
     * @param num  找币数量
     */
    public void minValueBt(int[] va,int money,int num){
        //结束
        if(money==limitv){
              if(num<minNum){
                  minNum = num;
              }
              return ;
        }
        //这里是错的我们不需要记录i是哪个阶段 而是以num来记录哪个阶段就行了，我们的决策不是决策是否放入，而是决策放入哪个硬币
        //放入第0个
        for(int i =0 ;i<va.length;i++){
            if(money+va[i]<=limitv){
                minValueBt(va,money+va[i],num+1);
            }
        }
    }

    /**
     * 通过动态规划完成数据查找钱币数量
     * 通过递归树发现 是存在重复状态的，总共有n步，我们将n步= money/min(va)
     * 每一步的状态都有与三总选择，如果出现一致状态则合并
     * @param va
     * @param money
     * @return
     */
    public int minValueByDp(int[] va,int money){
        //边界条件
        if(money<=0){
            return -1;
        }
        //最小的步骤
        boolean[][] state = new boolean[money/va[0]][money+1];
        //初始化第一步的状态 后续状态需要根据这个状态递推
        for(int i=0;i<va.length;i++){
            state[0][va[i]] = true;
        }
        int minNum =-1;
        for(int i =1;i<money/va[0];i++){
            for(int j = 1;j<=money;j++){
                //每个状态的在于state[i-1][j] 如果为true 再用于递推下一个状态
                if(state[i-1][j]){
                    for(int m = 0;m <va.length;m++){
                        if(j+va[m]<=money){
                            state[i][j+va[m]]= state[i-1][j];
                        }
                    }
                }
            }
            if(state[i][money]){
                minNum = i+1;
                break;
            }
        }
        if(minNum==-1){
            //没找到
            return -1;
        }
        //反向查找是怎么投币的
        int befMoney = money;
        for(int i = minNum-1;i>0;i--){
            for(int j = 0;j<va.length;j++){
                if(befMoney-va[j]>=0&&state[i-1][befMoney-va[j]]){
                    System.out.println("投掷了硬币"+va[j]);
                    befMoney = befMoney- va[j];
                    break;
                }
            }
        }
        if(befMoney>0){
            System.out.println("投掷了硬币"+befMoney);
        }
        return minNum;

    }

    public static void main(String[] args) {
        int[] va = {1,3,5};
        CoinChange cc = new CoinChange();
        System.out.println(cc.minValueByDp(va,9));
    }
}
