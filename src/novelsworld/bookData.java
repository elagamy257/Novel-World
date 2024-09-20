/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package novelsworld;

import java.util.Date;

/**
 *
 * @author Aya El-Agamy
 */
public class bookData {
  
    private Integer bookId;
    private String title;
    private String author;
    private String type;
    private Date date;
    private Double price;
    private String image;
    // MAKE SURE YOU FOLLOWED THE PARAMETERS THAT I PUT
    public bookData(Integer bookId, String title, String author, String type
            , Date date, Double price, String image){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.type = type;
        this.date = date;
        this.price = price;
        this.image = image;
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
    public Date getDate(){
        return date;
    }
    public Double getPrice(){
        return price;
    }
    public String getImage(){
        return image;
    }
    
}

