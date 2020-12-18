import javax.swing.*;
import java.awt.*;

public class GUI {

    JFrame frame;
    JPanel panel;

    Controller controller;

    ProfessorController professorController;
    StudentController studentController;
    AdminController adminController;

    LoginPanel loginPanel = new LoginPanel();
    ProfessorPanel professorPanel  = new ProfessorPanel();
    StudentPanel studentPanel = new StudentPanel();
    AdminPanel adminPanel = new AdminPanel();

    public GUI (){
        frame = new JFrame("Portal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(300, 200);
        frame.setSize(1000,500);
        panel = new JPanel();

        //////////////////////////////////
        frame.setContentPane(panel);
        panel.add(loginPanel);

//        professorController = new ProfessorController(professorPanel, null);
//        frame.setContentPane(professorController.view);

//        studentController = new StudentController(studentPanel, null);
//        frame.setContentPane(studentController.view);

//        adminController = new AdminController(adminPanel, null);
//        frame.setContentPane(adminController.view);

        frame.setVisible(true);
    }

    public void setController (Controller controller2){
        controller = controller2;

    }




}
