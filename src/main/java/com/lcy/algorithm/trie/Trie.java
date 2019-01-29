package com.lcy.algorithm.trie;

import lombok.Data;

/**
 * Created by： luochengyue
 * date: 2019/1/11.
 * desc：Trie树的结构 对外提供的操作包括数据插入及数据查询
 * @version:
 */
@Data
public class Trie {
    private TrieNode topNode = new TrieNode();
    public void insert(String data){
        char[] cs = data.toCharArray();
        TrieNode p = topNode;
        /**
         * 按字符的先后顺序存到对应的子节点中
         */
        for(int i =0;i<cs.length;i++){
            int hash = (int) (cs[i] - 'a');
            if(p.subNodes[hash]==null){
                p.subNodes[hash] = new TrieNode();
                p.subNodes[hash].setData(cs[i]);
            }
            p= p.subNodes[hash];
        }
        //最后一个节点代表着属于结束节点 设置为true
        p.setRed(true);
    }

    /**
     * 搜索算法
     * @param sData
     * @return
     */
    public boolean search(String sData){
        char[] scs = sData.toCharArray();
        TrieNode p = topNode;
        int hash = -1;
        for(int i =0;i<scs.length;i++){
            hash = (int) (scs[i] - 'a');
            p = p.subNodes[hash];
            /**
             * 如果为空说明没有存储
             */
            if(p==null){
                return false;
            }
        }
        if(p.red){
            return true;
        }
        return false;
    }

    /**
     * Trie节点包含节点数据和子节点数组，当然还有对应的
     */
    @Data
    class TrieNode{
        char data;
        TrieNode[] subNodes = new TrieNode[26];
        boolean red;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        String a = "her";
        String b = "hello";
        t.insert(a);
        t.insert(b);
        System.out.println(t.search(a));
        System.out.println(t.search("he"));
    }
}
