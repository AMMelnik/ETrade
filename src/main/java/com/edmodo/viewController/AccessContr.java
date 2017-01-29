package com.edmodo.viewController;

import com.edmodo.modelController.UserRec;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Created by pc on 29.01.2017.
 */
public class AccessContr extends ObjController {

    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private Button entry;
    @FXML
    private Button registration;
    @FXML
    private Label accessInfo;

  //  UserDAOImpl userDI;

    public AccessContr() {
        super();
    }

    @FXML
    void initialize() {
        login.setText("Admin");
        password.setText("12345");
    }

    @FXML
    private void clickEntryBtn() {

       /* String nick = login.getText();
        String pass = password.getText();
        if (nick.equals("") && pass.equals("")) {
            accessInfo.setText("Введите логин и пароль для доступа");
        } else {
            userDI.listUser.(nick, pass);
            super.getMain().showWarriorsWindow();
        }*/
    }

    @FXML
    private void clickRegBtn() {
        super.getMain().showRegistrationForm();

    }
}
