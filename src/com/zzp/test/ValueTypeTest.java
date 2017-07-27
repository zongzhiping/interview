package com.zzp.test;

/**
 * Created by zzy on 2017/7/24.
 */
public class ValueTypeTest {
    public static void main(String args[]){
        float f = 4.2f;
        Float F = new Float(4.2F);
        Double D = new Double(4.2);

        System.out.println(F==F);
        System.out.println(f==F);
        System.out.println(f==D);
        System.out.println(D.equals(f));
        System.out.println(D.equals(F));
        System.out.println(F.equals(4.2));
    }
}
