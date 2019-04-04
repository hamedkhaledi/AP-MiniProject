package Controller;

import Model.Admin;
import Model.ClassRoom;
import Model.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TeacherPageController {


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
        if (NewUsernameFiled.getText().isEmpty()) {
            WrongLabel.setText("Fill all items");
            WrongLabel.setVisible(true);
        } else if (!Admin.getAdmin().UserName.equals(PreviousUsernameFiled.getText()) && !Admin.getAdmin().Password.equals(PreviousPasswordFiled.getText())) {
            WrongLabel.setText("Password Or Username does`nt match");
            WrongLabel.setVisible(true);
        } else if (NewPasswordFiled.getText().length() < 6) {
            WrongLabel.setText("Password must be 6 character at least");
            WrongLabel.setVisible(true);
        } else if (!NewPasswordFiled.getText().equals(RepeatPasswordFiled.getText())) {
            WrongLabel.setText("Passwords do not equal");
            WrongLabel.setVisible(true);
        } else {
            Admin.getAdmin().UserName = NewUsernameFiled.getText();
            Admin.getAdmin().Password = NewPasswordFiled.getText();
            WrongLabel.setText("Changing Profile completed");
            WrongLabel.setVisible(true);
        }
    }

    /**
     * Class Sumbit
     */
    @FXML
    public MenuButton DayMenuButton;
    @FXML
    public TextField ClassNameField;
    @FXML
    public TextField CapacityField;
    @FXML
    public Label ClassWrongLabel;
    @FXML
    public TextField NumberOfUnitsField;
    private ClassRoom.Days day;
    private ClassRoom.time clock;

    public void SetTimeSaturday(ActionEvent actionEvent) {
        day = ClassRoom.Days.Saturday;
    }

    public void SetTimeSunday(ActionEvent actionEvent) {
        day = ClassRoom.Days.Sunday;
    }

    public void SetTimeMonday(ActionEvent actionEvent) {
        day = ClassRoom.Days.Monday;
    }

    public void SetTimeTuesday(ActionEvent actionEvent) {
        day = ClassRoom.Days.Tuesday;
    }

    public void SetTimeWednesday(ActionEvent actionEvent) {
        day = ClassRoom.Days.Wednesday;
    }

    public void SetTime8to10(ActionEvent actionEvent) {
        clock = ClassRoom.time.Eight_Ten;
    }

    public void SetTime10to12(ActionEvent actionEvent) {
        clock = ClassRoom.time.Ten_Twelve;
    }

    public void SetTime14to16(ActionEvent actionEvent) {
        clock = ClassRoom.time.Two_Four;
    }

    public void ClassSubmitClick(ActionEvent actionEvent) {
        if (ClassNameField.getText().isEmpty()) {
            ClassWrongLabel.setText("Fill all elements");
            ClassWrongLabel.setVisible(true);
        } else if (CapacityField.getText().isEmpty()) {
            ClassWrongLabel.setText("Fill all elements");
            ClassWrongLabel.setVisible(true);
        } else if (NumberOfUnitsField.getText().isEmpty()) {
            ClassWrongLabel.setText("Fill all elements");
            ClassWrongLabel.setVisible(true);
        } else if (!NumberOfUnitsField.getText().matches("[0-9]+")) {
            ClassWrongLabel.setText("Fill number of units field with numbers");
            ClassWrongLabel.setVisible(true);
        } else if (!CapacityField.getText().matches("[0-9]+")) {
            ClassWrongLabel.setText("Fill capacity field with numbers");
            ClassWrongLabel.setVisible(true);
        } else if (day == null && clock == null) {
            ClassWrongLabel.setText("select all menu button items");
            ClassWrongLabel.setVisible(true);
        } else {
            ClassWrongLabel.setVisible(false);
            for (int i = 0; i < Admin.Teachers.size(); i++) {
                if (Admin.Teachers.get(i).equals(MainPageController.InputUsername)) {
                    ClassRoom Temp = new ClassRoom();
                    Temp.Capacity = Integer.parseInt(CapacityField.getText());
                    Temp.NumberOfUnits = Integer.parseInt(NumberOfUnitsField.getText());
                    Temp.Name = ClassNameField.getText();
                    Temp.Day = day;
                    Temp.Time = clock;
                    Admin.Teachers.get(i).classRooms.add(Temp);
                    break;
                }
            }
        }
    }
}
