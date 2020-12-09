import javax.swing.*;
import java.awt.*;

public class GUI {

    JFrame frame;
    LoginPanel loginPanel;
    ProfessorPanel professorPanel;
    StudentPanel studentPanel;
    AdminPanel adminPanel;

    public GUI (){
        frame = new JFrame("Portal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        loginPanel = new LoginPanel();
        //////////////////////////////////
        frame.setContentPane(loginPanel);
        frame.setVisible(true);
    }




}
