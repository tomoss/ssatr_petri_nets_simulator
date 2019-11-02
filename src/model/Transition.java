package model;

public class Transition {

    int minTime;
    int maxTime;
    int delay;
    int tempTokens;

    Transition(){
        delay = -1;
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

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getTempTokens() {
        return tempTokens;
    }

    public void setTempTokens(int tempTokens) {
        this.tempTokens = tempTokens;
    }
}
