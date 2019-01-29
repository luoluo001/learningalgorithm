package com.lcy.algorithm.trie;

import lombok.Data;

import java.util.HashMap;

/**
 * Created by： luochengyue
 * date: 2019/1/11.
 * desc：
 *
 * @version:
 */
public class TrieHash {
    private Object PRESENT = new Object();
    private TrieHash.TrieNode topNode = new TrieHash.TrieNode();
    public void insert(String data){
        char[] cs = data.toCharArray();
        TrieNode p = topNode;
        /**
         * 按字符的先后顺序存到对应的子节点中
         */
        for(int i =0;i<cs.length;i++){
            if(p.subTrieNode ==null){
                p.subTrieNode.put(cs[i],PRESENT);
            }
            p = p.subTrieNode;
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
            /**
             * 如果为空说明没有存储
             */
            if(p.subTrieNode ==null){
                return false;
            }
            if(p.subTrieNode.get(scs[i])==null){
                return false;
            }
            p = p.subTrieNode;
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
    class TrieNode extends HashMap{
        TrieNode subTrieNode;
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
