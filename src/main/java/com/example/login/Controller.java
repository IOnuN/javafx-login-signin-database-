package com.example.login;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    public TextField prenume;
    public Button signupp;
    public TextField virsta;
    public TextField username;
    public TextField locationn;
    public TextField gender;
    public Button login;
    public TextField username1;
    public TextField password1;
    public Button signin2;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn;

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    @FXML
    void initialize() {
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

    DatabaseHandler dbHandler=new DatabaseHandler();
    public void action1(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    dbHandler.signupuser(name.getText(),prenume.getText(),username.getText(),password.getText(),locationn.getText(),gender.getText(),virsta.getText());
    }

    public void action2(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        User verifica =new User();
        verifica.setUsername(username1.getText());
        verifica.setPassword(password1.getText());
        DatabaseHandler dbhand=new DatabaseHandler();
        if(dbhand.getUser(verifica)){
            System.out.println("o mers");
        } else{
            System.out.println("Nu exista");
        }
    }

    public void action3(ActionEvent actionEvent) throws IOException {
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("signup.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 257);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
