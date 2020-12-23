import javax.swing.*;
import java.awt.*;

public class GUI {

    JFrame frame;
    JPanel panel;

    Controller controller;

//    ProfessorController professorController;
//    StudentController studentController;
//    AdminController adminController;

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
        frame.setContentPane(panel);
        panel.add(loginPanel);

    }

    public void update (){
        ((AdminPanel) frame.getContentPane()).updateIt();
        frame.revalidate();
        frame.repaint();
        show();
    }

    public void setAdminPanel (){
//        adminController = new AdminController(adminPanel, null);
//        frame.setContentPane(adminController.view);
        frame.setContentPane(adminPanel);
        show();
    }

    public void setProfessorPanel (){
//        professorController = new ProfessorController(professorPanel, null);
//        frame.setContentPane(professorController.view);
    }

    public void setStudentPanel (){
//        studentController = new StudentController(studentPanel, null);
//        frame.setContentPane(studentController.view);
    }

    public void setController (Controller controller2){
        controller = controller2;

    }

    public void show (){
        frame.setVisible(true);
    }




}
