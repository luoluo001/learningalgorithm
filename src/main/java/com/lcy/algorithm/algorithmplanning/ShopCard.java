package com.lcy.algorithm.algorithmplanning;

/**
 * Created by： luochengyue
 * date: 2019/1/23.
 * desc：购物车
 * @version:
 */
public class ShopCard {
    /**
     *
     * @param values  商品对应的价格
     * @param n     可购买的商品数量
     * @param mv 满减的额度
     */
    public void algorithm(int[] values,int n,int mv){
        boolean[][] state = new boolean[n][5*mv+1];
        state[0][0] = true;
        state[0][values[0]] = true;
        for(int i =1;i<n;i++){
            //第i个商品不购买
            for(int j = 0;j<=mv*5;j++){
                if(state[i-1][j]){
                    state[i][j] = true;
                }
            }
            for(int j = 0;j<=mv*5-values[i];j++){
                if(state[i-1][j]){
                    state[i][j+values[i]]= true;
                }
            }
        }
        //获取大于等于200值中的最小值
        int j;
        for(j=mv;j<5*mv+1;j++){
            if(state[n-1][j]){
                System.out.println(j+"商品总价值");
                break;
            }
        }
        if(j==5*mv+1){return ;}//没有可行解
        //遍历出需要购买的商品合集
        for(int i=n-1;i>=1;i--){
            //如果state [i-1][j-values[i]]= true 表示下一阶段来至于上一阶段的
            if(j-values[i]>=0&&state[i-1][j-values[i]]){
                j-=values[i];
                System.out.println("第："+ i +"个商品,价格为"+values[i]+"购买");
            }
        }
        //如果大于0 说明第一个也得购买，因为i-1所以 for上面的i必须》=1否则索引越界
        if(j!=0){
            System.out.println("第："+ 0 +"个商品,价格为"+values[0]+"购买");
        }
    }

    public static void main(String[] args) {
        int[] values = {100,50,40,20,300};
        ShopCard sc = new ShopCard();
        sc.algorithm(values,values.length,200);
    }


}
