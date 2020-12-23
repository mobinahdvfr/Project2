import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GUIController implements ActionListener {

    private GUI view;
    private Model model;
    private AdminController adminController;
    private ProfessorController professorController;
    private StudentController studentController;
     Loader loader;
    private Saver saver;

    public GUIController (GUI view, Model model){
        this.model = model;
        loader = new Loader(model);
        saver = new Saver(model);
        loadAdmin();
        this.view = view;
        view.loginPanel.setListener(this);
        adminController = new AdminController(view.adminPanel, model.getAdmin());
        view.adminPanel.setMainController(this);
    }

    public void show (){
        view.show();
    }

    public boolean adminSaved (){
        return loader.isAdminSaved();
    }

    public void loadAdmin (){
        if (loader.isAdminSaved()){
            loader.loadAdmin();
        } else {
            String username = JOptionPane.showInputDialog("enter admin's username:");
            String password = JOptionPane.showInputDialog("enter admin's password:");
            model.setAdmin(new Admin(username, password));
            saver.saveAdmin();
        }
    }

    public String getCurrentUsername (){
        return model.getCurrentUsername();
    }

    public String getCurrentPassword (){
        return model.getCurrentPassword();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.loginPanel.login){
            if ( ! canLogin( view.loginPanel.textField.getText(), view.loginPanel.passwordField.getText() ) ){
                JOptionPane.showMessageDialog(null, "wrong username or password!", "!!", JOptionPane.ERROR_MESSAGE);
            }
        }

        else if (e.getSource() == view.adminPanel.changeUn){
            String tmp = adminController.view.newUsername.getText();
            adminController.model.setUsername(tmp);
            saver.saveAdmin();
            view.update();
        }

        else if (e.getSource() == view.adminPanel.changePw){
            String tmp = adminController.view.newPassword.getText();
            adminController.model.setPassword(tmp);
            saver.saveAdmin();
            view.update();
        }
    }


    public boolean canLogin (String tmpUsername, String tmpPassword){
        if (model.getAdmin() != null) {
            if (tmpUsername.equals(model.getAdmin().getUsername()) && tmpPassword.equals(model.getAdmin().getPassword())) {
                view.setAdminPanel();
                return true;
            }
        }
        if (model.getProfessors().size()>0) {
            for (Professor p : model.getProfessors()) {
                if (tmpUsername.equals(p.getUsername()) && tmpPassword.equals(p.getPassword())) {
                    view.setProfessorPanel();
                    model.setCurrentUser(tmpUsername, tmpPassword);
                    return true;
                }
            }
        }
        if (model.getStudents().size()>0) {
            for (Student s : model.getStudents()) {
                if (tmpUsername.equals(s.getUsername()) && tmpPassword.equals(s.getPassword())) {
                    view.setStudentPanel();
                    model.setCurrentUser(tmpUsername, tmpPassword);
                    return true;
                }
            }
        }
        return false;
    }
}
