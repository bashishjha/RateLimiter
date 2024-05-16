package org.practice;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindow {

    Queue<Long> window;
    int timeWindow;
    int bucketCapacity;

    public SlidingWindow(int timeWindow, int bucketCapacity){
        this.window = new ConcurrentLinkedQueue<>();
        this.timeWindow = timeWindow;
        this.bucketCapacity = bucketCapacity;
    }
    public Boolean grantAccess(){
        long currentTime = System.currentTimeMillis();
        currentAndUpdate(currentTime);
        if(window.size()<bucketCapacity){
            window.offer(currentTime);
            return true;
        }
        return false;
    }

    public void currentAndUpdate(Long currentTime){
        if(window.isEmpty()) return;
        long time = (currentTime-window.peek())/1000;
        while(time>timeWindow){
            window.poll();
            if(window.isEmpty()) break;
            time = (currentTime-window.peek())/1000;
        }
    }

}
