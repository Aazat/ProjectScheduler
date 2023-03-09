package Scheduler;

import java.util.ArrayList;
import java.util.HashMap;

public class Schedule {
    
    public int NumOfTasks;  
    public int daysInSchedule;
    public ArrayList<ArrayList<StoredTask>> ScheduleTable;
    public HashMap<String , Integer> taskFrequency;

    public Schedule(ArrayList<ArrayList<StoredTask>> ScheduleTable, HashMap<String , Integer> taskFrequency, int NumOfTasks){        
        this.ScheduleTable = ScheduleTable;
        this.taskFrequency = taskFrequency;
        this.NumOfTasks = NumOfTasks;
        this.daysInSchedule = ScheduleTable.size();
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
        int i = 1;
        System.out.println("Number of Tasks in Schedule : " + NumOfTasks);
        System.out.println("Maximum Task achieved in a day : " + maxNumofTaskInaDay());
        
        for(ArrayList<StoredTask> d : ScheduleTable){
            System.out.println("Schedule for Day : " + i + "\n");
            
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
        int i = 1;
        for(ArrayList<StoredTask> d : ScheduleTable){
            System.out.println("Schedule for Day : " + i + "\n");
            
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
            System.out.println(i + " - " + taskFrequency.get(i));
        }
    }
}