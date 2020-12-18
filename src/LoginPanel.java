import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    JTextField textField;
    JPasswordField passwordField;
    JButton button;

    public LoginPanel (){
        super();
        this.setLayout(new BorderLayout());
        textField = new JTextField();
        passwordField = new JPasswordField();
        button = new JButton("Login");
        JLabel usernameLabel = new JLabel("username:");
        JLabel passLabel = new JLabel("password:");
        JPanel centerPanel = new JPanel(new GridLayout(2,2,2,2));
        centerPanel.add(usernameLabel);
        centerPanel.add(textField);
        centerPanel.add(passLabel);
        centerPanel.add(passwordField);
        JPanel p = new JPanel(new BorderLayout());
        p.add(centerPanel, BorderLayout.CENTER);
        p.add(button, BorderLayout.SOUTH);
        this.add(p, BorderLayout.CENTER);
        this.setSize(400,400);

    }





}
