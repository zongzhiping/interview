package com.zzp.sort;

import java.util.*;

/**
 * Created by zzy on 2017/7/26.
 */
public class CollectionsTest {
    public static void main(String args[]){
        Set<Student> set = new TreeSet<Student>();
//        set.add(new Student("张三",18,"男"));
//        set.add(new Student("李四",23,"男"));
//        set.add(new Student("王五",17,"男"));


        /*****************************遍历*******************************/
        /*****************************Set遍历*******************************/
        for (Student s:
             set) {
            System.out.println(s);
        }

        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }



        System.out.println("/*****************************list遍历*******************************/");
        /*****************************list遍历*******************************/
//        List list = new ArrayList<>();
////        list.add(new Student("张三",18,"男"));
////        list.add(new Student("李四",21,"男"));
////        list.add(new Student("王五",13,"男"));
//        list.add(1);
//        list.add(4);
//        list.add(11);
//        list.add(5);
//
//        for (Object s:
//             list) {
//            System.out.println(s);
//        }
//
//        for(int i = 0 ; i <list.size() ; i++){
//            System.out.println(list.get(i));
//        }
//
//        Iterator its = list.iterator();
//        while(its.hasNext()){
//            System.out.println(its.next());
//        }
//
//        System.out.println("进行排序操作!");
//        Collections.sort(list);
//        for (Object s:
//             list) {
//            System.out.println(s);
//        }

//        System.out.println("/*****************************map遍历*******************************/");
//        /*****************************map遍历*******************************/
//        Map<String,String> map = new HashMap<String,String>();
//        map.put("a","张三");
//        map.put("b","李四");
//        map.put("c","王五");
//
//        for(Object o : map.keySet()){
//            System.out.println(o+" "+map.get(o));
//        }
//
//        for(Object o : map.values()){
//            System.out.println(o);
//        }
//
//        for(Object e:map.entrySet()){
//            Map.Entry entry = (Map.Entry)e;
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }
//
//       for(Map.Entry<String,String> e: map.entrySet()){
//            System.out.println(e.getKey()+" "+e.getValue());
//       }
//
//       Iterator<Map.Entry<String,String>> it2 = map.entrySet().iterator();
//        while(it2.hasNext()){
//            Map.Entry m = it2.next();
//            System.out.println(m.getKey()+" "+m.getValue());
//        }

        /*****************************hashable遍历*******************************/
        System.out.println("/*****************************hashable遍历*******************************/");
        Hashtable ht = new Hashtable();
        ht.put("1","张三");
        ht.put("2","李四");
        ht.put("3","王五");

        Iterator its = ht.entrySet().iterator();
        while (its.hasNext()){
            Map.Entry entry = (Map.Entry) its.next();
            System.out.println("key: "+entry.getKey()+" ,value: "+entry.getValue());
        }

        Iterator its2 = ht.keySet().iterator();
        while(its2.hasNext()){
            String key = (String)its2.next();
            System.out.println("key: "+key+",values: "+ht.get(key));
        }

        Collection c = ht.values();
        System.out.println(c);

        Enumeration e = ht.keys();
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }

        Enumeration ee = ht.elements();
        while (ee.hasMoreElements()){
            System.out.println(ee.nextElement());
        }


    }
}


