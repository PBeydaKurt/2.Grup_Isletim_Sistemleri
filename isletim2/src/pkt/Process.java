package pkt;

public class Process {
    int id;
    int arrivetime;
    int runtime;
    int priority;
    int flag;
    int overtime;
    public int isFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overTime) {
        this.overtime = overTime;
    }


    public int getArrivetime() {
        return arrivetime;
    }

    @Override
    public String toString() {
        return "process [Id=" + id + ", Arrive Time=" + arrivetime + ", Run Time=" + runtime + ", Priority="
                + priority +", flag="+ flag + ", Over Time="+ overtime + "]";
    }

    public void setArrivetime(int arriveTime) {
        this.arrivetime = arriveTime;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runTime) {
        this.runtime = runTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int Priority) {
        this.priority = Priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        id = Id;
    }

    public Process (int[] array ){


        this.id=array[0];
        this.arrivetime=array[1];
        this.priority=array[2];
        this.runtime=array[3];
        this.flag = array[4];
        this.overtime = array[5];


    }

}
