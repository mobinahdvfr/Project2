import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentPanel extends JPanel {

    StudentController controller;
    //change
    JButton changeUsername = new JButton("change username");
    JTextField newUsername = new JTextField();
    JButton changeUn = new JButton("change");
    JButton changePassword = new JButton("change password");
    JPasswordField newPassword = new JPasswordField();
    JButton changePw = new JButton("change");

    JButton showClasses = new JButton("show classes");
    JButton selectClass = new JButton("select class");
    JButton showFoods = new JButton("show foods");
    //charge
    JButton charge = new JButton("charge");
    JTextField cardNum = new JTextField();
    JPasswordField cardPass = new JPasswordField();
    JTextField amount = new JTextField();
    JButton charge2 = new JButton("charge");

    JList<String> classes;
    JPanel centerPanel = new JPanel();


    public StudentPanel (){
        super();
        this.setLayout(new BorderLayout());
        setEast();
        setNorth();
        classes = new JList<>();
        listen();
    }

    public void setController (StudentController controller2){
        controller = controller2;
        showClasses.addActionListener(controller);
        showFoods.addActionListener(controller);
        changeUn.addActionListener(controller);
        changePw.addActionListener(controller);
        charge2.addActionListener(controller);
        selectClass.addActionListener(controller);
    }

    public void setNorth (){
        JPanel northPanel = new JPanel(new GridLayout(1,8));
        northPanel.add(new JLabel("username:"));
//        northPanel.add(new JLabel(controller.getUsername()));
        northPanel.add(new JLabel("password:"));
//        northPanel.add(new JLabel(controller.getPassword()));
        northPanel.add(new JLabel("money:"));
//        northPanel.add(new JLabel(controller.getMoney()+ ""));
        northPanel.add(new JLabel("average:"));
//        northPanel.add(new JLabel(controller.getAverage() + ""));
        this.add(northPanel, BorderLayout.NORTH);
    }

    public void setEast (){
        JPanel buttons = new JPanel(new GridLayout(6,1));
        buttons.add(changeUsername);
        buttons.add(changePassword);
        buttons.add(showClasses);
        buttons.add(charge);
        this.add(buttons, BorderLayout.EAST);
    }


    public void listen (){
        JPanel change = new JPanel(new GridLayout(2,2));
        change.setSize(400,400);
        changeUsername.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change.removeAll();
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
                change.add(new JLabel("new password:"));
                change.add(newPassword);
                change.add(changePw);
                centerPanel.removeAll();
                centerPanel.add(change);
                updateCenter(400,400);
            }
        });

        JPanel chargeP = new JPanel(new GridLayout(4,2));
        charge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chargeP.removeAll();
                chargeP.add(new JLabel("card number:"));
                chargeP.add(cardNum);
                chargeP.add(new JLabel("enter amount:"));
                chargeP.add(amount);
                chargeP.add(new JLabel("enter password:"));
                chargeP.add(cardPass);
                chargeP.add(charge2);
                centerPanel.removeAll();
                centerPanel.add(chargeP);
                updateCenter(400,800);

            }
        });

    }

    public void updateCenter (int width, int height){
        centerPanel.revalidate();
        centerPanel.repaint();
        StudentPanel.this.revalidate();
        StudentPanel.this.repaint();
        centerPanel.setSize(width,height);
        StudentPanel.this.add(centerPanel, BorderLayout.CENTER);
        StudentPanel.this.revalidate();
        StudentPanel.this.repaint();
    }


}
