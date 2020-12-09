import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User {

    private int money;
    private HashMap<UniClass, double> classes;
    private double average;
    private int allUnits;

    public Student(String username, String password) {
        super(username, password);
        money = 0;
        classes = new HashMap<UniClass, double>();
        average = 0;
        allUnits = 0;
    }

    public void calculateAvg (){
        double tmp;
        for (HashMap.Entry entry : classes.entrySet()){

        }
    }

    public void addScore (int score){

    }

    public void addClass (UniClass uniClass){
        classes.put(uniClass, 0);
        allUnits = allUnits + uniClass.getUnitsNum();
    }
}
