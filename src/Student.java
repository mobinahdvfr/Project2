import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User implements Serializable {

    private int money;
    private HashMap<UniClass, Double> classes;
    private double average;
    private int allUnits;

    public Student(String username, String password) {
        super(username, password);
        money = 0;
        classes = new HashMap<>();
        average = 0;
        allUnits = 0;
    }


    public void setPassword (String newPassword){
        super.setPassword(newPassword);
    }

    public void setUsername (String newUsername){
        super.setUsername(newUsername);
    }

    public String getUsername (){
        return super.getUsername();
    }

    public String getPassword (){
        return super.getPassword();
    }

    public int getMoney (){
        return money;
    }

    public double getAverage (){
        return average;
    }

    public void calculateAvg (){
        double tmp = 0.0;
        for (HashMap.Entry<UniClass, Double> entry : classes.entrySet()){
            tmp = tmp + ( entry.getKey().getUnitsNum() )*( entry.getValue() );
        }
        average = tmp/allUnits;
    }

    public void addScore (UniClass uniClass, double score){
        for (UniClass u : classes.keySet()){
            if (uniClass.equals(u)){
                classes.put(u, score);
            }
        }
        average = (average*allUnits + score)/allUnits;
    }

    public void addClass (UniClass uniClass){
        classes.put(uniClass, 0.0);
        allUnits = allUnits + uniClass.getUnitsNum();
    }

    public boolean equals (Object o){
        return super.equals(o);
    }
}
