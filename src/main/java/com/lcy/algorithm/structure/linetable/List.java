package com.lcy.algorithm.structure.linetable;

/**
 * Created by： luochengyue
 * date: 2018/11/19.
 * desc：
 *
 * @version:
 */
public interface List<T> {

    /**
     * 添加
     * @param a
     */
    public void add(T a);

    /**
     * 删除
     * @param loc 所在位置
     * @return
     */
    public T delete(Integer loc);

    /**
     * 插入
     * @param e
     * @param loc
     */
    public void insert(T e ,Integer loc);

    /**
     * 清空
     */
    public void clear();

    /**
     *
     * @param e
     * @return
     */
    Integer getLocation(T e);

    /**
     * 是否为空
     * @return
     */
    Boolean isEmply();

    /**
     * 获取长度
     * @return
     */
    Integer getLen();

}
