package com.lcy.algorithm.heap;

/**
 * Created by： luochengyue
 * date: 2018/12/29.
 * desc：堆结构，主要涉及建堆,插入，删除，及排序的操作
 * @version:
 */
public class Heap {
    /**
     * 数组 在初始化的时候需要做设置  创建的cap是偶数项 可以保证索引不会草除限制
     */
    private int[] array = null;
    private int cap;
    private int count;
    public Heap(int[] a){
        array = a;
        cap = a.length-1;
        count = 0;
    }

    /**
     * 初始化
     */
    public Heap(){
        cap = 20;
        array = new int[cap+1];
        count = 0;
    }

    public Heap(int[] array,int count){
        this.array = array;
        this.count = count;
        this.cap = array.length-1;
    }

    public void print(){
        if(count==0){return ;}
            for(int i = 1;i<=count;i++){
                System.out.print(array[i]+",");
            }
            System.out.println();
    }
    /**
     * 插入操作
     * 插入的操作是插入到最后的位置
     * ，然后通过与子节点比较 如果比之大则与之交换 递归到根节点 如果中间木有交换则停止
     * @param value
     */
    public void insert(int value){
        //注意边界条件 一个是不能超过大小
       if(count>cap){
           resize();
       }
       count++;
       //放置到最后一个位置下
       array[count] = value;
       int maxInd = count;
       //默认本身就是堆结构
       while (maxInd>1){
            if(array[maxInd/2] < array[maxInd]){
                swap(maxInd,maxInd/2);
                maxInd = maxInd/2;
            }else{
                break;
            }
       }
    }

    /**
     * 删除堆顶的操作： 删除堆顶之后 先获取最后一个替换了堆顶
     * 之后每回与左右子节点比较 左右节点谁大与谁交换 临界点是不能大于count的一半 因为从n/2+1之后就木有叶子节点了 比较也没有意义了
     * 递归的时候不能超过没有叶子节点的部分
     * @return
     */
    public int deleteTop(){
        //临界点处理
        if(count==0){
            return -1;
        }
        //删除的值
        int delValue = array[1];
        //最大索引不能超过 n/2+1 因为都是叶子节点
        int topInd = count / 2 +1;
        //替换掉
        array[1] = array[count];
        count--;
        int maxInd = 1;
        int leftInd;
        int rightInd;
        boolean swap = false;
        while (maxInd<topInd){
            swap = false;
            leftInd = 2 * maxInd;
            if(array[maxInd]<array[leftInd]){
                maxInd = leftInd;
                swap = true;
            }
            rightInd = 2* maxInd +1;
            if(array[maxInd]<array[rightInd]){
                maxInd = rightInd;
                swap = true;
            }
            //替换
            if(swap){
                swap(maxInd/2,maxInd);
            }else{
                break;
            }
        }

        return delValue;
    }

    /**
     * 1.先判断是是否还有元素
     * 2.如果有元素则先把计数减1
     * 3.之后进行堆化 这里是抽取堆化的作为一个方法
     *  1)每次比较左右节点 需要保证每回都不会超出数组的大小，同时比较 如果有比之大的则交换
     *  2）看交换后的那个节点是否跟初始节点是否一致 一致则说明没有交换的必要就可以break了（这里就把flag这个元素给去了 而且少了一些空间使用）
     * @return
     */
    public int deleteTopNew(){
        //临界点处理
        if(count==0){
            return -1;
        }
        //删除的值
        int delValue = array[1];
        //最大索引不能超过 n/2+1 因为都是叶子节点 其实这个临街条件无所谓，因为每次*2大于n就停止了 这样代码变得比较清晰
//        int topInd = count / 2 +1;
        //替换掉
        array[1] = array[count];
        count--;
        heapify(count,1);
        return delValue;
    }

    private void heapify(int n, int i) {
        while (true){
            int maxPos = i;
            if(i*2<=n&&array[maxPos]<array[i*2]){
                maxPos = 2*i;
            }
            if(i*2+1<=n&&array[maxPos]<array[i*2+1]){
                maxPos = i*2 + 1;
            }
            if(maxPos==i){
                break;
            }
            swap(i,maxPos);
            i = maxPos;
        }
    }

    /**
     * 建堆 这个操作可以在初始化的时候进行操作
     * 我们这里采用第二种思路来完成 这里默认赋值进来的也是从1开始的数据
     */
    public void buildHead(){
        int tempLastCount = count;
        //边界条件
        if(tempLastCount==0){return ;}
        //从 count/2开始到>=1 每次都需要进行 堆化至上而下操作
        for (int i = tempLastCount/2;i>=1;i--){
            heapify(tempLastCount, i);
        }
    }

    public void sort(){
        buildHead();
        sortReal(count);
    }
    /**
     * 堆排序 参照删除 只不过每次都将最大的数据放到最后一个数组中不进行删除罢了
     * @param  scope 是一个范围 比如已经排序的则不记录
     */
    public void sortReal(int scope){
        //临界点处理
        if(scope==0){
            return ;
        }
        //删除的值
        int temVal = array[1];
        //替换掉
        array[1] = array[scope];
        array[scope] = temVal;
        --scope;
      /*  int maxInd = 1;
        int leftInd;
        int rightInd;
        boolean swap = false;
        while (maxInd<topInd){
            swap = false;
            leftInd = 2 * maxInd;
            if(leftInd<=scope){
                if(array[maxInd]<array[leftInd]){
                    maxInd = leftInd;
                    swap = true;
                }
            }
            rightInd = 2* maxInd +1;
            if(rightInd<=scope) {
                if(array[maxInd]<array[rightInd]){
                    maxInd = rightInd;
                    swap = true;
                }
            }
            //替换
            if(swap){
                swap(maxInd/2,maxInd);
            }else{
                break;
            }
        }*/
        heapify(scope,1);
        sortReal(scope);
    }

    /**
     * 至上而下的堆化
     * @param tempLastCount
     * @param i
     */
   /* private void heapify(int tempLastCount, int i) {
        int maxInd = i;
        int leftInd,rightInd;
        boolean swap = false;
        while (maxInd<tempLastCount/2+1) {
            swap = false;
            leftInd = 2 * maxInd;
            if (array[maxInd] < array[leftInd]) {
                maxInd = leftInd;
                swap = true;
            }
            //右子节点可能不存在 所以需要判断下
            rightInd = 2 * maxInd + 1;
            if(rightInd<=count){
                if (array[maxInd] < array[rightInd]) {
                    maxInd = rightInd;
                    swap = true;
                }
            }
            //替换 优化 如果都木有需要交换的说明操作完成了
            if(swap){
                swap(maxInd / 2, maxInd);
            }else {
                break;
            }
        }
    }
*/


    /**
     * 数据交换
     * @param maxInd
     * @param tind
     */
    private void swap(int maxInd,int tind) {
        int tem;
        tem = array[maxInd];
        array[maxInd] =  array[tind];
        array[tind] = tem;
    }

    /**
     * 重新扩容
     */
    private void resize(){
        //创建临时节点
        cap = cap*2;
        int[] tem = new int[cap+1];
        int i = 0;
        while (i<array.length){
            tem[i++] = array[i++];
        }
        array = tem;
    }


    public static void main(String[] args) {
        int[] array = new int[6];
        array[1] = 2;
        array[2] = 6;
        array[3] = 8;
        array[4] = 10;
        array[5] = 10;
        Heap heap = new Heap(array,5);
        heap.sort();
        heap.print();
//        Heap heap = new Heap();
//        heap.insert(5);
//        heap.insert(4);
//        heap.insert(10);
//        heap.insert(8);
//        heap.insert(1);
//        heap.print();
//        heap.deleteTopNew();
//        heap.print();

    }
}
