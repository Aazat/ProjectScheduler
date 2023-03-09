package Scheduler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TaskScheduler {
    public ArrayList<Task> TaskList;

    public int restDays;            // per week (for now)
    public int restInterval;        // per day 
    public int workingTime;             // per day 
    public int startTime = 0;

    public TaskScheduler (int NumOfTasks, int restDays, int restInterval, int workingTime){
        TaskList = new ArrayList<Task>(NumOfTasks);
        this.restDays = restDays;
        this.restInterval = restInterval;
        this.workingTime = workingTime;
    }

    public TaskScheduler(ArrayList<Task> T){
        this.TaskList = T;
    }

    public void Addtask(Task t){            
        this.TaskList.add(t);        
    }

    public void Addtask(ArrayList<Task> t){
        for(Task x : t){
            this.TaskList.add(x);
        }
    }

    private void sortTasks(){
        Collections.sort(TaskList, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2){
                if(t1.priority > t2.priority)
                    return -1;
                return 1;
            }
        });
        // System.out.println("Task List is now sorted");
        // for(Task t : TaskList)
        //     System.out.println(t.name);
    }

    public Schedule GenerateSchedule(){
        ArrayList<ArrayList<StoredTask>> ScheduleTable = new ArrayList<ArrayList<StoredTask>>(7);
        
        ArrayList<StoredTask> DailySchedules = new ArrayList<StoredTask>();
        
        sortTasks();

        int Lrange = 0, Urange = 0, index=0, days = 0, temp_index = -1, count = 0, n = TaskList.size();
        StoredTask st;

        for(; days < 7; index = (index+1)%n){
            Task t = TaskList.get(index);            

            if( (Urange + t.time*60) <= workingTime*60){            
                Urange += t.time*60;
                st = new StoredTask(t, Lrange, Urange);
                DailySchedules.add(st);                
                Urange += restInterval;
                Lrange = Urange;
                // index = (index + 1)%TaskList.size();
            }
            else if(index == (temp_index+(n-1))%n){
                ScheduleTable.add(new ArrayList<StoredTask>(DailySchedules));     // shallow copy of DailySchedule Array.
                
                DailySchedules.clear();

                Lrange = 0;
                Urange = 0;
                days++;
                temp_index = -1;
                count = 0;
            }
            else{
                count++;
                if(count == 1){
                    temp_index = index;
                }                                
                
            }
        }
        Schedule s = new Schedule(ScheduleTable, n);
        return s;
    }

    public Schedule GenerateSchedule(int DaysInSchedule){
        ArrayList<ArrayList<StoredTask>> ScheduleTable = new ArrayList<ArrayList<StoredTask>>(DaysInSchedule);

        ArrayList<StoredTask> DailySchedules = new ArrayList<StoredTask>();
        
        int Lrange = 0, Urange = 0, index=0, days = 0, temp_index = -1, count = 0, n = TaskList.size();
        StoredTask st;

        for(; days < DaysInSchedule; index = (index+1)%n){
            Task t = TaskList.get(index);            

            if( (Urange + t.time*60) <= workingTime*60){            
                Urange += t.time*60;
                st = new StoredTask(t, Lrange, Urange);
                DailySchedules.add(st);                
                Urange += restInterval;
                Lrange = Urange;
                // index = (index + 1)%TaskList.size();
            }
            else if(index == (temp_index+(n-1))%n){
                ScheduleTable.add(new ArrayList<StoredTask>(DailySchedules));     // shallow copy of DailySchedule Array.
                
                DailySchedules.clear();

                Lrange = 0;
                Urange = 0;
                days++;
                temp_index = -1;
                count = 0;
            }
            else{
                count++;
                if(count == 1){
                    temp_index = index;
                }                                
                
            }
        }
        
        Schedule s = new Schedule(ScheduleTable, TaskList.size());
        return s;
    }
}
