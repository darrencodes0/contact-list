package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController{

    @FXML
private Stage stage;
    private Scene scene;
    private Parent root;


    //scene 1// login
    @FXML
    private AnchorPane Pane1;

    @FXML
    private TextField LogInUserNameField;

    @FXML
    private TextField LogInPasswordField;

    @FXML
    public Button exitButton;

    @FXML
    public Button LogInButton;



    //registering info // scene2
    @FXML
    public Label topLabel;
    @FXML
    private TextField FirstNameField;
    @FXML
    private TextField MiddleNameField;
    @FXML
    private TextField LastNameField;
    @FXML
    private TextField EmailField;
    @FXML
    private TextField UserNameField;
    @FXML
    private TextField PhoneField;
    @FXML
    private TextField ConfirmPasswordField;
    @FXML
    private TextField PasswordField;

    //contacts list // scene3

    @FXML
    public Label ShowList;

    @FXML
    private Button BackToBeginning;


    //Storing Info
    static String firstName;
    static String middleName;
    static String lastName;
    static String userName;
    static String email;
    static long phoneNumber;
    static String password;

    //to change or alter the inputs
    String confirmFirstName;
    String confirmMiddleName;
    String confirmLastName;
    String confirmPassword;
    String confirmingPassword;


   public void submit(ActionEvent event) throws IOException{

           confirmFirstName = FirstNameField.getText();
           firstName = confirmFirstName.substring(0, 1).toUpperCase(Locale.ROOT) + confirmFirstName.substring(1).toLowerCase(Locale.ROOT);
       System.out.println(firstName);


       confirmMiddleName = MiddleNameField.getText();
       middleName = confirmMiddleName.substring(0, 1).toUpperCase(Locale.ROOT) + confirmMiddleName.substring(1).toLowerCase(Locale.ROOT);
       System.out.println(middleName);
       if(MiddleNameField.getText().equalsIgnoreCase("None")){
           middleName = null;
       }

       confirmLastName = LastNameField.getText();
       lastName = confirmLastName.substring(0, 1).toUpperCase(Locale.ROOT) + confirmLastName.substring(1).toLowerCase(Locale.ROOT);
       System.out.println(lastName);

       phoneNumber = Long.parseLong(PhoneField.getText());
       System.out.println(phoneNumber);

       userName = UserNameField.getText();
       System.out.println(userName);

       email = EmailField.getText();
       System.out.println(email);


       confirmPassword = PasswordField.getText();
       System.out.println(confirmPassword);

       confirmingPassword = ConfirmPasswordField.getText();
       System.out.println(confirmingPassword);



       if(middleName == null){
           String fullName = firstName + " " + lastName;
           People user = new People(userName,fullName,email,password,phoneNumber);
           People.list.add(user);
       } else{
           String fullName = firstName + " " + middleName + " " + lastName;
           People user = new People(userName,fullName,email,password,phoneNumber);
           People.list.add(user);
       }


       if(!confirmPassword.equals(confirmingPassword)){
           System.out.println("Passwords do not match.");
       } else {
           System.out.println("Successfully registered a account!");
           root = FXMLLoader.load(getClass().getResource("ContactStorage.fxml"));
           stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
       }

   }


    public void showContacts(ActionEvent event){
        System.out.println("Contacts List:");
            for(int i = 0; i < People.list.size(); i++){
                System.out.println(People.list.get(i));
            }
        }

    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene1(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logout(ActionEvent event){
        stage = (Stage) Pane1.getScene().getWindow();
        System.out.println("Good Bye!");
        stage.close();
    }

    public void Login(ActionEvent event) throws IOException {
        String LogInUserName = LogInUserNameField.getText();
        String LogInPassword = LogInPasswordField.getText();
            for (int i = 0; i < People.list.size(); i++) {
                if (People.list.get(i).userName.equals(LogInUserName)) {
                    if (People.list.get(i).password.equals(LogInPassword)) {
                        System.out.println("Successfully logged in!");
                        root = FXMLLoader.load(getClass().getResource("ContactStorage.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                        break;
                    }
                }
                if(!People.list.get(i).userName.equalsIgnoreCase(LogInUserName)) {
                    System.out.println("Username or Password is incorrect.");
                }
            }
    }


   // you can log in with these accounts, just type in their username + password.
    public static void addedContacts(){
        People randomUser1 = new People("Yellow","Julius Caesar", "whyat0@yahoo.aol","1221",Long.parseLong("3215251623"));
        People randomUser2 = new People("Blue", "Darius Garland", "dariusg100@gmail.com","booze",Long.parseLong("6461733145"));
        People randomUser3 = new People("Green", "Brook Lopez", "brook293@gmail.com","password123",Long.parseLong("2152633528"));
        People.list.add(randomUser1);
        People.list.add(randomUser2);
        People.list.add(randomUser3);
    }

}