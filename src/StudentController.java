import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentController implements ActionListener {

    StudentPanel view;
    ArrayList<Student> model;
    Student currentUser;

    public StudentController (StudentPanel view, ArrayList<Student> model){
        this.view = view;
        this.model = model;
        this.view.setController(this);
    }

    public String getUsername (){
        return currentUser.getUsername();
    }

    public String getPassword (){
        return currentUser.getPassword();
    }

    public int getMoney (){
        return currentUser.getMoney();
    }

    public double getAverage (){
        return currentUser.getAverage();
    }

    public void setClassesJList (){
//        if (currentUser.getClasses() != null) {
//            for (UniClass uniClass : currentUser.getClasses()) {
//                tmpList.addElement(uniClass.getName());
//            }
//            view.classes = new JList<>(tmpList);
//        } else

        DefaultListModel<String> tmpList = new DefaultListModel<>();
        tmpList.addElement("m");
        view.classes = new JList<>(tmpList);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.showClasses){
            System.out.println("clicked");
            setClassesJList();
            view.centerPanel.removeAll();
            view.centerPanel.add(new JScrollPane(view.classes));
            view.centerPanel.add(view.selectClass);
            view.centerPanel.revalidate();
            view.centerPanel.repaint();
            view.add(view.centerPanel, BorderLayout.CENTER);
            view.revalidate();
            view.repaint();
        }

//        else if (e.getSource() == view.selectClass) {
//
//        }
    }
}
