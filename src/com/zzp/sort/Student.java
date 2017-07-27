package com.zzp.sort;

/**
 * Created by zzy on 2017/7/26.
 */
public class Student implements Comparable{
    private String name;
    private int age;
    private String gender;

    public Student(String name,int age,String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return this.name+"  "+this.age+" "+this.gender;
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student)o;
        return this.age-s.age;
    }
}
