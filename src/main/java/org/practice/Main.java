package org.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        UserBucket userBucket = new UserBucket(1);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<15;++i){
            executorService.execute(()-> userBucket.accept(1));
        }
        executorService.shutdown();
    }
}