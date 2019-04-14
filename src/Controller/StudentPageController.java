package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.security.cert.CRLReason;

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
        if (NewUsernameFiled.getText().isEmpty()) {
            WrongLabel.setText("Fill all items");
            WrongLabel.setVisible(true);
        } else if (!Admin.Students.get(MainPageController.number).Username.equals(PreviousUsernameFiled.getText()) || !Admin.Students.get(MainPageController.number)
                .Password.equals(PreviousPasswordFiled.getText())) {
            WrongLabel.setText("Password Or Username does`nt match");
            WrongLabel.setVisible(true);
        } else if (NewPasswordFiled.getText().length() < 6) {
            WrongLabel.setText("Password must be 6 character at least");
            WrongLabel.setVisible(true);
        } else if (!NewPasswordFiled.getText().equals(RepeatPasswordFiled.getText())) {
            WrongLabel.setText("Passwords do not equal");
            WrongLabel.setVisible(true);
        } else {
            Admin.Students.get(MainPageController.number).Username = NewUsernameFiled.getText();
            Admin.Students.get(MainPageController.number).Password = NewPasswordFiled.getText();
            WrongLabel.setText("Changing Profile completed");
            WrongLabel.setVisible(true);
        }
    }

    public void LogOutClick(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../View/sample.fxml");
    }

    /**
     * increase money
     *
     * @param actionEvent
     */
    @FXML
    public TextField CardNumberFiled;
    @FXML
    public PasswordField CardPasswordFiled;
    @FXML
    public Label InventoryWrongLabel;
    @FXML
    public RadioButton FiveCredit;
    @FXML
    public RadioButton TenCredit;
    @FXML
    public ToggleGroup CreditGroup;

    public void InventorySubmitClick(ActionEvent actionEvent) {
        if (CardNumberFiled.getText().isEmpty() || CardPasswordFiled.getText().isEmpty()) {
            InventoryWrongLabel.setText("Fill all items");
            InventoryWrongLabel.setVisible(true);
        } else if (CardNumberFiled.getText().length() != 16) {
            InventoryWrongLabel.setText("Card Number must be 16 digit");
            InventoryWrongLabel.setVisible(true);
        } else if (!CardPasswordFiled.getText().matches("[0-9]+")) {
            InventoryWrongLabel.setText("Fill Password field with numbers");
            InventoryWrongLabel.setVisible(true);
        } else if (!CardPasswordFiled.getText().matches("[0-9]+")) {
            InventoryWrongLabel.setText("Fill card number field with numbers");
            InventoryWrongLabel.setVisible(true);
        } else {
            if (FiveCredit.isSelected())
                Admin.Students.get(MainPageController.number).Inventory += 5000;
            else
                Admin.Students.get(MainPageController.number).Inventory += 10000;
            InventoryWrongLabel.setText("complete");
            InventoryWrongLabel.setVisible(true);

        }
    }

    @FXML
    //
    public Label CreditLabel;
    public Label DiningWrongLabel;
    public RadioButton Food11;
    public RadioButton Food12;
    public RadioButton Food21;
    public RadioButton Food22;
    public RadioButton Food31;
    public RadioButton Food32;
    public RadioButton Food41;
    public RadioButton Food42;
    public RadioButton Food51;
    public RadioButton Food52;
    //
    public int SumPrice = 2500;

    /**
     * Dining
     *
     * @param actionEvent
     */
    public void DiningSubmitClick(ActionEvent actionEvent) {
        if (Food12.isSelected())
            SumPrice += 500;
        if (Food22.isSelected())
            SumPrice += 500;
        if (Food32.isSelected())
            SumPrice += 500;
        if (Food42.isSelected())
            SumPrice += 500;
        if (Food52.isSelected())
            SumPrice += 500;
        if (SumPrice > Admin.Students.get(MainPageController.number).Inventory) {
            DiningWrongLabel.setText("Failed");
            DiningWrongLabel.setVisible(true);
        } else {
            Admin.Students.get(MainPageController.number).Inventory -= SumPrice;
            DiningWrongLabel.setText("Complete");
            DiningWrongLabel.setVisible(true);
        }
    }

    public void DiningClick(Event event) {
        CreditLabel.setText("Your Credit : " + Admin.Students.get(MainPageController.number).Inventory);
        Food11.setText(Food.Food1Array[0]);
        Food21.setText(Food.Food1Array[1]);
        Food31.setText(Food.Food1Array[2]);
        Food41.setText(Food.Food1Array[3]);
        Food51.setText(Food.Food1Array[4]);
        Food12.setText(Food.Food2Array[0]);
        Food22.setText(Food.Food2Array[1]);
        Food32.setText(Food.Food2Array[2]);
        Food42.setText(Food.Food2Array[3]);
        Food52.setText(Food.Food2Array[4]);


    }

    public Label LibraryWrongLabel;
    public TextArea LibraryTextField;
    public TextField BookNameFiled;

    public void LibrarySubmitClick(ActionEvent actionEvent) {
        if (BookNameFiled.getText().isEmpty()) {
            LibraryWrongLabel.setVisible(true);
            LibraryWrongLabel.setText("Fill element");
        } else if (Admin.Students.get(MainPageController.number).BooksNumber >= 3) {
            LibraryWrongLabel.setVisible(true);
            LibraryWrongLabel.setText("You cant reserve any more book");
        } else {
            boolean flag = false;
            int i = 0;
            for (i = 0; i < Book.Books.size(); i++) {
                if (Book.Books.get(i).Name.equalsIgnoreCase(BookNameFiled.getText())) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                LibraryWrongLabel.setVisible(true);
                LibraryWrongLabel.setText("This book does nt exist");
            } else if (Book.Books.get(i).Resevration) {
                LibraryWrongLabel.setVisible(true);
                LibraryWrongLabel.setText("You cant reserve this book");
            } else {
                Book.Books.get(i).Owner = Admin.Students.get(MainPageController.number).Username;
                Book.Books.get(i).Resevration = true;
                LibraryWrongLabel.setVisible(true);
                LibraryWrongLabel.setText("Complete");
            }
        }

    }

    public void LibraryClick(Event event) {
        String Temp = "";
        Temp = "Books: \n";
        for (int i = 0; i < Book.Books.size(); i++) {
            Temp += Book.Books.get(i).Name + "/" + Book.Books.get(i).AuthorName + "/" + Book.Books.get(i).PublisherName + '\n';
        }
        LibraryTextField.setText(Temp);
    }
}
