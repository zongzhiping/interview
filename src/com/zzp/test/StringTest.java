package com.zzp.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zzy on 2017/7/25.
 */
public class StringTest {
    public static void main(String args[]){
        List<String> listString = new ArrayList<String>();
        listString.add("aaa");
        listString.add("bbb");
        listString.add("ccc");

        for (String list:listString     //遍历的是String类型的数据
             ) {
            System.out.println(list);
        }

        for(int i = 0 ; i < listString.size(); i++){
            System.out.print(listString.get(i));
        }

        Iterator it = listString.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
