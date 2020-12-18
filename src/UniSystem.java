import java.util.ArrayList;

public class UniSystem {

    private static ArrayList<String> foods;
    private static ArrayList<Student> students;
    private static ArrayList<Professor> professors;
    private static ArrayList<UniClass> uniClasses;

    public UniSystem (){
        foods = new ArrayList<>();
        students = new ArrayList<>();
        professors = new ArrayList<>();
        uniClasses = new ArrayList<>();
    }

    public static ArrayList<String> getFoods (){
        return foods;
    }


    public void setUniClasses(){
        for (Professor p : professors){
            for (UniClass uniClass : p.getClassesAndStudents().keySet()){
                uniClasses.add(uniClass);
            }
        }
    }

    public static UniClass addClass (String course, int unitsNum, ArrayList<Day> days, int time, int capacity){
        UniClass uc = new UniClass(course, unitsNum, days, time, capacity);
        uniClasses.add(uc);
        return uc;
    }

    public static void addStudent (){

    }

}
