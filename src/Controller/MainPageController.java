package Controller;

import javafx.event.ActionEvent;
import Model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MainPageController {
    @FXML
    public Label WrongLabel;
    @FXML
    private TextField UsernameField;
    @FXML
    private PasswordField passField;
    public static String InputUsername;
    public static String InputPassword;
    public static int number;
    public static boolean SignInflag = false;

    public void ClickSigninPageButton(ActionEvent actionEvent) throws Exception {
        if (UsernameField.getText().equals("admin") && passField.getText().equals("admin")) {
            new PageLoader().load("../View/AdminPage.fxml");
        } else {
            for (int i = 0; i < Admin.Teachers.size(); i++) {
                if (UsernameField.getText().equals(Admin.Teachers.get(i).Username) && passField.getText().equals(Admin.Teachers.get(i).Password)) {
                    new PageLoader().load("../View/TeacherPage.fxml");
                    number = i;
                    SignInflag = true;
                    break;
                }
            }
            for (int i = 0; i < Admin.Students.size(); i++) {
                if (UsernameField.getText().equals(Admin.Students.get(i).Username) && passField.getText().equals(Admin.Students.get(i).Password)) {
                    new PageLoader().load("../View/StudentPage.fxml");
                    number = i;
                    SignInflag = true;
                    break;
                }
            }
        }
        if (!SignInflag)
        {
            WrongLabel.setVisible(true);
            WrongLabel.setText("Who Are you ? :)");
        }
    }

    public void SignUpClick(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../View/SignUpPage.fxml");
    }
}

