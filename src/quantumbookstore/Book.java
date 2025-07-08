package quantumbookstore;

import java.util.ArrayList;
import java.util.LinkedList;

public class Book {
    
    private String ISBN ;
    private String title ;
    private int publishYear ;
    private double price ;
    private boolean isSellable = true ;
        
    public Book(){
        
    }
    public Book(String ISBN ,String title ,int publishYear ,double price){
        this.ISBN = ISBN ;
        this.title = title ;
        this.publishYear = publishYear ;
        this.price = price ;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSellable() {
        return isSellable;
    }
    
    public String toString(){
        return "Book title "+this.title+" published at "+this.publishYear ;
    }
}
