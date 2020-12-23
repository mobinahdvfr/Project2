import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Model {

    private Admin admin;
    private ArrayList<Professor> professors;
    private ArrayList<Student> students;
    private String currentUsername;
    private String currentPassword;


    public Model (){
        professors = new ArrayList<>();
//        saver = new Saver(this);
//        loader = new Loader(this);
//        if (adminExists()){
//            loader.loadAdmin();
//        }
        students = new ArrayList<>();
        currentUsername = "";
        currentPassword = "";
    }

    public void setAdmin (Admin admin){
        this.admin = admin;
//        saver.saveAdmin();
    }

    public String getCurrentUsername (){
        return currentUsername;
    }

    public String getCurrentPassword (){
        return currentPassword;
    }

    public File findFile (){
        return new File("./Files/AdminFile/admin");
    }

    public User getCurrentUser (){
        if (admin.getUsername().equals(currentUsername))
            return admin;
        for (Student s : students){
            if (s.getUsername().equals(currentUsername))
                return s;
        }
        for (Professor p : professors){
            if (p.getUsername().equals(currentUsername))
                return p;
        }
        return null;
    }

//    public boolean adminExists (){
//        return loader.isAdminSaved();
//    }
//
//    public void changeUsername (String newUsername){
//        getCurrentUser().setUsername(newUsername);
//        if (getCurrentUser() instanceof Admin)
//            saver.saveAdmin();
//    }

    public void setCurrentUser (String username, String password){
        currentUsername = username;
        currentPassword = password;
    }

    public Admin getAdmin (){
        return admin;
    }

    public ArrayList<Professor> getProfessors (){
        return professors;
    }

    public ArrayList<Student> getStudents (){
        return students;
    }

    public void loadAdmin (Admin admin){
        this.admin = admin;
    }

    public void loadProfs (ArrayList<Professor> professors){
        this.professors = professors;
    }

    public void loadStds (ArrayList<Student> students){
        this.students = students;
    }





}
