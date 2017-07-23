package com.zzp.test;

/**
 * Created by zzy on 2017/7/19.
 */
public class X{
      public Object m() {
          byte a = 3;
          double b = 12.0;
          double d = 42e1;
          Object o = new Float(3.14F);
          Object[] oa = new Object[1];
          oa[0] = o;
          o = null;
          oa[0] = null;
          System.out.println(oa[0]);
          return null;
      }}