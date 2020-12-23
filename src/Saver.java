import java.io.*;
import java.nio.file.Path;

public class Saver {

    private FileOutputStream writer;
    private Model model;
    private final String adminDir = "./Files/AdminFile/admin";
    private final String profsDir = "./Files/ProfessorsFile";
    private final String stdsDir = "./Files/StudentsFile";

    public Saver (Model model){
        this.model = model;
//        saveAdmin(model);
//        saveProfs(model);
//        saveStds(model);
//        try {
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void saveAdmin (){
        try {
            File file = new File(adminDir);
            writer = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(writer);
            o.writeObject(model.getAdmin());
//            o.close();
//            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeUsername (File file, String newUsername){
        try {
            Path path = file.toPath();
            file.delete();
            writer = new FileOutputStream(new File(String.valueOf(path)));
            ObjectOutputStream o = new ObjectOutputStream(writer);
            o.writeObject(model.getAdmin());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveProfs (Model model){
        try {
            writer = new FileOutputStream(new File(profsDir));
            ObjectOutputStream o = new ObjectOutputStream(writer);
            for (Professor p : model.getProfessors()) {
                o.writeObject(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveStds (Model model){
        try {
            writer = new FileOutputStream(new File(stdsDir));
            ObjectOutputStream o = new ObjectOutputStream(writer);
            for (Student s : model.getStudents()) {
                o.writeObject(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
