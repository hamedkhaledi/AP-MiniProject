package Controller;

import Model.Admin;
import Model.PageLoader;
import Model.Student;
import Model.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private TextField NewUsernameFiled;
    @FXML
    private PasswordField NewPasswordFiled;
    @FXML
    private PasswordField RepeatPasswordFiled;
    @FXML
    private Label WrongLabel;
    private String job;
    private boolean SignUpflag;


    /**
     * Profile Submit
     */
    public void SubmitClick(ActionEvent actionEvent) throws Exception {
        if (NewUsernameFiled.getText().isEmpty()) {
            WrongLabel.setText("Fill all items");
            WrongLabel.setVisible(true);
        } else if (job == null) {
            WrongLabel.setText("Select your job");
            WrongLabel.setVisible(true);
        } else if (NewPasswordFiled.getText().length() < 6) {
            WrongLabel.setText("Password must be 6 character at least");
            WrongLabel.setVisible(true);
        } else if (!NewPasswordFiled.getText().equals(RepeatPasswordFiled.getText())) {
            WrongLabel.setText("Passwords do not equal");
            WrongLabel.setVisible(true);
        } else {
            SignUpflag = false;
            for (int i = 0; i < Admin.Teachers.size(); i++) {
                if (NewUsernameFiled.getText().equals(Admin.Teachers.get(i).Username)) {
                    SignUpflag = true;
                    break;
                }
            }
            for (int i = 0; i < Admin.Students.size(); i++) {
                if (NewUsernameFiled.getText().equals(Admin.Students.get(i).Username)) {
                    SignUpflag = true;
                    break;
                }
            }
            if (SignUpflag) {
                WrongLabel.setText("This username has exist");
                WrongLabel.setVisible(true);
            } else {
                if (job.equals("Student")) {
                    Student Temp = new Student();
                    Temp.Username = NewUsernameFiled.getText();
                    Temp.Password = NewPasswordFiled.getText();
                    Admin.Students.add(Temp);
                } else {
                    Teacher Temp = new Teacher();
                    Temp.Username = NewUsernameFiled.getText();
                    Temp.Password = NewPasswordFiled.getText();
                    Admin.Teachers.add(Temp);
                }
                new PageLoader().load("../View/sample.fxml");
            }
        }

    }

    public void StudentClick(ActionEvent actionEvent) {
        job = "Student";
    }

    public void TeacherClick(ActionEvent actionEvent) {
        job = "Teacher";
    }

    public void BackClick(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../View/sample.fxml");
    }
}
