package Scheduler;

public class StoredTask extends Task {

    public int Lrange;
    public int Urange;      // Add the extra time parameter which will be calculated by TaskScheduler Algorithm.
    public StoredTask(Task T, int Lrange, int Urange) {
        super(T);
        this.Lrange = Lrange;
        this.Urange = Urange;  
    }

    public void showStoredTask(){
        System.out.println("____");
        System.out.println("Start Time :- " + Lrange + "\t" + name);
        System.out.println("End Time :-" + Urange);
        // System.out.println("____");
    }

    public void showStoredTask(int offset){
        // int dLrange = (Lrange + offset)%12, dUrange = (Urange + offset)%12;        
        System.out.println("____");
        System.out.println("Start Time :- " + timeConversion(Lrange/60 + offset) + ":" + (Lrange%60) + " "+name);
        System.out.println("End Time :-" + timeConversion(Urange/60 +  offset) + ":" + (Urange%60));
    }
    
    public void showShuffledStoredTask(int offset, int lrange, int urange){
        System.out.println("____");
        System.out.println("Start Time :- " + timeConversion(lrange/60 + offset) + ":" + (lrange%60) + " "+name);
        System.out.println("End Time :-" + timeConversion(urange/60 +  offset) + ":" + (urange%60));
    }

    private int timeConversion(int hour){
        if(hour == 12)
            return hour;
        return (hour%12);
    }
}
