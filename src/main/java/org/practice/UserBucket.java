package org.practice;

import java.util.HashMap;

public class UserBucket {

    HashMap<Integer, SlidingWindow> userToBucket;

    public UserBucket(int id){
        userToBucket = new HashMap<>();
        userToBucket.put(id, new SlidingWindow(2, 10));
    }

    public void accept(int id){
        if(userToBucket.get(id).grantAccess())
            System.out.println(Thread.currentThread().getName()+ " is allowed");
        else{
            System.out.println(Thread.currentThread().getName() + " not allowed.");
        }
    }
}
