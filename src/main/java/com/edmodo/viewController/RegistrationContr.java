package com.edmodo.viewController;

import com.edmodo.model.User;

import com.edmodo.modelController.UserRec;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static com.edmodo.viewController.AccessContr.user;


/**
 * Created by pc on 29.01.2017.
 */
public class RegistrationContr extends ObjController {

    @FXML
    private TextField email;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField pass;
    @FXML
    private TextField passConfirm;
    @FXML
    private Label regInfo;

    private UserRec userRec;

    public RegistrationContr() {
        super();
    }

    @FXML
    void initialize() {
        name.setText("James");
        surname.setText("Bond");
        email.setText("jb007@gmail.com");
        pass.setText("12345");
        passConfirm.setText("54321");
    }

    @FXML
    private void clickRegBtn() {
        regInfo.setText("");
        userRec = new UserRec();
        if (userRec.checkEmail(email.getText()) == 0) {
            user = new User(email.getText(), pass.getText(), name.getText(), surname.getText());
            userRec.addRecord(user);
            super.getMain().showTradeForm();
        } else {
            regInfo.setText("Данный email уже занят!");
        }

       /* String nick = login.getText();
        String pass = password.getText();
        if (nick.equals("") && pass.equals("")) {
            accessInfo.setText("Введите логин и пароль для доступа");
        } else {
            userDI.listUser.(nick, pass);
            super.getMain().showWarriorsWindow();
        }*/
    }
}
