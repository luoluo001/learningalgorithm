package com.lcy.algorithm.structure.linetable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by：luo
 * date: 2019/8/15.
 * desc：
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 示例：
 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
public class Solution {

    public LinkedList<Integer> addTwoNumber(LinkedList<Integer> l1,LinkedList<Integer> l2){
        int l1SIze = l1.size();
        int l2SIze = l1.size();
        int totalSize = l1SIze>l2SIze?l1SIze:l2SIze;
        int preNum = 0;
        for(int i =0;i<totalSize;i++){

        }
        return null;
    }
}
