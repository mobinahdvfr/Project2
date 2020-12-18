import java.util.ArrayList;

enum Day {
    SAT, SUN, MON, TUE, WED
}

public class UniClass {

    private String className;
    private int unitsNum;
    private ArrayList<Day> days;
    private int time; //0810 1012 1416
    private int capacity;

    public UniClass (String className, int unitsNum, ArrayList<Day> days, int time, int capacity){
        this.className = className;
        this.unitsNum = unitsNum;
        this.days = days;
        this.time = time;
        this.capacity = capacity;
    }

    public String getName (){
        return className;
    }

    public int getUnitsNum (){
        return unitsNum;
    }

    public boolean equals (Object o){
        UniClass tmpClass = (UniClass) o;
        int i =0;
        if (tmpClass.className.equals(className) || tmpClass.time == time ){
            for (Day day : days){
                tmpClass.days.contains(day);
                i++;
            }
            if (i == days.size())
                return true;
        }
        return false;
    }
}
