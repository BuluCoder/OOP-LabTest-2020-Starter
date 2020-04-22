package ie.tudublin;

import processing.data.TableRow;

public class Task {
    private String tk;
    private  int srt;
    private int end;

    public String getTask()
    {
        return tk;
    }

    public void setTask(String task)
    {
        tk = task;
    }

    public  int getStart()
    {
        return srt;
    }

    public void setStart(int start)
    {
        srt = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Task(String task, int start, int end)
    {
        tk = task;
        srt = start;
        this.end = end;
    }

    public Task(TableRow tabrow)
    {
        this(tabrow.getString("Task"), tabrow.getInt("Start"), tabrow.getInt("End"));
    }

    @Override
    public String toString()
    {
        return "Task = " + tk + ", Start = " + srt + ", End = " + end + ".";
    }
}
