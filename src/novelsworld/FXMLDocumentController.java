/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package novelsworld;

import java.sql.*;
//import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.net.URL;
import java.util.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author SMART-it
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button avl_add_btn;

    @FXML
    private TextField avl_auther;

    @FXML
    private Button avl_btn;

    @FXML
    private Button avl_clear_btn;

    @FXML
    private DatePicker avl_date;

    @FXML
    private Button avl_delete_btn;

    @FXML
    private AnchorPane avl_form;

    @FXML
    private TextField avl_id;

    @FXML
    private Button avl_import_btn;

    @FXML
    private TextField avl_price;

    @FXML
    private TextField avl_search;

    @FXML
    private TableView<?> avl_table;

    @FXML
    private TableColumn<?, ?> avl_table_auther;

    @FXML
    private TableColumn<?, ?> avl_table_date;

    @FXML
    private TableColumn<?, ?> avl_table_id;

    @FXML
    private TableColumn<?, ?> avl_table_price;

    @FXML
    private TableColumn<?, ?> avl_table_title;

    @FXML
    private TableColumn<?, ?> avl_table_type;

    @FXML
    private TextField avl_title;

    @FXML
    private TextField avl_type;

    @FXML
    private Button avl_update_btn;

    @FXML
    private Button close;

    @FXML
    private Button close1;

    @FXML
    private Button close_signup;

    @FXML
    private Hyperlink create_account;

    @FXML
    private AnchorPane dash_a;

    @FXML
    private AnchorPane dash_b;

    @FXML
    private Button dash_btn;

    @FXML
    private AnchorPane dash_c;

    @FXML
    private AnchorPane dash_d;

    @FXML
    private AnchorPane dash_e;

    @FXML
    private AnchorPane dash_form;

    @FXML
    private TextField email_signup;

    @FXML
    private Hyperlink have_account;

    @FXML
    private AnchorPane login_form;

    @FXML
    private Button loginbtn;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minimize;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField password_signup;

    @FXML
    private Button shop_btn;

    @FXML
    private Label shopping_Total;

    @FXML
    private Button shopping_addbtn;

    @FXML
    private ComboBox<?> shopping_bookID;

    @FXML
    private ComboBox<?> shopping_bookTitle;

    @FXML
    private TableColumn<?, ?> shopping_col_auther;

    @FXML
    private TableColumn<?, ?> shopping_col_id;

    @FXML
    private TableColumn<?, ?> shopping_col_num;

    @FXML
    private TableColumn<?, ?> shopping_col_price;

    @FXML
    private TableColumn<?, ?> shopping_col_title;

    @FXML
    private TableColumn<?, ?> shopping_col_type;

    @FXML
    private AnchorPane shopping_form;

    @FXML
    private Label shopping_info_auther;

    @FXML
    private Label shopping_info_date;

    @FXML
    private Label shopping_info_id;

    @FXML
    private Label shopping_info_title;

    @FXML
    private Label shopping_info_type;

    @FXML
    private Button shopping_paybtn;

    @FXML
    private TableView<?> shopping_table;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private Button signupbtn;

    @FXML
    private TextField username;

    @FXML
    private TextField username_signup;


    
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet re;
    int x=0;
    
    
    //login &signup
public void login() {
    
    String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
    conn = DataBase.ConDb();
    
    if (conn == null) {
        // If the connection fails, alert the user
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Failed to connect to the database.");
        alert.showAndWait();
        return; // Exit the method
    }
    
    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1, username.getText());
        ps.setString(2, password.getText());
        re = ps.executeQuery();
        Alert alert;
        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            if (re.next()) {
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Logged in!");
                alert.showAndWait();
                x=1;
                
                if (x==1){
                    login_form.setVisible(  false);
                    signup_form.setVisible(false);
                    main_form.setVisible(  true);
                    
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                }
                
                
                
                
            } else {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Wrong  username or password ");
                alert.showAndWait();
            }
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}

public void signup() {
        String sql = "insert into admin (email,username,password) values (?,?,?)";
        conn = DataBase.ConDb();
    
    if (conn == null) {
        // If the connection fails, alert the user
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Failed to connect to the database.");
        alert.showAndWait();
        return; // Exit the method
    }

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, email_signup.getText());
            ps.setString(2, username_signup.getText());
            ps.setString(3, password_signup.getText());

            Alert alert;
            if (email_signup.getText().isEmpty() || password_signup.getText().isEmpty() || username_signup.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else if (password_signup.getText().length() < 5) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invaild password");
                alert.showAndWait();

            } else {

                ps.execute();
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully create a new account!");
                alert.showAndWait();

                email_signup.setText("");
                username_signup.setText("");
                password_signup.setText("");
            }

        } catch (Exception e) {
            System.out.println(e);

        }
    }
    
    //Dashboard
public void close(){
        System.exit(0);
    }
    
public void minimize(){
        Stage stage= (Stage)main_form.getScene().getWindow();
        stage.setIconified(true);
    }
    
public void logout(){
    try{
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();

        if(option.get().equals(ButtonType.OK)){

            // HIDE YOUR DASHBOARD
            logout.getScene().getWindow().hide();
            login_form.setVisible(  true);
            main_form.setVisible(  false);
            signup_form.setVisible(false);
            // LINK YOUR LOGIN FORM
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);



            stage.setScene(scene);
            stage.show();
        }

    }catch(Exception e){e.printStackTrace();}
}
    


public void switchForm(ActionEvent ev) {
        if (ev.getSource() == create_account) {
            login_form.setVisible(  false);
            main_form.setVisible(  false);
            signup_form.setVisible(true);
        } else if (ev.getSource() == have_account) {
            login_form.setVisible(true);
            signup_form.setVisible(false);
            main_form.setVisible(  false);
        }
    }

public void switchDash(ActionEvent event){

    if(event.getSource() == dash_btn){
        dash_form.setVisible(true);
        avl_form.setVisible(false);
        shopping_form.setVisible(false);

        dash_btn.setStyle("-fx-background-color:linear-gradient(to top right, #72513c, #ab853e);");
        avl_btn.setStyle("-fx-background-color: transparent");
        shop_btn.setStyle("-fx-background-color: transparent");



    }else if(event.getSource() == avl_btn){
        dash_form.setVisible(false);
        avl_form.setVisible(true);
        shopping_form.setVisible(false);

        avl_btn.setStyle("-fx-background-color:linear-gradient(to top right, #72513c, #ab853e);");
        dash_btn.setStyle("-fx-background-color: transparent");
        shop_btn.setStyle("-fx-background-color: transparent");



    }else if(event.getSource() == shop_btn){
        dash_form.setVisible(false);
        avl_form.setVisible(false);
        shopping_form.setVisible(true);

        shop_btn.setStyle("-fx-background-color:linear-gradient(to top right, #72513c, #ab853e);");
        avl_btn.setStyle("-fx-background-color: transparent");
        dash_btn.setStyle("-fx-background-color: transparent");



    }
}
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}