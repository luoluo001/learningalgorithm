package com.lcy.algorithm.search;

/**
 * Created by： luochengyue
 * date: 2018/12/14.
 * desc：主要包含了 常规的二分查找法和变形的二分查找法
 * @version:
 */
public class BinarySearch {

    /**
     * 在数组中查找对应位置的元素下标
     * @param a
     * @param sv  要查找
     */
    public int searchOne(int[] a,int sv){
        if(a.length<1){
            return -1;
        }
        int low = 0;
        int hight = a.length-1;
        int mid = 0;
        while (low<=hight){
            mid = ((hight-low)>>1)+low;
            if(a[mid]==sv){
                return  mid;
            }else if (a[mid]>sv){
                hight = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 变形1 找第一个值与之相等的元素 (还有的是查找最后一个值与之相等的元素其实变形的地方注意下即可两者差不多)
     * @param a
     * @param sv
     * @return
     */
    public int searchTransform1(int[] a,int sv){
        if(a.length<1){
            return -1;
        }
        int low = 0;
        int hight = a.length-1;
        int mid = 0;
        while (low<=hight){
            mid = ((hight-low)>>1)+low;
            if(a[mid]==sv){
                //注意这里需要变形了
                //1.注意边界条件
                if(mid==0){
                    return mid;
                }else{
                    //说明前面还存在于当前要查找元素相同的值
                    if(a[mid-1]==sv){
                        hight = mid -1;
                    }else{
                        return mid;
                    }
                }
            }else if (a[mid]>sv){
                hight = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }



    /**
     * 变形2 查找第一个大于等于给定值的元素  查找最后一个小于等于给定值的元素 跟这很像 自己想想啦
     * @param a
     * @param sv
     * @return
     */
    public int searchTransform2(int[] a,int sv){
        if(a.length<1){
            return -1;
        }
        int low = 0;
        int hight = a.length-1;
        int mid = 0;
        while (low<=hight){
            mid = ((hight-low)>>1)+low;
            if(a[mid]>=sv){
                //注意这里需要变形了
                //1.注意边界条件
                if(mid==0){
                    return mid;
                }else{
                    //说明前面还存在于当前要查找元素相同的值
                    if(a[mid-1]>=sv){
                        hight = mid -1;
                    }else{
                        return mid;
                    }
                }
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 在一个循环有序数组中用二分查找法找到对应的相等的值
     * @param a  数组
     * @param  lowInd 分界点
     * @param sv 寻找的值
     *  比如 4,5,6,1,2,3 分界点在
     *   一种是统一思想  low<=hight 变更为 (low+cap-lowInd)%cap<=(hight+cap-lowInd)%cap 用补偿的方式这样高阶还是高阶 低阶还是低阶
     *   mid = ((hight+cap - low)%cap>>1) + low; 这里先求高低数据的相差几个 再加上低阶的索引 求出中间值
     *   low = (mid+1)%cap; 防止低阶溢出
     *   hight = (mid+cap - 1)%cap; 防止高阶溢出
     */
    public int searchCircleArray(int[] a,int lowInd,int sv){
        if(a.length<1){
            return -1;
        }
        int low = lowInd;
        int hight = lowInd -1;
        int cap = a.length;
        int mid = 0;
        while ((low+cap-lowInd)%cap<=(hight+cap-lowInd)%cap){
            mid = ((hight+cap - low)%cap>>1) + low;
            if(a[mid]==sv){
                return mid;
            }else if(a[mid]<sv){
                low = (mid+1)%cap;
            }else{
                hight = (mid+cap - 1)%cap;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        BinarySearch bs =new BinarySearch();
        int[] a = new int[]{5,6,7,1,2,3,4};
        System.out.println(bs.searchCircleArray(a,3,6));
    }
}
