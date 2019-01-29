package com.lcy.algorithm.tree;

import lombok.Data;

import java.awt.*;
import java.beans.beancontext.BeanContext;

/**
 * Created by： luochengyue
 * date: 2018/12/24.
 * desc：二叉查找树
 * @version:
 */
public class SearchBinaryTree {

    private Node header = null;

    /**
     * 这里为了简化 返回的NOde是带左右节点的 否则应该需要copy一份返回
     * 查找是递归查找 大于当前节点则往右节点查找，小于该节点则往左查找
     * @param data
     * @return
     */
    public Node find(int data){
        if(header==null){
            return null;
        }
        Node tem = header;
        //只要节点不为空则返回节点继续递归遍历
        while (tem!=null){
            if(tem.data==data){
                return tem;
            }else if(data>tem.data){
                tem = tem.rightNode;
            }else {
                tem = tem.leftNode;
            }
        }
        return null;
    }

    /**
     * 这里如果相同则不进行插入操作
     * 插入的算法也是 先查找后插入 插入的节点都是属于 先找到合适的节点再插入（ps:插入的节点都是插入到叶子节点）
     * 如果比当前节点小 则查询左子节点 如果为空则插入 不为空则以左节点为当前节点继续查找
     * 如果比当前节点大  则查询右子节点 查看是否为空为空则直接插入，不为空以右子节点为当前节点继续查找
     * @param data
     */
    public void insert(int data){
        //边界条件
        if(header==null){
            header = new Node(data);
            return;
        }
        Node temNode = header;
        while (temNode!=null){
            if(data>temNode.data){
                if(temNode.rightNode==null){
                    temNode.rightNode =  new Node(data);
                    break;
                }
                temNode = temNode.rightNode;
            }else{
                if(temNode.leftNode==null){
                    temNode.leftNode = new Node(data);
                    break;
                }
                temNode = temNode.leftNode;
            }
        }
    }

    /**
     * 删除操作: 删除操作要比查询和插入操作复杂一些分3中情况
     * 1.如果该节点是叶子节点 则直接删除
     * 2.如果该节点不是叶子节点，且只有一个节点 则将当前节点的子节点 替换当前节点
     * 3.如果当前存在左右节点，则以右节点的最小节点数据替换掉当前的这个几点数据，同时以1，2的方式替换掉当前节点（这个节点必然没有右节点）
     * @param data
     * @return
     */
    public void delete(int data){
        //便捷条件
        if(header==null){
            return ;
        }
        Node temP = null;//父节点
        Node temNode = header;//当前节点
        //先查找
        while (temNode!=null){
            if(data==temNode.getData()){
                break;
            }else if(data>temNode.data){
                temP = temNode;
                temNode = temNode.rightNode;
            }else{
                temP = temNode;
                temNode = temNode.leftNode;
            }
        }
        //没找到
        if(temNode==null){
            return ;
        }
        /**
         *  三种情况的处理
         */
        //因为第三种的情况需要复用 1,2种的情况所以先处理第三种情况
        Node flagTem = temNode;
        if(temNode.leftNode!=null&&temNode.rightNode!=null){
            temP = temNode;
            temNode = temNode.rightNode;
            while (temNode.leftNode!=null){
                temP = temNode;
                temNode = temNode.leftNode;
            }
            //替换掉原先要删除的节点，之后转换删除节点为右子节点的最小节点
            flagTem.setData(temNode.data);
        }
        Node child = null;
        //复制child
        if(temNode.leftNode!=null){
            child = temNode.leftNode;
        }else if(temNode.rightNode!=null){
            child = temNode.rightNode;
        }else{
            //第一种情况
            child = null;
        }
        //便捷条件
        if(temP ==null){
            header  = child;
        }else if(temNode.equals(temP.leftNode)){
            temP.setLeftNode(child);
        }else{
            //否则设置为右节点
            temP.setRightNode(child);
        }
    }


    public void inOrder(Node tree){
        //终止条件
        if(tree==null){
            return ;
        }
        inOrder(tree.leftNode);
        System.out.println(tree.data);
        inOrder(tree.rightNode);
    }

    public void inOrderReal(){
        inOrder(header);
    }

    /**
     * 节点 二叉树主要有左右节点
     */
    @Data
    public class Node{
        public Node(int data) {
            this.data = data;
        }

        int data;
        Node leftNode;
        Node rightNode;
    }

    public static void main(String[] args) {
        SearchBinaryTree sbt = new SearchBinaryTree();
        sbt.insert(7);
        sbt.insert(3);
        sbt.insert(8);
        sbt.insert(5);
        sbt.insert(6);
        sbt.insert(4);
        sbt.inOrderReal();
        sbt.delete(7);
        System.out.println("==============================");
        sbt.inOrderReal();
//        System.out.println(sbt.find(3));
    }
}
