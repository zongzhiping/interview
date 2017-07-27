package com.zzp.dataStructure;

import java.util.Stack;

/**
 * Created by zzy on 2017/7/23.
 */
public class TestTreeNode {
    public static void main(String args[]){
        TreeNode<String> D = new TreeNode<String>("D", null, null);
        TreeNode<String> H = new TreeNode<String>("H", null, null);
        TreeNode<String> I = new TreeNode<String>("I", null, null);
        TreeNode<String> J = new TreeNode<String>("J", null, null);
        TreeNode<String> P = new TreeNode<String>("P", null, null);
        TreeNode<String> G = new TreeNode<String>("G", P, null);
        TreeNode<String> F = new TreeNode<String>("F", null, J);
        TreeNode<String> E = new TreeNode<String>("E", H, I);
        TreeNode<String> B = new TreeNode<String>("B", D, E);
        TreeNode<String> C = new TreeNode<String>("C", F, G);
        TreeNode<String> A = new TreeNode<String>("A", B, C);

//        xianIterator(A);
//        System.out.println();
//        nXianIterator(A);
//        zhongIterator(A);
//        nZhongIterator(A);
//        houIterator(A);
//        System.out.println();
        nHouIterator(A);


    }

    /********************************先序遍历************************************/
    /**
     * 先序遍历递归实现
     */
    static void xianIterator(TreeNode t){
        System.out.print(t.val);

        if(t.leftDate!=null){
            xianIterator(t.leftDate);
        }

        if(t.rightDate!=null){
            xianIterator(t.rightDate);
        }
    }

    /**
     * 先序遍历的非递归实现
     */
    static void nXianIterator(TreeNode root){
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();

        while(node!=null||!stack.isEmpty()){
            while (node!=null){
                System.out.print(node.val);//输出
                stack.push(node);
                node = node.leftDate;
            }

            if(!stack.isEmpty()){
                node = stack.pop();
                node = node.rightDate;
            }
        }
    }

    /********************************中序遍历************************************/
    /**
     * 中序遍历的递归实现
     */
    static void zhongIterator(TreeNode root){
        if(root.leftDate!=null){
            zhongIterator(root.leftDate);
        }
        System.out.print(root.val);
        if(root.rightDate!=null){
            zhongIterator(root.rightDate);
        }
    }

    /**
     * 中序遍历的非递归实现
     */
    static void nZhongIterator(TreeNode root){
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while(node!=null||!stack.isEmpty()){

            while(node!=null){
                stack.push(node);
                node = node.leftDate;
            }

            if(!stack.isEmpty()){
                node = stack.pop();
                System.out.print(node.val);
                node = node.rightDate;
            }

        }
    }

    /********************************后序遍历************************************/
    /**
     * 后序遍历递归实现
     */
    static void houIterator(TreeNode root){
        if(root.leftDate!=null){
            houIterator(root.leftDate);
        }
        if(root.rightDate!=null){
            houIterator(root.rightDate);
        }
        System.out.print(root.val);
    }

    /**
     * 后续遍历非递归实现
     */
    static void nHouIterator(TreeNode root){
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode listVal = root;

        while(node!=null||!stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node = node.leftDate;
            }

            node = stack.peek();

            if(node.rightDate==null||node.rightDate==listVal){
                System.out.print(node.val);
                listVal = node;
                stack.pop();
                node = null;
            }else{
                node = node.rightDate;
            }
        }
    }


}
