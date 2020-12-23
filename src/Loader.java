import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Loader {

    private FileInputStream loader;
    private Scanner textReader;
    private Model model;
    private final String adminDir = "./Files/AdminFile/admin";
    private final String profsDir = "./Files/ProfessorsFile";
    private final String stdsDir = "./Files/StudentsFile";

    public Loader (Model model){
        this.model = model;
//        loadAdmin(model);
//        loadProfs(model);
//        loadStudents(model);
//        try {
//            loader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (NullPointerException e){
//            e.printStackTrace();
//        }
    }

    public boolean isAdminSaved (){
        return (Files.exists(Paths.get(adminDir)));
    }

    public void loadAdmin (){
        try {
            loader = new FileInputStream(adminDir);
            ObjectInputStream oi = new ObjectInputStream(loader);
            Admin admin = (Admin) oi.readObject();
            model.loadAdmin(admin);
        } catch (FileNotFoundException e) {
            System.err.println("Can't Load file");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }/*finally {
            try {
                loader.close();
            } catch (Exception e) {
                System.err.println("Can't close");
            }
        }*/
        }


    public void loadProfs (Model model){
        try {
            File[] files = new File(profsDir).listFiles();
            Professor tmpProf;
            ArrayList<Professor> professors = new ArrayList<>();
            ObjectInputStream oi;
            Object object;
            if (files == null)
                return;
            for (File f : files){
                loader = new FileInputStream(f);
                oi = new ObjectInputStream(loader);
                object = oi.readObject();
                while (object != null){
                    tmpProf = (Professor) object;
                    professors.add(tmpProf);
                    object = oi.readObject();
                }
            }
            model.loadProfs(professors);
        } catch (FileNotFoundException e) {
            System.err.println("Can't Load file");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } /*finally {
            try {
                loader.close();
            } catch (Exception e) {
                System.err.println("Can't close");
            }
        }*/
    }

    public void loadStudents (Model model){
        try {
            File[] files = new File(stdsDir).listFiles();
            Student tmpStd;
            ArrayList<Student> students = new ArrayList<>();
            ObjectInputStream oi;
            Object object;
            if (files == null)
                return;
            for (File f : files){
                loader = new FileInputStream(f);
                oi = new ObjectInputStream(loader);
                object = oi.readObject();
                while (object != null){
                    tmpStd = (Student) object;
                    students.add(tmpStd);
                    object = oi.readObject();
                }
            }
            model.loadStds(students);
        } catch (FileNotFoundException e) {
            System.err.println("Can't Load file");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } /*finally {
            try {
                loader.close();
            } catch (Exception e) {
                System.err.println("Can't close");
            }
        }*/
    }



}
