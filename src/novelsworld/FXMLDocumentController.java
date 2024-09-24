/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package novelsworld;

//import java.awt.Image;
import java.io.File;
import java.sql.*;
//import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 *
 * @author Aya El-agamy
 */

 

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button avl_add_btn;

    @FXML
    private TextField avl_author;

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
    private ImageView avl_image;

    @FXML
    private Button avl_import_btn;

    @FXML
    private TextField avl_price;

    @FXML
    private TextField avl_search;

    @FXML
    private TableView<bookData> avl_table;

    @FXML
    private TableColumn<bookData, String> avl_table_author;

    @FXML
    private TableColumn<bookData, String> avl_table_date;

    @FXML
    private TableColumn<bookData, String> avl_table_id;

    @FXML
    private TableColumn<bookData, String> avl_table_price;

    @FXML
    private TableColumn<bookData, String> avl_table_title;

    @FXML
    private TableColumn<bookData, String> avl_table_type;

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
    private AnchorPane dash_a1;

    @FXML
    private AnchorPane dash_b;

    @FXML
    private AnchorPane dash_b1;

    @FXML
    private Button dash_btn;

    @FXML
    private AnchorPane dash_c;

    @FXML
    private AnchorPane dash_c1;

    @FXML
    private AnchorPane dash_d;

    @FXML
    private AnchorPane dash_d1;

    @FXML
    private AnchorPane dash_e;

    @FXML
    private AnchorPane dash_e1;

    @FXML
    private AnchorPane dash_f;

    @FXML
    private AnchorPane dash_f1;

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
    private Spinner<Integer> shopping_qun;

    @FXML
    private TableColumn<customerData, String> shopping_col_author;

    @FXML
    private TableColumn<customerData, String> shopping_col_id;

    @FXML
    private TableColumn<customerData, String> shopping_col_num;

    @FXML
    private TableColumn<customerData, String> shopping_col_price;

    @FXML
    private TableColumn<customerData, String> shopping_col_title;

    @FXML
    private TableColumn<customerData, String> shopping_col_type;

    @FXML
    private AnchorPane shopping_form;

    @FXML
    private Label shopping_info_author;

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
    private TableView<customerData> shopping_table;
    
     @FXML
    private Label incom_a;

    @FXML
    private Label incom_b;

    @FXML
    private Button incom_btn;

    @FXML
    private Label incom_c;

    @FXML
    private AnchorPane incom_form;
    
    @FXML
    private BarChart<?, ?> custom_chart;
    
    
    @FXML
    private AreaChart<?, ?> income_Chart;


    @FXML
    private AnchorPane signup_form;

    @FXML
    private Button signupbtn;

    @FXML
    private TextField username;

    @FXML
    private Label username1;

    @FXML
    private TextField username_signup;



    
    private Connection conn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet re;
    int x=0;
    private Image image;
    
    
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
                getData.username=username.getText();
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
    
public void displayUsername(){
//     String user = getData.username;
//     user = user.substring(0, 1).toUpperCase() + user.substring(1);
     username1.setText(getData.username);
 }

//linking

public void switchForm(ActionEvent ev) {
        if (ev.getSource() == create_account) {
            login_form.setVisible(  false);
            signup_form.setVisible(true);
        } else if (ev.getSource() == have_account) {
            login_form.setVisible(true);
            signup_form.setVisible(false);
        }
    }

public void switchDash(ActionEvent event){

    if(event.getSource() == dash_btn){
        dash_form.setVisible(true);
        avl_form.setVisible(false);
        shopping_form.setVisible(false);
        incom_form.setVisible(false);

        dash_btn.setStyle("-fx-background-color:linear-gradient(to top right, #72513c, #ab853e);");
        avl_btn.setStyle("-fx-background-color: transparent");
        shop_btn.setStyle("-fx-background-color: transparent");
        incom_btn.setStyle("-fx-background-color: transparent");



    }else if(event.getSource() == avl_btn){
        avl_form.setVisible(true);
        dash_form.setVisible(false);
        shopping_form.setVisible(false);
        incom_form.setVisible(false);

        avl_btn.setStyle("-fx-background-color:linear-gradient(to top right, #72513c, #ab853e);");
        dash_btn.setStyle("-fx-background-color: transparent");
        shop_btn.setStyle("-fx-background-color: transparent");
        incom_btn.setStyle("-fx-background-color: transparent");

        availableBooksListData();
        availableBooksSeach();

    }else if(event.getSource() == shop_btn){
        shopping_form.setVisible(true);
        dash_form.setVisible(false);
        avl_form.setVisible(false);       
        incom_form.setVisible(false);

        shop_btn.setStyle("-fx-background-color:linear-gradient(to top right, #72513c, #ab853e);");
        avl_btn.setStyle("-fx-background-color: transparent");
        dash_btn.setStyle("-fx-background-color: transparent");
        incom_btn.setStyle("-fx-background-color: transparent");
        
        purchaseBookId();
        purchaseBookTitle();
        purchaseShowCustomerListData();
        purchaseDisplayQTY();
        purchaseDisplayTotal();



    }else if(event.getSource() == incom_btn){
        incom_form.setVisible(true);
        dash_form.setVisible(false);
        avl_form.setVisible(false);
        shopping_form.setVisible(false);
        

        incom_btn.setStyle("-fx-background-color:linear-gradient(to top right, #72513c, #ab853e);");
        avl_btn.setStyle("-fx-background-color: transparent");
        dash_btn.setStyle("-fx-background-color: transparent");
        shop_btn.setStyle("-fx-background-color: transparent");
        
        incom_A();
        incom_B();
        incom_C();
}
}


//avilable
public ObservableList<bookData> availableBooksListData(){
        
        ObservableList<bookData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM book";
        
        conn = DataBase.ConDb();
        
        try{
            ps = conn.prepareStatement(sql);
            re= ps.executeQuery();
            
            bookData bookD;
            
            while(re.next()){
                bookD = new bookData(re.getInt("book_id"), re.getString("title")
                        , re.getString("author"), re.getString("type")
                        , re.getDate("pub_date"), re.getDouble("price")
                        , re.getString("image"));
                
                listData.add(bookD);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    
private ObservableList<bookData> availableBooksList;
public void availableBooksShowListData(){
     availableBooksList = availableBooksListData();

     avl_table_id.setCellValueFactory(new PropertyValueFactory<>("bookId"));
     avl_table_title.setCellValueFactory(new PropertyValueFactory<>("title"));
     avl_table_author.setCellValueFactory(new PropertyValueFactory<>("author"));
     avl_table_type.setCellValueFactory(new PropertyValueFactory<>("type"));
     avl_table_date.setCellValueFactory(new PropertyValueFactory<>("date"));
     avl_table_price.setCellValueFactory(new PropertyValueFactory<>("price"));

     avl_table.setItems(availableBooksList);
 }

public void availableBooksSelect(){
        bookData bookD = avl_table.getSelectionModel().getSelectedItem();
        int num = avl_table.getSelectionModel().getSelectedIndex();
        
        if((num - 1) < -1){ return; }
        
        avl_id.setText(String.valueOf(bookD.getBookId()));
        avl_title.setText(bookD.getTitle());
        avl_author.setText(bookD.getAuthor());
        avl_type.setText(bookD.getType());
        avl_date.setValue(LocalDate.parse(String.valueOf(bookD.getDate())));
        avl_price.setText(String.valueOf(bookD.getPrice()));
        
        getData.path = bookD.getImage();
        
        String url = "file:" + bookD.getImage();
 
         image = new Image(url,  123, 162, false, true);
        
        avl_image.setImage(image);
        
        
    }

public void avaialableBooksInsertImage(){

      FileChooser open = new FileChooser();
      open.setTitle("Open Image File");
      open.getExtensionFilters().add(new ExtensionFilter("File Image", "*jpg", "*png"));

      File file = open.showOpenDialog(main_form.getScene().getWindow());

      if(file != null){
          getData.path = file.getAbsolutePath();

          image = new Image(file.toURI().toString(), 123, 162, false, true);
          avl_image.setImage(image);
      }

  }

public void availableBooksAdd(){

    String sql = "INSERT INTO book (book_id, title, author, type, pub_date, price, image) "
            + "VALUES(?,?,?,?,?,?,?)";

    conn = DataBase.ConDb();

    try{
        Alert alert;

        if(avl_id.getText().isEmpty()
                || avl_title.getText().isEmpty()
                || avl_author.getText().isEmpty()
                || avl_type.getText().isEmpty()
                || avl_date.getValue() == null
                || avl_price.getText().isEmpty()
                || getData.path == null || getData.path == ""){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }else{
            // CHECK IF BOOK ID IS ALREADY EXIST
            String checkData = "SELECT book_id FROM book WHERE book_id = '"
                    +avl_id.getText()+"'";

            st = conn.createStatement();
            re = st.executeQuery(checkData);

            if(re.next()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Book ID: " + avl_id.getText() + " was already exist!");
                alert.showAndWait();
            }else{

                ps = conn.prepareStatement(sql);
                ps.setString(1, avl_id.getText());
                ps.setString(2,  avl_title.getText());
                ps.setString(3, avl_author.getText());
                ps.setString(4,avl_type.getText());
                ps.setString(5, String.valueOf(avl_date.getValue()));
                ps.setString(6, avl_price.getText());

                String uri = getData.path;
                uri = uri.replace("\\", "\\\\");

                ps.setString(7, uri);

                ps.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();

                // TO BE UPDATED THE TABLEVIEW 
                availableBooksShowListData();
                // CLEAR FIELDS
                availableBooksClear();
            }
        }
    }catch(Exception e){e.printStackTrace();}

}

public void availableBooksClear(){
      avl_id.setText("");
      avl_title.setText("");
      avl_author.setText("");
      avl_type.setText("");
      avl_date.setValue(null);
      avl_price.setText("");

      getData.path = "";

      avl_image.setImage(null);
  }

public void availableBooksUpdate(){

    String uri = getData.path;
    uri = uri.replace("\\", "\\\\");

    String sql = "UPDATE book SET title = '"
            +avl_title.getText()+"', author = '"
            +avl_author.getText()+"', type = '"
            +avl_type.getText()+"', pub_date = '"
            +avl_date.getValue()+"', price = '"
            +avl_price.getText()+"', image = '"
            +uri+"' WHERE book_id = '"+avl_id.getText()+"'";

    conn = DataBase.ConDb();

    try{
        Alert alert;

        if(avl_id.getText().isEmpty()
                || avl_title.getText().isEmpty()
                || avl_author.getText().isEmpty()
                || avl_type.getText().isEmpty()
                || avl_date.getValue() == null
                || avl_price.getText().isEmpty()
                || getData.path == null || getData.path == ""){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }else{
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE Book ID: " + avl_id.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if(option.get().equals(ButtonType.OK)){
                st = conn.createStatement();
                st.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successful Updated!");
                alert.showAndWait();

                // TO BE UPDATED THE TABLEVIEW 
                availableBooksShowListData();
                // CLEAR FIELDS
                availableBooksClear();
            }
        }
    }catch(Exception e){e.printStackTrace();}

}

public void availableBooksDelete(){

    String sql = "DELETE FROM book WHERE book_id = '"
            +avl_id.getText()+"'";

    conn = DataBase.ConDb();

    try{
        Alert alert;

        if(avl_id.getText().isEmpty()
                || avl_title.getText().isEmpty()
                || avl_author.getText().isEmpty()
                || avl_type.getText().isEmpty()
                || avl_date.getValue() == null
                || avl_price.getText().isEmpty()
                || getData.path == null || getData.path == ""){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }else{
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE Book ID: " + avl_id.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if(option.get().equals(ButtonType.OK)){
                st = conn.createStatement();
                st.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successful Delete!");
                alert.showAndWait();

                // TO BE UPDATED THE TABLEVIEW 
                availableBooksShowListData();
                // CLEAR FIELDS
                availableBooksClear();
            }
        }
    }catch(Exception e){e.printStackTrace();}

}

public void availableBooksSeach(){

    FilteredList<bookData> filter = new FilteredList<>(availableBooksList, e -> true);

    avl_search.textProperty().addListener((Observable, oldValue, newValue) ->{

        filter.setPredicate(predicateBookData -> {

            if(newValue == null || newValue.isEmpty()){
                return true;
            }

            String searchKey = newValue.toLowerCase();

            if(predicateBookData.getBookId().toString().contains(searchKey)){
                return true;
            }else if(predicateBookData.getTitle().toLowerCase().contains(searchKey)){
                return true;
            }else if(predicateBookData.getAuthor().toLowerCase().contains(searchKey)){
                return true;
            }else if(predicateBookData.getType().toLowerCase().contains(searchKey)){
                return true;
            }else if(predicateBookData.getDate().toString().contains(searchKey)){
                return true;
            }else if(predicateBookData.getPrice().toString().contains(searchKey)){
                return true;
            }else return false;
        });
    });

    SortedList<bookData> sortList = new SortedList(filter);
    sortList.comparatorProperty().bind(avl_table.comparatorProperty());
    avl_table.setItems(sortList);

}

//shopping

public void purchaseBookId(){

    String sql = "SELECT book_id FROM book";

    conn = DataBase.ConDb();

    try{
        ps = conn.prepareStatement(sql);
        re = ps.executeQuery();

        ObservableList listData = FXCollections.observableArrayList();

        while(re.next()){
            listData.add(re.getString("book_id"));
        }

        shopping_bookID.setItems(listData);
            purchaseBookTitle();
    }catch(Exception e){e.printStackTrace();}

}

public void purchaseBookTitle(){

String sql = "SELECT book_id, title FROM book WHERE book_id = '"
        +shopping_bookID.getSelectionModel().getSelectedItem()+"'";

conn = DataBase.ConDb();

try{
    ps = conn.prepareStatement(sql);
    re = ps.executeQuery();

    ObservableList listData = FXCollections.observableArrayList();

    while(re.next()){
        listData.add(re.getString("title"));
    }

    shopping_bookTitle.setItems(listData);

    purchaseBookInfo();

}catch(Exception e){e.printStackTrace();}

}

public void purchaseBookInfo(){

    String sql = "SELECT * FROM book WHERE title = '"
            +shopping_bookTitle.getSelectionModel().getSelectedItem()+"'";

    conn = DataBase.ConDb();

    String bookId = "";
    String title = "";
    String author = "";
    String type = "";
    String date = "";

    try{
        ps = conn.prepareStatement(sql);
        re = ps.executeQuery();

        if(re.next()){
            bookId = re.getString("book_id");
            title = re.getString("title");
            author = re.getString("author");
            type = re.getString("type");
            date = re.getString("pub_date");
        }

        shopping_info_id.setText(bookId);
        shopping_info_title.setText(title);
        shopping_info_author.setText(author);
        shopping_info_type.setText(type);
        shopping_info_date.setText(date);

    }catch(Exception e){e.printStackTrace();}

}

public ObservableList<customerData> purchaseListData(){
    purchasecustomerId();
    String sql = "SELECT * FROM customer WHERE customer_id = '"+customerId+"'";

    ObservableList<customerData> listData = FXCollections.observableArrayList();

    conn = DataBase.ConDb();

    try{
        ps = conn.prepareStatement(sql);
        re = ps.executeQuery();

        customerData customerD;

        while(re.next()){
            customerD = new customerData(re.getInt("customer_id")
                    , re.getInt("book_id")
                    , re.getString("title")
                    , re.getString("author")
                    , re.getString("type")
                    , re.getInt("quantity")
                    , re.getDouble("price")
                    , re.getDate("date"));

            listData.add(customerD);
        }

    }catch(Exception e){e.printStackTrace();}
    return listData;
}

private int customerId;
public void purchasecustomerId(){

    String sql = "SELECT MAX(customer_id) FROM customer";
    int checkCID = 0 ;
    conn = DataBase.ConDb();

try{
    ps = conn.prepareStatement(sql);
    re = ps.executeQuery();

        if(re.next()){
            customerId = re.getInt("MAX(customer_id)");
        }

        String checkData = "SELECT MAX(customer_id) FROM customer_info";

        ps = conn.prepareStatement(checkData );
        re = ps.executeQuery();

        if(re.next()){
            checkCID = re.getInt("MAX(customer_id)");
        }

        if(customerId == 0){
            customerId += 1;
        }else if(checkCID == customerId){
            customerId = checkCID + 1;
        }

    }catch(Exception e){e.printStackTrace();}

}

private ObservableList<customerData> purchaseCustomerList;
public void purchaseShowCustomerListData(){
    purchaseCustomerList = purchaseListData();

    shopping_col_id.setCellValueFactory(new PropertyValueFactory<>("bookId"));
    shopping_col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
    shopping_col_author.setCellValueFactory(new PropertyValueFactory<>("author"));
    shopping_col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
    shopping_col_num.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    shopping_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));

     shopping_table.setItems(purchaseCustomerList);
}

private SpinnerValueFactory<Integer> spinner;
    
public void purchaseDisplayQTY(){
    spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
    shopping_qun.setValueFactory(spinner);
}
private int qty;
public void purhcaseQty(){
    qty = shopping_qun.getValue();
}

private double totalP;
public void purchaseAdd(){
    purchasecustomerId();

    String sql = "INSERT INTO customer (customer_id, book_id, title, author, type, quantity, price, date) "
            + "VALUES(?,?,?,?,?,?,?,?)";

    conn = DataBase.ConDb();

    try{
        Alert alert;

        if(shopping_bookTitle.getSelectionModel().getSelectedItem() == null
                || shopping_bookID.getSelectionModel().getSelectedItem() == null){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setHeaderText(null);
            alert.setContentText("Please choose book first");
            alert.showAndWait();
        }else{

            ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(customerId));
            ps.setString(2, shopping_info_id.getText());
            ps.setString(3, shopping_info_title.getText());
            ps.setString(4, shopping_info_author.getText());
            ps.setString(5, shopping_info_type.getText());
            ps.setString(6, String.valueOf(qty));

            String checkData = "SELECT title, price FROM book WHERE title = '"
                    +shopping_bookTitle.getSelectionModel().getSelectedItem()+"'";

            double priceD = 0;

            st = conn.createStatement();
            re = st.executeQuery(checkData);

            if(re.next()){
                priceD = re.getDouble("price");
            }

            totalP = (qty * priceD);

            ps.setString(7, String.valueOf(totalP));

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            ps.setString(8, String.valueOf(sqlDate));

            ps.executeUpdate();

                purchaseDisplayTotal();
            purchaseShowCustomerListData();
        }
    }catch(Exception e){e.printStackTrace();}
}

private double displayTotal;
public void purchaseDisplayTotal(){
    purchasecustomerId();

    String sql = "SELECT SUM(price) FROM customer WHERE customer_id = '"+customerId+"'";

    conn = DataBase.ConDb();

    try{
       ps = conn.prepareStatement(sql);
       re = ps.executeQuery();

        if(re.next()){
            displayTotal = re.getDouble("SUM(price)");
        }

        shopping_Total.setText("$" + String.valueOf(displayTotal));

    }catch(Exception e){e.printStackTrace();}

}
    
public void purchasePay(){

     String sql = "INSERT INTO customer_info (customer_id, total, date) "
             + "VALUES(?,?,?)";

     conn = DataBase.ConDb();

     try{
         Alert alert;
         if(displayTotal == 0){
             alert = new Alert(AlertType.ERROR);
             alert.setTitle("Error message");
             alert.setHeaderText(null);
             alert.setContentText("Invalid :3");
             alert.showAndWait();
         }else{
             alert = new Alert(AlertType.CONFIRMATION);
             alert.setTitle("Confirmation message");
             alert.setHeaderText(null);
             alert.setContentText("Are you sure?");
             Optional<ButtonType> option = alert.showAndWait();

             if(option.get().equals(ButtonType.OK)){
                 ps = conn.prepareStatement(sql);
                 ps.setString(1, String.valueOf(customerId));
                 ps.setString(2, String.valueOf(displayTotal));

                 Date date = new Date();
                 java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                 ps.setString(3, String.valueOf(sqlDate));

                 ps.executeUpdate();

                 alert = new Alert(AlertType.INFORMATION);
                 alert.setTitle("Information message");
                 alert.setHeaderText(null);
                 alert.setContentText("Successful!");
                 alert.showAndWait();
             }
         }
     }catch(Exception e){e.printStackTrace();}

 }

//incom

public void incom_A(){

      String sql = "SELECT COUNT(id) FROM book";

      conn = DataBase.ConDb();
      int count_a = 0;
      try{
          ps = conn.prepareStatement(sql);
          re = ps.executeQuery();

          if(re.next()){
              count_a = re.getInt("COUNT(id)");
          }

          incom_a.setText(String.valueOf(count_a));

      }catch(Exception e){e.printStackTrace();}
  }
  
public void incom_B(){

  String sql = "SELECT SUM(total) FROM customer_info";

  conn = DataBase.ConDb();
  double sumTotal = 0;
  try{
      ps = conn.prepareStatement(sql);
      re = ps.executeQuery();

      if(re.next()){
          sumTotal = re.getDouble("SUM(total)");
      }

      incom_b.setText("$" + String.valueOf(sumTotal));

  }catch(Exception e){e.printStackTrace();}
}

public void incom_C(){
      String sql = "SELECT COUNT(id) FROM customer_info";

      conn = DataBase.ConDb();
        int count_c = 0;
        try{
            ps = conn.prepareStatement(sql);
            re = ps.executeQuery();

          if(re.next()){
              count_c = re.getInt("COUNT(id)");
          }

          incom_c.setText(String.valueOf(count_c));

      }catch(Exception e){e.printStackTrace();}

  }

public void IncomeChart(){

    income_Chart.getData().clear();

    String sql = "SELECT date, SUM(total) FROM customer_info GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 6";

    conn = DataBase.ConDb();

    try{
        XYChart.Series chart = new XYChart.Series();

        ps = conn.prepareStatement(sql);
        re = ps.executeQuery();

        while(re.next()){
            chart.getData().add(new XYChart.Data(re.getString(1), re.getInt(2)));
        }

        income_Chart.getData().add(chart);

    }catch(Exception e){e.printStackTrace();}

}

public void CustomerChart(){

      custom_chart.getData().clear();

      String sql = "SELECT date, COUNT(id) FROM customer_info GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 4";

      conn = DataBase.ConDb();

      try{
          XYChart.Series chart = new XYChart.Series();

          ps = conn.prepareStatement(sql);
          re = ps.executeQuery();

          while(re.next()){
              chart.getData().add(new XYChart.Data(re.getString(1), re.getInt(2)));
          }

          custom_chart.getData().add(chart);

      }catch(Exception e){e.printStackTrace();}
}



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        displayUsername();
        incom_A();
        incom_B();
        incom_C();
        availableBooksShowListData();
        purchaseBookId();
        purchaseBookTitle();
        purchaseShowCustomerListData();
        purchaseDisplayQTY();
        purchaseDisplayTotal();
    }    
    
}
