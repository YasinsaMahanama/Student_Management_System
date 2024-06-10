package com.developerstack.edumanage.controller;

import com.developerstack.edumanage.db.Database;
import com.developerstack.edumanage.model.User;
import com.developerstack.edumanage.util.security.PasswordManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class LoginFormController {

    public AnchorPane contextLogIn;
    public TextField txtEmail;
    public TextField txtPassword;

    public void logInOnAction(ActionEvent actionEvent) throws IOException {
        String email = txtEmail.getText().toLowerCase();
        String password = txtPassword.getText().trim();

//        for(User user :Database.users){
//            if(user.getEmail().equals(email)){
//                if(user.getPassword().equals(password)){
//                    setUi("DashboardForm");
//                }
//                else{
//                    Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong Password");
//                    alert.show();
//                    return;
//                }
//            }
//        }
//        Alert alert = new Alert(Alert.AlertType.WARNING, String.format("Email %s does not exist", email));
//        alert.show();

        Optional<User> selectedUser = Database.usersTable.stream().filter(e -> e.getEmail().equals(email)).findFirst();
        if(selectedUser.isPresent()) {
            if (new PasswordManager().checkPassword(password, selectedUser.get().getPassword())){
                setUi("DashboardForm");
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Password");
                alert.show();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING, String.format("Not exists %s email Address", email));
            alert.show();
        }
    }

    public void createAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignUpForm");
    }

    public void forgetPasswordOnAction(ActionEvent actionEvent) {
    }

    private void setUi (String location) throws IOException {
        Stage stage = (Stage) contextLogIn.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" +location + ".fxml"))));
        stage.centerOnScreen();
    }
}
