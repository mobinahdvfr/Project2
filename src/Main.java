import java.io.*;

public class Main {

    public static void main(String[] args) {
        GUI gui = new GUI();
        Model model = new Model();
        GUIController guiController = new GUIController(gui, model);

//        System.out.println(guiController.loader.isAdminSaved());
//        guiController.loader.loadAdmin();
//        if (!guiController.adminSaved())
//            model.setAdmin(new Admin("mobina", "123"));
        gui.show();
//        if (model.getAdmin() != null){
//            System.out.println("boogh");
//        }

    }
}
