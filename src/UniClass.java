enum Day {
    SAT, SUN, MON, TUE, WED
}

public class UniClass {

    private String className;
    private int unitsNum;
    private Day day;
    private int time; //0810 1012 1416

    public UniClass (String className, int unitsNum, Day day, int time){
        this.className = className;
        this.unitsNum = unitsNum;
        this.day = day;
        this.time = time;
    }

    public int getUnitsNum (){
        return unitsNum;
    }

}
