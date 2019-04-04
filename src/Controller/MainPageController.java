package Controller;

import javafx.event.ActionEvent;
import Model.*;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MainPageController {
    @FXML
    private TextField UsernameField;
    @FXML
    private PasswordField passField;
    public static String InputUsername;
    public static String InputPassword;
    public void ClickSigninPageButton(ActionEvent actionEvent) throws Exception {
        if (UsernameField.getText().equals("admin") && passField.getText().equals("admin")) {
            new PageLoader().load("../View/AdminPage.fxml");
        } else if (UsernameField.getText().equals("2") && passField.getText().equals("2")) {
            new PageLoader().load("../View/TeacherPage.fxml");

        }
    }
}
