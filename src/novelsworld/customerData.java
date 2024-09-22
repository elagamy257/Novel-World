/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package novelsworld;
import java.sql.Date;
/**
 *
 * @author Aya El-Agamy
 */
public class customerData {
    private Integer customerId;
    private Integer bookId;
    private String title;
    private String author;
    private String type;
    private Integer quantity;
    private Double price;
    private Date date;
    
    public customerData(Integer customerId, Integer bookId, String title, String author
            , String type, Integer quantity, Double price, Date date){
        this.customerId = customerId;
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }
    public Integer getCustomerId(){
        return customerId;
    }
    public Integer getBookId(){
        return bookId;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getType(){
        return type;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public Double getPrice(){
        return price;
    }
    public Date getDate(){
        return date;
    }
}
