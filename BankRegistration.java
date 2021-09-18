import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import java.util.*;
import javafx.event.*;

public class BankRegistration extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    TextField firstNameField;
    TextField middleNameField;
    TextField lastNameField;
    TextField addressField;
    TextField phoneField;

    RadioButton maleGender;
    RadioButton femaleGender;
    RadioButton married;
    RadioButton single;
    RadioButton divorced;
    RadioButton widow;

    CheckBox debitCard;
    CheckBox creditCard;

    @Override
    public void start(Stage primaryStage) {
        Label firstNameLabel = new Label("First Name:");
        firstNameLabel.setPrefWidth(100);
        firstNameField = new TextField();
        firstNameField.setPromptText("Enter first name");
        firstNameField.setPrefWidth(100);
        firstNameField.setMaxWidth(200);
        firstNameField.setMinWidth(200);

        Label middleNameLabel = new Label("Middle Name:");
        middleNameLabel.setPrefWidth(100);
        middleNameField = new TextField();
        middleNameField.setPromptText("Enter Middle Name (Optional)");
        middleNameField.setPrefWidth(100);
        middleNameField.setMaxWidth(200);
        middleNameField.setMinWidth(200);

        Label lastNameLabel = new Label("Last Name:");
        lastNameLabel.setPrefWidth(100);
        lastNameField = new TextField();
        lastNameField.setPromptText("Enter last name");
        lastNameField.setPrefWidth(100);
        lastNameField.setMaxWidth(200);
        lastNameField.setMinWidth(200);

        Label addressLabel = new Label("Address:");
        addressLabel.setPrefWidth(100);
        addressField = new TextField();
        addressField.setPromptText("Enter address");
        addressField.setPrefWidth(100);
        addressField.setMaxWidth(200);
        addressField.setMinWidth(200);

        Label phoneLabel = new Label("Phone:");
        phoneLabel.setPrefWidth(100);
        phoneField = new TextField();
        phoneField.setPromptText("Enter phone");
        phoneField.setPrefWidth(100);
        phoneField.setMaxWidth(200);
        phoneField.setMinWidth(200);

        Label genderLabel = new Label("Gender");
        genderLabel.setPrefWidth(100);
        maleGender = new RadioButton("Male");
        femaleGender = new RadioButton("Female");
        ToggleGroup groupGender = new ToggleGroup();
        maleGender.setToggleGroup(groupGender);
        femaleGender.setToggleGroup(groupGender);

        Label maritalLabel = new Label("Marital Status");
        maritalLabel.setPrefWidth(100);
        married = new RadioButton("Married");
        widow = new RadioButton("Widow");
        single = new RadioButton("Single");
        divorced = new RadioButton("Divorced");
        // toggle group is used to make each radioButton unique and it prevents
        // users from selecting multiple radiobuttons. Users can only select one
        ToggleGroup groupMarital = new ToggleGroup();
        married.setToggleGroup(groupMarital);
        widow.setToggleGroup(groupMarital);
        single.setToggleGroup(groupMarital);
        divorced.setToggleGroup(groupMarital);

        Label cardType = new Label("Card Type");
        debitCard = new CheckBox("Debit");
        creditCard = new CheckBox("Credit");

        HBox paneFirst = new HBox(firstNameLabel, firstNameField);
        HBox paneMiddle = new HBox(middleNameLabel, middleNameField);
        HBox paneLast = new HBox(lastNameLabel, lastNameField);
        HBox paneAddress = new HBox(addressLabel, addressField);
        HBox panePhone = new HBox(phoneLabel, phoneField);
        HBox paneGender = new HBox(genderLabel, maleGender, femaleGender);

        VBox paneMarital = new VBox(maritalLabel, married, widow, single, divorced);
        VBox paneCard = new VBox(cardType, debitCard, creditCard);

        Button createAccount = new Button("Create Account");
        createAccount.setOnAction(e -> accountCreate());

        Button exit = new Button("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to exit?", ButtonType.YES,
                        ButtonType.NO);

                Optional<ButtonType> confirm = a.showAndWait();

                if (confirm.isPresent() && confirm.get() == ButtonType.YES) {
                    primaryStage.close();
                }
            }
        });

        HBox paneButtons = new HBox(createAccount, exit);

        VBox pane = new VBox(10, paneFirst, paneMiddle, paneLast, paneAddress, panePhone, paneGender, paneMarital,
                paneCard, paneButtons);

        Scene scene = new Scene(pane);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void accountCreate() {
        String msg = "";

        if (firstNameField.getText().length() == 0) {
            Alert a = new Alert(Alert.AlertType.WARNING, "First Name cannot be blank!");
            a.setTitle("Warning");
            a.showAndWait();
        }

        if (lastNameField.getText().length() == 0) {
            Alert a = new Alert(Alert.AlertType.WARNING, "Last Name cannot be blank!");
            a.setTitle("Warning");
            a.showAndWait();
        }

        else if (middleNameField.getText().length() != 0) {
            msg = "\nAccount Details: ";

            msg += "\nFirst Name: " + firstNameField.getText();
            msg += "\nMiddle Name: " + middleNameField.getText();
            msg += "\nLast Name: " + lastNameField.getText();
            msg += "\nAddress: " + addressField.getText();
            msg += "\nPhone: " + phoneField.getText();

            if (maleGender.isSelected()) {
                msg += "\nGender: Male";
            }

            else if (femaleGender.isSelected()) {
                msg += "\nGender: Female";
            }

            if (single.isSelected()) {
                msg += "\nMarital Status: Single";
            }

            else if (divorced.isSelected()) {
                msg += "\nMarital Status: Divorced";
            }

            else if (widow.isSelected()) {
                msg += "\nMarital Status: Widow";
            }

            else if (married.isSelected()) {
                msg += "\nMarital Status: Married";
            }

            if (debitCard.isSelected()) {
                msg += "\nCard Type: Debit";
            }

            else if (creditCard.isSelected()) {
                msg += "\nCard Type: Credit";
            }
        }

        else {

            msg = "\nAccount Details: ";
            msg += "\nFirst Name: " + firstNameField.getText();
            msg += "\nLast Name: " + lastNameField.getText();
            msg += "\nAddress: " + addressField.getText();
            msg += "\nPhone: " + phoneField.getText();

            if (maleGender.isSelected()) {
                msg += "\nGender: Male";
            }

            else if (femaleGender.isSelected()) {
                msg += "\nGender: Female";
            }

            if (single.isSelected()) {
                msg += "\nMarital Status: Single";
            }

            else if (divorced.isSelected()) {
                msg += "\nMarital Status: Divorced";
            }

            else if (widow.isSelected()) {
                msg += "\nMarital Status: Widow";
            }

            else if (married.isSelected()) {
                msg += "\nMarital Status: Married";
            }
            if (debitCard.isSelected()) {
                msg += "\nCard Type: Debit";
            }

            else if (creditCard.isSelected()) {
                msg += "\nCard Type: Credit";
            }

        }

        Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
        a.setTitle("Account Details");
        a.showAndWait();

    }

}
