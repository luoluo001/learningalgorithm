package com.lcy.algorithm.trie;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by： luochengyue
 * date: 2019/1/14.
 * desc：
 * @version:
 */
public class ACTrie {
    private TrieNode rootNode = new TrieNode();
    public void insert(String data){
        char[] cs = data.toCharArray();
        TrieNode p = rootNode;
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
        p.setEndChar(true);
        p.setLength(cs.length);
    }

    /**
     * 构建失败节点 是一个按层遍历的过程
     * 初始化：root的fail为null，root下一层的所有失败节点为root
     * 第一种情况：如果p的失败节点为q，pc=qc 则失败节点pc指向qc
     * 第二种情况：如果p的失败节点q，pc≠qc 则q=q.fail 直到q=rootNode则将pc的失败节点指向rootNode
     */
    public void buildFailNode(){
        TrieNode p = rootNode;
        rootNode.setFail(null);
        //按层遍历我们以queue的数据结构来做
        Queue<TrieNode> queue = new LinkedList<TrieNode>();
        queue.add(rootNode);
        TrieNode q,pc,qc;
        while (queue.size()>0){
            p = queue.remove();
            //获取下一层所有的数据
            for(int i=0;i<p.subNodes.length;i++){
                //子节点为空 就没有必要继续了
                if(p.subNodes[i]==null){
                    continue;
                }
                //父节点为根节点则设置pc的失败节点为根节点 第一种情况为初始化条件
                pc = p.subNodes[i];
                if(p==rootNode){
                    pc.setFail(rootNode);
                }else{
                    //第二种情况需要判别是等于还是不等
                   q = p.fail;
                   qc = null;
                   while (q!=null&&(qc = q.subNodes[i])!=pc){
                        //第二种情况pc！=qc的情况下 q=q.fail
                       q = q.fail;
                   }
                   //如果为null都没有找到我们就设置pc的失败指针为根节点
                   if(q==null){
                       pc.setFail(rootNode);
                   }else{
                       //第一种情况pc=qc的情况下
                       pc.setFail(qc);
                   }
                }
                //添加进队列
                if(pc!=null){
                    queue.add(pc);
                }
            }

        }
    }

    /**
     * 匹配算法
     * @param data
     */
    public void math(char[] data){
        //边界条件判断
        if(data==null||data.length<1){
            return ;
        }
        /**
         * 匹配算法的思路p=rootNode i从0开始，主串a，模式串b
         * 如果p指向b[i]为x则 p指向x，并判断一系列以失败指针为结尾的路径是否有模式串
         * 如果p指向的b[i]不存在，则p=p.fail ，去寻找可以匹配的串,直到p=rootNode
         */
        TrieNode p = rootNode;
        TrieNode tem;
        for(int i = 0;i<data.length;i++){
            int idx = data[i] - 'a';
            //如果p指向的b[i]不存在，并且p不等于rootNode，则p=p.fail ，去寻找可以匹配的串
            while (p.subNodes[idx]==null&&p!=rootNode){
                p = p.fail;
            }
            //如果p指向b[i]为x则 p指向x，
            p=p.subNodes[idx];
            if(p==null){p = rootNode;}//从root开始重新匹配
            tem = p;
            while (tem!=rootNode){
                //并判断一系列以失败指针为结尾的路径是否有模式串
                if(tem.isEndChar){
                    int pos = i - tem.length+1;
                    System.out.println("敏感词匹配开始位置："+pos+"长度为"+tem.length);
                }
                tem = tem.fail;
            }
        }

    }
    /**
     * Trie节点包含节点数据和子节点数组，当然还有对应的
     */
    @Data
    class TrieNode{
        char data;
        TrieNode[] subNodes = new TrieNode[26];
        boolean isEndChar;
        TrieNode fail;
        int length = -1;//该模式串的长度，只有当isEndChar为True的时候用于记录
    }

    public static void main(String[] args) {
        ACTrie acTrie = new ACTrie();
        acTrie.insert("bitch");
        acTrie.insert("shit");
        acTrie.insert("bools");
        acTrie.insert("fuck");
        acTrie.insert("fuckyou");
        acTrie.buildFailNode();
        String testData = "youarebitchiknowyouarefoolishbuticanifuckyoufuckyou";
        acTrie.math(testData.toCharArray());
    }
}
