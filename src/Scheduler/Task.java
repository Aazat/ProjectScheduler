package Scheduler;

public class Task {
    public String name;
    public int time;           // Time to work per day in hours.
    public int frequency;      // Number of times to work per week.
    public int priority;       // Integer priority , greater priority more preference    
    public boolean on_weekend;     // Allot the particular task on weekends (or not).

    public Task (String name, int time, int frequency, int priority, boolean on_weekend){
        this.name = name;
        this.time = time;    
        this.frequency = frequency;
        this.priority = priority;
        this.on_weekend = on_weekend;    
    }

    public Task(int time){
        this.name = "something";
        this.time = time;
        this.frequency = 1;
        this.priority = 0;
        this.on_weekend = false;
    }

    public Task(String name, int time){
        this.name = name;
        this.time = time;
        this.frequency = 1;
        this.priority = 0;
        this.on_weekend = false;
    }

    public Task(Task T){
        this.name= T.name;
        this.time = T.time;
        this.frequency = T.frequency;
        this.priority = T.priority;
        this.on_weekend = T.on_weekend; 
    }
}
