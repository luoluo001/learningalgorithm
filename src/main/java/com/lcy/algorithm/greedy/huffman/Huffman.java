package com.lcy.algorithm.greedy.huffman;

import lombok.Data;

/**
 * Created by： luochengyue
 * date: 2019/1/16.
 * desc：
 * @version:
 */
public class Huffman {

    @Data
    class Node{
        char c;     //父节点没有对应的数值
        boolean isParent;//是否是父节点  就是没有数值的节点
        Integer num;//字符数值出现的频率
    }
}
