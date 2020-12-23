import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProfessorPanel extends JPanel {

    ProfessorController controller;
    //change
    JButton changeUsername = new JButton("change username");
    JTextField newUsername = new JTextField();
    JButton changeUn = new JButton("change");
    JButton changePassword = new JButton("change password");
    JPasswordField newPassword = new JPasswordField();
    JButton changePw = new JButton("change");
    //new class
    JButton makeClass = new JButton("make a class");
    JTextField className = new JTextField();
    JTextField classUnitsNum = new JTextField();
    JTextField classCapacity = new JTextField();
    JCheckBox sat = new JCheckBox("Sat");
    JCheckBox sun = new JCheckBox("Sun");
    JCheckBox mon = new JCheckBox("Mon");
    JCheckBox tue = new JCheckBox("Tue");
    JCheckBox wed = new JCheckBox("Wed");
    JRadioButton time1 = new JRadioButton("8-10");
    JRadioButton time2 = new JRadioButton("10-12");
    JRadioButton time3 = new JRadioButton("14-16");
    JButton makeClass2 = new JButton("make");

    JButton closeClass = new JButton("close a class");
    JButton showStudents = new JButton("show students");
    JButton changeScore = new JButton("set score");
    JButton showInfo = new JButton("show info");
    JButton showClasses = new JButton("show classes");
    JButton showStudents2 = new JButton("show students");

    JList<String> classes;
    JList<String> students;
    JPanel centerPanel = new JPanel();


    public ProfessorPanel (){
        super();
        this.setLayout(new BorderLayout());
        setEast();
        classes = new JList<>();
        students = new JList<>();
        ButtonGroup bg = new ButtonGroup();
        bg.add(time1);
        bg.add(time2);
        bg.add(time3);
        listen();
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
        JPanel buttons = new JPanel(new GridLayout(6,1));
        buttons.add(changeUsername);
        buttons.add(changePassword);
        buttons.add(makeClass);
        buttons.add(showClasses);
        buttons.add(showStudents);
        this.add(buttons, BorderLayout.EAST);
    }

    public void setController (ProfessorController controller){
        this.controller = controller;
        showClasses.addActionListener(controller);
        showStudents.addActionListener(controller);
        showStudents2.addActionListener(controller);
        closeClass.addActionListener(controller);
        changeScore.addActionListener(controller);
        showInfo.addActionListener(controller);
        classes.addListSelectionListener(controller);
        setNorth();
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
                updateCenter(400,400);
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
                updateCenter(400,400);
            }
        });

        JPanel newClass = new JPanel(new GridLayout(9,2));

        makeClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newClass.removeAll();
                newClass.add(new JLabel("class's name:"));
                newClass.add(className);
                newClass.add(new JLabel("number of units:"));
                newClass.add(classUnitsNum);
                newClass.add(new JLabel("enter capacity:"));
                newClass.add(classCapacity);
                newClass.add(new JLabel("select days"));
                newClass.add(sat);
                newClass.add(sun);
                newClass.add(mon);
                newClass.add(tue);
                newClass.add(wed);
                newClass.add(new JLabel("select a time"));
                newClass.add(time1);
                newClass.add(time2);
                newClass.add(time3);
                newClass.add(makeClass2);
                centerPanel.removeAll();
                centerPanel.add(newClass);
                updateCenter(400,800);
            }
        });


    }

    public void updateCenter (int width, int height){
        centerPanel.revalidate();
        centerPanel.repaint();
        ProfessorPanel.this.revalidate();
        ProfessorPanel.this.repaint();
        centerPanel.setSize(width,height);
        ProfessorPanel.this.add(centerPanel, BorderLayout.CENTER);
        ProfessorPanel.this.revalidate();
        ProfessorPanel.this.repaint();
    }

}
