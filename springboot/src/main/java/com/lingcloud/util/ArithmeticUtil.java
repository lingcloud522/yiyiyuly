package com.lingcloud.util;

import java.util.*;

public class ArithmeticUtil {

    /**
     * 给定一个数n，返回最接近n的2的幂次方的数m，且m要大于n;
     */

    public static int tableSizeFor(int n){
        int m = n-1;
        m |= m>>>1;
        m |= m>>>2;
        m |= m>>>4;
        m |= m>>>8;
        m |= m>>>16;

        return m+1;
    }


    public static void main(String[] args) {
        List<Map<String,Object>> lists = new ArrayList<>();
        while(true){
            lists.add(new HashMap<String,Object>());
        }
    }
}
