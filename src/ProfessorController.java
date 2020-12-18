import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProfessorController implements ActionListener, ListSelectionListener {

    ProfessorPanel view;
    ArrayList<Professor> model;
    Professor currentUser;

    public ProfessorController (ProfessorPanel view, ArrayList<Professor> model){
        this.model = model;
        this.view = view;
        this.view.setController(this);
//        setClassesJList();
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

    public void setStudentsJList (int index){
//        if (currentUser.getStudents(index) != null) {
//            DefaultListModel<String> tmpList = new DefaultListModel<>();
//            for (Student student : currentUser.getStudents(index)) {
//                tmpList.addElement(student.getUsername());
//            }
//            view.students = new JList<>(tmpList);
//        } else

        DefaultListModel<String> tmpList = new DefaultListModel<>();
        tmpList.addElement("d");
        tmpList.addElement("d");

        view.students = new JList<>(tmpList);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.showClasses){
            System.out.println("clicked");
            setClassesJList();
            view.centerPanel.removeAll();
            view.centerPanel.revalidate();
            view.centerPanel.repaint();
            view.centerPanel.add(new JScrollPane(view.classes));
            view.centerPanel.add(view.showStudents2);
            view.centerPanel.add(view.closeClass);
            view.centerPanel.revalidate();
            view.centerPanel.repaint();
            view.add(view.centerPanel, BorderLayout.CENTER);
            view.revalidate();
            view.repaint();
        }

        else if (e.getSource() == view.showStudents){
            System.out.println("clicked");
            setStudentsJList();
            view.centerPanel.removeAll();
            view.centerPanel.revalidate();
            view.centerPanel.repaint();
            view.centerPanel.add(new JScrollPane(view.students));
            view.centerPanel.add(view.showInfo);
            view.centerPanel.revalidate();
            view.centerPanel.repaint();
            view.add(view.centerPanel, BorderLayout.CENTER);
            view.revalidate();
            view.repaint();
        }

        else if (e.getSource() == view.showStudents2){
            int index = view.classes.getSelectedIndex();
            setStudentsJList(index);
            view.centerPanel.removeAll();
            view.centerPanel.revalidate();
            view.centerPanel.repaint();
            view.centerPanel.add(new JScrollPane(view.students));
            view.centerPanel.add(view.showInfo);
            view.centerPanel.revalidate();
            view.centerPanel.repaint();
            view.add(view.centerPanel, BorderLayout.CENTER);
            view.revalidate();
            view.repaint();
        }

        else if (e.getSource() == view.closeClass){
            int index = view.classes.getSelectedIndex();
            deleteClass(index);

        }

        else if (e.getSource() == view.showInfo){
            int index = view.students.getSelectedIndex();
            showInfo(index);
        }
    }

    public void deleteClass (int index){

    }

    public void showInfo (int index){

    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
//        if (e.getSource() == view.classes){
        System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
            int index = view.classes.getSelectedIndex();
            System.out.println(index + ",,,,");
            setStudentsJList(index);
            view.centerPanel.removeAll();
            view.centerPanel.revalidate();
            view.centerPanel.repaint();
            view.centerPanel.add(new JScrollPane(view.students));
            view.centerPanel.add(view.closeClass);
            view.centerPanel.revalidate();
            view.centerPanel.repaint();
            view.add(view.centerPanel, BorderLayout.CENTER);
            view.revalidate();
            view.repaint();
//        } else if (e.getSource() == view.students){
//            int index = view.classes.getSelectedIndex();
//            setStudentsJList(index);
//            view.centerPanel.removeAll();
//            view.centerPanel.revalidate();
//            view.centerPanel.repaint();
//            view.centerPanel.add(new JScrollPane(view.students));
//            view.centerPanel.revalidate();
//            view.centerPanel.repaint();
//            view.add(view.centerPanel, BorderLayout.CENTER);
//            view.add(view.changeScore, BorderLayout.CENTER);
//            view.revalidate();
//            view.repaint();
//
//        }
    }
}
