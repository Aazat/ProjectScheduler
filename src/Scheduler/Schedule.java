package Scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Schedule {
    
    public int NumOfTasks;  
    public int daysInSchedule;
    public int restInterval;
    public ArrayList<ArrayList<StoredTask>> ScheduleTable;
    public HashMap<String , Integer> taskFrequency;
    private String days[] = {"Monday", "Tuesday", "Wednesday", "Thurday", "Friday", "Saturday", "Sunday"};

    public Schedule(ArrayList<ArrayList<StoredTask>> ScheduleTable, HashMap<String , Integer> taskFrequency, int NumOfTasks, int restInterval){        
        this.ScheduleTable = ScheduleTable;
        this.taskFrequency = taskFrequency;
        this.NumOfTasks = NumOfTasks;
        this.daysInSchedule = ScheduleTable.size();
        this.restInterval = restInterval;
    }

    public int maxNumofTaskInaDay(){
        int max = ScheduleTable.get(0).size();
        for(ArrayList<StoredTask> st : ScheduleTable){
            if(st.size() > max){
                max = st.size();
            }
        }
        return max;
    }

    public void ShowSchedule(){
        int i = 0;
        System.out.println("Number of Tasks in Schedule : " + NumOfTasks);
        System.out.println("Maximum Task achieved in a day : " + maxNumofTaskInaDay());
        
        for(ArrayList<StoredTask> d : ScheduleTable){
            System.out.println("Schedule for : " + days[i] + "\n");
            
            i++;
            for(StoredTask st : d){
                // System.out.print("debug print ");
                st.showStoredTask();
            }
            System.out.println("\nNumber of tasks : " + d.size());
            System.out.println("_______________________________________________");
            
        }
    }

    public void ShowSchedule(int offset){
        System.out.println("Number of Tasks in Schedule : " + NumOfTasks);
        System.out.println("Maximum Task achieved in a day : " + maxNumofTaskInaDay());
        System.out.println("_______________________________________________");
        int i = 0;
        for(ArrayList<StoredTask> d : ScheduleTable){
            System.out.println("Schedule for " + days[i] + " :\n");
            
            i++;
            for(StoredTask st : d){
                // System.out.print("debug print ");
                st.showStoredTask(offset);
            }
            System.out.println("\nNumber of tasks : " + d.size());
            System.out.println("_______________________________________________");
            
        }
    }

    public void showFrequency(){
        System.out.println("Number of times each task is achieved in " + daysInSchedule + " days");
        for(String i : taskFrequency.keySet()){
            System.out.println( '\t'+ i + " - " + taskFrequency.get(i));
        }
    }

    public void printShuffledSchedule(int offset){
        ArrayList<StoredTask> d;
        System.out.println("Number of Tasks in Schedule : " + NumOfTasks);
        System.out.println("Maximum Task achieved in a day : " + maxNumofTaskInaDay());
        System.out.println("_______________________________________________");
        int i = 0;
        for(ArrayList<StoredTask> daily_schedule : ScheduleTable){
            System.out.println("Schedule for " + days[i] + " :\n");
            i++;
            d = new ArrayList<>(daily_schedule);
            Collections.shuffle(d);
            
            int urange = 0, lrange = 0;
            for(StoredTask s : d){    
                urange += s.time*60;        
                s.showShuffledStoredTask(offset, lrange, urange);            
                urange += restInterval;
                lrange = urange;
            }
            System.out.println("\nNumber of tasks : " + d.size());
            System.out.println("_______________________________________________");
        }
    }

    // private void printSchedule(ArrayList<StoredTask> d, int offset){
    //     int urange = 0, lrange = 0;
    //     for(StoredTask s : d){    
    //        urange += s.time;        
    //        s.showShuffledStoredTask(offset, lrange, urange);            
    //         urange += restInterval;
    //         lrange = urange;
    //     }
    // }

    public int taskFrequency(String name){
        return taskFrequency.get(name);
    }
}