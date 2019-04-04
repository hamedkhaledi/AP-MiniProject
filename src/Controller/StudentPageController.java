package Controller;

import Model.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class StudentPageController {
    @FXML
    private TextField PreviousUsernameFiled;
    @FXML
    private TextField NewUsernameFiled;
    @FXML
    private PasswordField PreviousPasswordFiled;
    @FXML
    private PasswordField NewPasswordFiled;
    @FXML
    private PasswordField RepeatPasswordFiled;
    @FXML
    private Label WrongLabel;
    @FXML
    private Button SubmitButton;

    /**
     * Profile Submit
     */
    public void SubmitClick(ActionEvent actionEvent) throws Exception {
//        if (NewUsernameFiled.getText().isEmpty()) {
//            WrongLabel.setText("Fill all items");
//            WrongLabel.setVisible(true);
//        } else if (!Admin.getAdmin().UserName.equals(PreviousUsernameFiled.getText()) && !Admin.getAdmin().Password.equals(PreviousPasswordFiled.getText())) {
//            WrongLabel.setText("Password Or Username does`nt match");
//            WrongLabel.setVisible(true);
//        } else if (NewPasswordFiled.getText().length() < 6) {
//            WrongLabel.setText("Password must be 6 character at least");
//            WrongLabel.setVisible(true);
//        } else if (!NewPasswordFiled.getText().equals(RepeatPasswordFiled.getText())) {
//            WrongLabel.setText("Passwords do not equal");
//            WrongLabel.setVisible(true);
//        } else {
//            Admin.getAdmin().UserName = NewUsernameFiled.getText();
//            Admin.getAdmin().Password = NewPasswordFiled.getText();
//            WrongLabel.setText("Changing Profile completed");
//            WrongLabel.setVisible(true);
//        }
        //ToDo
    }


}
