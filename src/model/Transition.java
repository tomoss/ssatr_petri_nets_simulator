package model;

import java.util.Random;

public class Transition extends PNObject{

    int minTime;
    int maxTime;
    int delay;
    int tempTokens;

    public Transition(){
        delay = 0;
    }

    public int getMinTime() {
        return minTime;
    }

    public void setMinTime(int minTime) {
        this.minTime = minTime;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    public int getDelay() {
        return delay;
    }

    public int getTempTokens() {
        return tempTokens;
    }

    public void setTempTokens(int tempTokens) {
        this.tempTokens = tempTokens;
    }

    public void addTempToken(){
        tempTokens++;
    }

    public boolean decreaseTokens(){
        if(tempTokens == 0){
            return  false;
        } else {
            tempTokens--;
            return true;
        }
    }

    public void setDelay(){
        if(minTime == 0 && minTime == 0){
            System.out.println(id+" has no delay!");
        } else {
            Random r = new Random();
            delay = r.nextInt((maxTime - minTime) + 1) + minTime;
            System.out.println(id+" delay set: "+delay);
        }

    }

    public void decreaseDelay(){
        if(delay == 0){
            System.out.println(id+" delay is already 0");
        } else {
            delay--;
            System.out.println(id+" delay decreased ! now: "+delay);
        }
    }
}
