import java.util.ArrayList;
import java.util.Scanner;
import Scheduler.Schedule;
import Scheduler.Task;
import Scheduler.TaskScheduler;
// import Scheduler.StoredTask;

public class Main{
    public static void main(String[] args) {
        
        Task t1 = new Task("NPTEL", 2, 5,4,false);
        Task t2 = new Task("Blender", 1, 3,1,false);
        Task t3 = new Task("Internship", 3, 5,5,false);
        Task t4 = new Task("College", 2, 3,2,false);
        Task t7 = new Task("RL/ML Programming", 1, 3, 2, false);
        Task t5 = new Task("DSA", 1);
        Task t6 = new Task("Project", 1);
        
        // Task t4 = GenerateTaskFromUserInput();
        
        // ArrayList<Task> TaskList = GetMultipleInputs();

        int restDays = 2, restInterval = 15, workingTime = 8, timeOffset = 10;

        TaskScheduler ts = new TaskScheduler(4, restDays, restInterval, workingTime);
        ts.Addtask(t1);
        ts.Addtask(t2);
        ts.Addtask(t3);
        ts.Addtask(t4);
        ts.Addtask(t5);
        ts.Addtask(t6);
        ts.Addtask(t7);
        // TaskScheduler ts_list = new TaskScheduler(TaskList);

        // ts.Addtask(TaskList);        

        Schedule s = ts.GenerateSchedule();
        // Schedule s_list = ts_list.GenerateSchedule();
        // System.out.println( "Number of tasks in Schedule : " + ts.TaskList.size());        
        s.showFrequency();
        System.out.println();
        s.ShowSchedule(timeOffset);
        // System.out.println("Number of days in schedule");
        // System.out.println(s.daysInSchedule);

        // System.out.println(s.ScheduleTable.get(0).size());
        // System.out.println("This second schedule is : " + s_list.isPossible);
    }

    static public Task GenerateTaskFromUserInput(){        

        String name;
        int time;           // Time to work per day in hours.
        int frequency;      // Number of times to work per week.
        int priority;       // Integer priority , greater priority more preference    
        boolean on_weekend;     // Allot the particular task on weekends (or not).
        
        try (Scanner scan = new Scanner(System.in)) {
            // System.out.println("Enter the number of Task");
            // num_of_task = scan.nextInt();
            // for(int i = 0; i < num_of_task; i++){
            System.out.println("Enter Name of Task");
            name = scan.next();

            System.out.println("Enter time (per day) in hours");
            time = scan.nextInt();        

            System.out.println("Enter frequency (per week)");
            frequency = scan.nextInt();

            System.out.println("Enter priority of task");
            priority = scan.nextInt();

            String weekend_response = "";
            System.out.println("Working this task on weekend (yes or no)");
            weekend_response = scan.next();

            if(weekend_response.toLowerCase().equals("yes"))
                on_weekend = true;
            else
                on_weekend = false;
        }
        Task t = new Task(name, time, frequency, priority, on_weekend);
        return t;
        // }
    }

    static public ArrayList<Task> GetMultipleInputs(){
        int num_of_task = 0;
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter number of tasks");
            num_of_task = scan.nextInt();
        }

        ArrayList<Task> TaskList = new ArrayList<Task>(num_of_task);

        Task t;
        for(int i = 0; i < num_of_task; i++){
            t = GenerateTaskFromUserInput();
            TaskList.add(t);
        }
        return TaskList;
    }
}