import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController implements ActionListener {

    AdminPanel view;
    Admin model;

    public AdminController (AdminPanel view, Admin model){
        this.view = view;
        this.model = model;
        this.view.setController(this);
    }

    public void setUsername (String in ){
        model.setUsername(in);
    }

    public void setModel (Admin admin){
        model = admin;
    }

    public String getUsername (){
        return model.getUsername();
    }

    public String getPassword (){
        return model.getPassword();
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

    public void setStudentsJList (){
//        if (currentUser.getClasses().size() != 0) {
//            DefaultListModel<String> tmpList = new DefaultListModel<>();
//            for (UniClass u : currentUser.getClasses()) {
//                for (Student s : currentUser.getClassesAndStudents().get(u)) {
//                    tmpList.addElement(s.getUsername());
//                }
//            }
//            view.students = new JList<>(tmpList);
//        } else

        DefaultListModel<String> tmpList = new DefaultListModel<>();
        tmpList.addElement("d");
        tmpList.addElement("d");

        view.students = new JList<>(tmpList);
    }

    public void setProfessorsJList (){
//        if (currentUser.getClasses().size() != 0) {
//            DefaultListModel<String> tmpList = new DefaultListModel<>();
//            for (UniClass u : currentUser.getClasses()) {
//                for (Student s : currentUser.getClassesAndStudents().get(u)) {
//                    tmpList.addElement(s.getUsername());
//                }
//            }
//            view.students = new JList<>(tmpList);
//        } else

        DefaultListModel<String> tmpList = new DefaultListModel<>();
        tmpList.addElement("d");
        tmpList.addElement("d");

        view.students = new JList<>(tmpList);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.showClasses){
            setClassesJList();
            view.centerPanel.removeAll();
            view.centerPanel.add(new JScrollPane(view.classes));
            view.centerPanel.revalidate();
            view.centerPanel.repaint();
            view.add(view.centerPanel, BorderLayout.CENTER);
            view.revalidate();
            view.repaint();
        }

        else if (e.getSource() == view.showStudents){
            setStudentsJList();
            view.centerPanel.removeAll();
            view.centerPanel.add(new JScrollPane(view.students));
            view.centerPanel.revalidate();
            view.centerPanel.repaint();
            view.add(view.centerPanel, BorderLayout.CENTER);
            view.revalidate();
            view.repaint();
        }

        else if (e.getSource() == view.showProfessors){
            setProfessorsJList();
            view.centerPanel.removeAll();
            view.centerPanel.add(new JScrollPane(view.professors));
            view.centerPanel.revalidate();
            view.centerPanel.repaint();
            view.add(view.centerPanel, BorderLayout.CENTER);
            view.revalidate();
            view.repaint();
        }

        else if (e.getSource() == view.selectFoods){
            view.centerPanel.removeAll();
            view.centerPanel.revalidate();
            view.centerPanel.repaint();
        }
    }
}
