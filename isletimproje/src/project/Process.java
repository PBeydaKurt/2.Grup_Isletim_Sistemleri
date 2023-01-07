package project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Process {
    
    int ID;
    int arrivingTime;
    int runTime;
    int priority;
    int overTime;
    int delay;


    public int getOverTime() {
        return overTime;
    }

    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }


    public int getArrivingTime() {
        return arrivingTime;
    }

    @Override
    public String toString() {
        return "process [Id=" + ID + ", arrivingTime=" + arrivingTime + ", runTime=" + runTime + ", priority="
                + priority + ", overTime="+ overTime + "]";
    }
    public void setArrivingTime(int arrivingTime) {
        this.arrivingTime = arrivingTime;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        ID = id;
    }

    public Process (int[] array ){

        this.ID=array[0];
        this.arrivingTime=array[1];
        this.priority=array[2];
        this.runTime=array[3];
        this.overTime = array[4];
    }
    
}
