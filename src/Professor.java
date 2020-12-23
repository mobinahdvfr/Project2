import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Professor extends User implements Serializable {

    private LinkedHashMap<UniClass,ArrayList<Student>> classesAndStudents;

    public Professor(String username, String password) {
        super(username, password);
        classesAndStudents = new LinkedHashMap<>();
    }

    public ArrayList<UniClass> getClasses (){
        ArrayList<UniClass> uniClasses = new ArrayList<>();
        uniClasses.addAll(classesAndStudents.keySet());
        return uniClasses;
    }

    public ArrayList<Student> getStudents (int index){
        int i = 0 ;
        for (UniClass u : classesAndStudents.keySet()){
            if (i == index){
                ArrayList<Student> arrayList = new ArrayList<>();
                arrayList.addAll( classesAndStudents.get(u) );
                return arrayList;
            }
            i++;
        }
        return null;
    }

    public LinkedHashMap<UniClass, ArrayList<Student>> getClassesAndStudents (){
        return classesAndStudents;
    }

    public void makeClass (String course, int unitsNum, ArrayList<Day> days, int time, int capacity){
        classesAndStudents.put(UniSystem.addClass(course, unitsNum, days, time, capacity), new ArrayList<>());
    }

    public boolean equals (Object o){
        return super.equals(o);
    }
}
