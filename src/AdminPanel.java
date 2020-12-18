import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JPanel {

    //change
    JButton changeUsername = new JButton("change username");
    JTextField newUsername = new JTextField();
    JButton changeUn = new JButton("change");
    JButton changePassword = new JButton("change password");
    JPasswordField newPassword = new JPasswordField();
    JButton changePw = new JButton("change");

    JButton showClasses = new JButton("show classes");
    JButton showProfessors = new JButton("show professors");
    JButton showStudents = new JButton("show students");

    JButton selectFoods = new JButton("select foods");

    //add
    JButton addProfessor = new JButton("add a professor");
    JTextField profUsername = new JTextField();
    JTextField profPassword = new JTextField();
    JButton addProfessor2 = new JButton("add");
    JButton addStudent = new JButton("add a student");
    JTextField stdUsername = new JTextField();
    JTextField stdPassword = new JTextField();
    JButton addStudent2 = new JButton("add");

    JList<String> classes;
    JList<String> students;
    JList<String> professors;
    JPanel centerPanel = new JPanel();
    AdminController controller;

    public AdminPanel (){
        super();
        this.setLayout(new BorderLayout());
        classes = new JList<>();
        students = new JList<>();
        professors = new JList<>();
        setEast();
        setNorth();
        listen();
    }

    public void setController (AdminController controller2){
        controller = controller2;
        showClasses.addActionListener(controller);
        showStudents.addActionListener(controller);
        showProfessors.addActionListener(controller);
        selectFoods.addActionListener(controller);
    }

    public void setNorth (){
        JPanel northPanel = new JPanel(new GridLayout(1,4));
        northPanel.add(new JLabel("username:"));
//        northPanel.add(new JLabel(controller.getUsername()));
        northPanel.add(new JLabel("password:"));
//        northPanel.add(new JLabel(controller.getPassword()));
        this.add(northPanel, BorderLayout.NORTH);
    }

    public void setEast (){
        JPanel buttons = new JPanel(new GridLayout(8,1));
        buttons.add(changeUsername);
        buttons.add(changePassword);
        buttons.add(selectFoods);
        buttons.add(showClasses);
        buttons.add(showProfessors);
        buttons.add(showStudents);
        buttons.add(addProfessor);
        buttons.add(addStudent);
        this.add(buttons, BorderLayout.EAST);
    }

    public void listen (){
        JPanel change = new JPanel(new GridLayout(2,2));
        change.setSize(400,400);
        changeUsername.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change.removeAll();
                change.revalidate();
                change.repaint();
                change.add(new JLabel("new username:"));
                change.add(newUsername);
                change.add(changeUn);
                centerPanel.removeAll();
                centerPanel.add(change);
                centerPanel.revalidate();
                centerPanel.repaint();
                AdminPanel.this.revalidate();
                AdminPanel.this.repaint();
                centerPanel.setSize(400,400);
                AdminPanel.this.add(centerPanel, BorderLayout.CENTER);
                AdminPanel.this.revalidate();
                AdminPanel.this.repaint();
            }
        });

        changePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change.removeAll();
                change.revalidate();
                change.repaint();
                change.add(new JLabel("new password:"));
                change.add(newPassword);
                change.add(changePw);
                centerPanel.removeAll();
                centerPanel.add(change);
                centerPanel.revalidate();
                centerPanel.repaint();
                AdminPanel.this.revalidate();
                AdminPanel.this.repaint();
                centerPanel.setSize(400,400);
                AdminPanel.this.add(centerPanel, BorderLayout.CENTER);
                AdminPanel.this.revalidate();
                AdminPanel.this.repaint();
            }
        });

        JPanel newUser = new JPanel(new GridLayout(3,2));
        newUser.setSize(400,800);
        addProfessor.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newUser.removeAll();
                newUser.add(new JLabel("username:"));
                newUser.add(profUsername);
                newUser.add(new JLabel("password:"));
                newUser.add(profPassword);
                newUser.add(addProfessor2);
                newUser.revalidate();
                newUser.repaint();
                centerPanel.removeAll();
                centerPanel.add(newUser);
                updateCenter(400,800);
            }
        });

        addStudent.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newUser.removeAll();
                newUser.add(new JLabel("username:"));
                newUser.add(stdUsername);
                newUser.add(new JLabel("password:"));
                newUser.add(stdPassword);
                newUser.add(addStudent2);
                newUser.revalidate();
                newUser.repaint();
                centerPanel.removeAll();
                centerPanel.add(newUser);
                updateCenter(400,800);
            }
        });

    }

    public void updateCenter (int width, int height){
        centerPanel.revalidate();
        centerPanel.repaint();
        AdminPanel.this.revalidate();
        AdminPanel.this.repaint();
        centerPanel.setSize(width,height);
        AdminPanel.this.add(centerPanel, BorderLayout.CENTER);
        AdminPanel.this.revalidate();
        AdminPanel.this.repaint();
    }

}
