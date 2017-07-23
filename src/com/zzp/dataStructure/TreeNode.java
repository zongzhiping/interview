package com.zzp.dataStructure;

/**
 * Created by zzy on 2017/7/23.
 */
public class TreeNode<T> {
    public T val;
    public TreeNode<T> leftDate;
    public TreeNode<T> rightDate;

    public TreeNode(T val , TreeNode<T> leftDate,TreeNode<T> rightDate){
        this.val = val;
        this.leftDate = leftDate;
        this.rightDate = rightDate;
    }
}
