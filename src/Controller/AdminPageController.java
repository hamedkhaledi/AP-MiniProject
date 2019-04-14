package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.concurrent.TimeoutException;

public class AdminPageController {
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
        } else if (!Admin.UserName.equals(PreviousUsernameFiled.getText()) || !Admin.Password.equals(PreviousPasswordFiled.getText())) {
            WrongLabel.setText("Password Or Username does`nt match");
            WrongLabel.setVisible(true);
        } else if (NewPasswordFiled.getText().length() < 6) {
            WrongLabel.setText("Password must be 6 character at least");
            WrongLabel.setVisible(true);
        } else if (!NewPasswordFiled.getText().equals(RepeatPasswordFiled.getText())) {
            WrongLabel.setText("Passwords do not equal");
            WrongLabel.setVisible(true);
        } else {
            Admin.UserName = NewUsernameFiled.getText();
            Admin.Password = NewPasswordFiled.getText();
            WrongLabel.setText("Changing Profile completed");
            WrongLabel.setVisible(true);
        }

    }

    public void LogOutClick(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../View/sample.fxml");
    }

    @FXML
    public TextField SaturdayFood1;
    @FXML
    public TextField SaturdayFood2;
    @FXML
    public TextField SundayFood1;
    @FXML
    public TextField SundayFood2;
    @FXML
    public TextField MondayFood1;
    @FXML
    public TextField MondayFood2;
    @FXML
    public TextField TuesdayFood1;
    @FXML
    public TextField TuesdayFood2;
    @FXML
    public TextField WednesdayFood1;
    @FXML
    public TextField WednesdayFood2;
    @FXML
    public Label DiningLabel;

    public void DiningSubmitClick(ActionEvent actionEvent) {
        if (SaturdayFood1.getText().isEmpty() || SaturdayFood2.getText().isEmpty()) {
            DiningLabel.setText("Fill Saturday Foods");
            DiningLabel.setVisible(true);
        } else if (SundayFood1.getText().isEmpty() || SundayFood2.getText().isEmpty()) {
            DiningLabel.setText("Fill Sunday Foods");
            DiningLabel.setVisible(true);
        } else if (MondayFood1.getText().isEmpty() || MondayFood2.getText().isEmpty()) {
            DiningLabel.setText("Fill Monday Foods");
            DiningLabel.setVisible(true);
        } else if (TuesdayFood1.getText().isEmpty() || TuesdayFood2.getText().isEmpty()) {
            DiningLabel.setText("Fill Tuesday Foods");
            DiningLabel.setVisible(true);
        } else if (WednesdayFood2.getText().isEmpty() || WednesdayFood1.getText().isEmpty()) {
            DiningLabel.setText("Fill Wednesday Foods");
            DiningLabel.setVisible(true);
        } else {
            Food.Food1Array[0] = SaturdayFood1.getText();
            Food.Food1Array[1] = SundayFood1.getText();
            Food.Food1Array[2] = MondayFood1.getText();
            Food.Food1Array[3] = TuesdayFood1.getText();
            Food.Food1Array[4] = WednesdayFood1.getText();
            Food.Food2Array[0] = SaturdayFood2.getText();
            Food.Food2Array[1] = SundayFood2.getText();
            Food.Food2Array[2] = MondayFood2.getText();
            Food.Food2Array[3] = TuesdayFood2.getText();
            Food.Food2Array[4] = WednesdayFood2.getText();
            DiningLabel.setVisible(false);
        }


    }

    /**
     * Library
     */
    @FXML
    public CheckBox GiveToCheckBox;
    @FXML
    public CheckBox CancelReservationCheckBox;
    @FXML
    public Label LibraryWrongLabel;
    @FXML
    public TextField LibraryStudentUsername;
    @FXML
    public TextField PublisherSNameField;
    @FXML
    public TextField AuthorNameField;
    @FXML
    public TextField BookNameField;
    @FXML
    public Button GiveButton;
    @FXML
    public Button CompleteButton;

    public void GiveButtonClick(ActionEvent actionEvent) {
        if (AuthorNameField.getText().isEmpty()) {
            LibraryWrongLabel.setText("Fill all elements");
            LibraryWrongLabel.setVisible(true);
        } else if (PublisherSNameField.getText().isEmpty()) {
            LibraryWrongLabel.setText("Fill all elements");
            LibraryWrongLabel.setVisible(true);
        } else if (BookNameField.getText().isEmpty()) {
            LibraryWrongLabel.setText("Fill all elements");
            LibraryWrongLabel.setVisible(true);
        } else if (LibraryStudentUsername.getText().isEmpty()) {
            LibraryWrongLabel.setText("Fill all elements");
            LibraryWrongLabel.setVisible(true);
        } else {
            boolean flag = false;
            for (int i = 0; i < Admin.Students.size(); i++) {
                if (Admin.Students.get(i).Username.equals(LibraryStudentUsername.getText())) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                boolean flag2 = false;
                for (int i = 0; i < Book.Books.size(); i++) {
                    if (Book.Books.get(i).Name.equals(BookNameField.getText())) {
                        flag2 = true;
                        break;
                    }
                }
                if (!flag2) {
                    LibraryWrongLabel.setText("Complete");
                    LibraryWrongLabel.setVisible(true);
                    Book Temp = new Book();
                    Temp.AuthorName = AuthorNameField.getText();
                    Temp.Name = BookNameField.getText();
                    Temp.PublisherName = PublisherSNameField.getText();
                    Temp.Owner = LibraryStudentUsername.getText();
                    Temp.Resevration = true;
                    Book.Books.add(Temp);
                } else {
                    LibraryWrongLabel.setText("This book exist in library");
                    LibraryWrongLabel.setVisible(true);
                }
            } else {
                LibraryWrongLabel.setText("This student does not exist");
                LibraryWrongLabel.setVisible(true);
            }
        }
    }

    public void CompleteButtonClick(ActionEvent actionEvent) {
        if (AuthorNameField.getText().isEmpty()) {
            LibraryWrongLabel.setText("Fill all elements");
            LibraryWrongLabel.setVisible(true);
        } else if (PublisherSNameField.getText().isEmpty()) {
            LibraryWrongLabel.setText("Fill all elements");
            LibraryWrongLabel.setVisible(true);
        } else if (BookNameField.getText().isEmpty()) {
            LibraryWrongLabel.setText("Fill all elements");
            LibraryWrongLabel.setVisible(true);
        } else {
            boolean flag2 = false;
            for (int i = 0; i < Book.Books.size(); i++) {
                if (Book.Books.get(i).Name.equals(BookNameField.getText())) {
                    flag2 = true;
                    Book.Books.get(i).Resevration = false;
                    Book.Books.get(i).Owner = null;
                    break;
                }
            }
            if (!flag2) {
                LibraryWrongLabel.setText("This book does not exist in library");
                LibraryWrongLabel.setVisible(true);
            } else {
                LibraryWrongLabel.setText("Complete");
                LibraryWrongLabel.setVisible(true);
            }
        }
    }

    public void GiveToCheckBoxClick(ActionEvent actionEvent) {
        LibraryWrongLabel.setVisible(false);
        if (!CancelReservationCheckBox.isSelected()) {
            if (GiveToCheckBox.isSelected()) {
                LibraryStudentUsername.setVisible(true);
                GiveButton.setVisible(true);
            } else {
                LibraryStudentUsername.setVisible(false);
                GiveButton.setVisible(false);
            }
        } else {
            GiveToCheckBox.setSelected(false);
            LibraryWrongLabel.setText("Disable Cancel reservation CheckBox ");
            LibraryWrongLabel.setVisible(true);
        }

    }

    public void CancelReservationCheckBoxClick(ActionEvent actionEvent) {
        LibraryWrongLabel.setVisible(false);
        if (!GiveToCheckBox.isSelected()) {
            if (CancelReservationCheckBox.isSelected()) {
                LibraryStudentUsername.setVisible(false);
                CompleteButton.setVisible(true);
            } else {
                CompleteButton.setVisible(false);
            }
        } else {
            CancelReservationCheckBox.setSelected(false);
            LibraryWrongLabel.setText("Disable Give To CheckBox ");
            LibraryWrongLabel.setVisible(true);
        }
    }

    @FXML
    public TextArea UniversityTextArea;

    public void ShowButtonClick(ActionEvent actionEvent) {
        String Temp = "";
        Temp = "Teachers: \n";
        for (int i = 0; i < Admin.Teachers.size(); i++) {
            Temp += Admin.Teachers.get(i).Username + '\n';
            Temp += "Classes: { \n";
            for (int j = 0; j < Admin.Teachers.get(i).classRooms.size(); j++) {
                Temp += Admin.Teachers.get(i).classRooms.get(j).Name + '\n';
            }
            Temp += "} \n";
        }
        Temp += "Students: \n";
        for (int i = 0; i < Admin.Students.size(); i++) {
            Temp += Admin.Students.get(i).Username + '\n';
        }
        UniversityTextArea.setText(Temp);
    }
}

