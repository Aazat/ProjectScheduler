// import Scheduler.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<ArrayList<Integer>> table = new ArrayList<ArrayList<Integer>>(7);
        
        for(int i = 0; i < 7; i++){
            table.add(new ArrayList<Integer>());
        }
        // ArrayList<Integer> t = new ArrayList<Integer>();
                
        // table.add(t);
        for(int i= 0; i < 7 ; i++){
            table.get(i).add(i);
        }
        for(ArrayList<Integer> x : table){
            for(Integer y : x ){
                System.out.print(y);
            }
            System.out.println("");
        }

    }    
}
