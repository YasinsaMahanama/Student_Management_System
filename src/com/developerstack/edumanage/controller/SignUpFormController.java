package com.developerstack.edumanage.controller;

import com.developerstack.edumanage.db.Database;
import com.developerstack.edumanage.model.User;
import com.developerstack.edumanage.util.security.PasswordManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpFormController {
    public AnchorPane contextSignUp;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtPassword;
    public TextField txtEmail;


    public void alreadyExistAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LogInForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) contextSignUp.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.centerOnScreen();
    }

    public void SignUpOnAction(ActionEvent actionEvent) throws IOException {
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String email = txtEmail.getText().toLowerCase();
        String password = new PasswordManager().encrypt(txtPassword.getText().trim());    //spaces ain krnna methana trim() use krnwa

        Database.usersTable.add(new User(firstName, lastName, email, password));
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Sign Up Successful");
        alert.show();
        setUi("LogInForm");
    }
}
