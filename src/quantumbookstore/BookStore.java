package quantumbookstore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class BookStore {
    
    private final int THRESHOLD = 5 ;
    HashMap<Book,Integer> books = new HashMap<>() ;
    
    private ShippingService shippingService;
    private MailService mailService;
    
    public BookStore(){
        
    }
    
    public void addBook(Book book,int quantity){
        if(book instanceof PaperBook paperBook){
            paperBook.setStock(quantity);
        }
        books.put(book, books.get(book) == null ? 0+quantity : books.get(book)+quantity ) ;
    }

    public void addBook(String ISBN ,String title ,int publishYear ,double price,int quantity){
        Book book = new Book(ISBN ,title ,publishYear ,price) ;
        books.put(book, books.get(book) == null ? 0+quantity : books.get(book)+quantity) ;
    }
      
    
    public void removeBook(){
        
        ArrayList<Book> outdatedBooks = new ArrayList<>() ;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR) ;
        Iterator<Book> iterator = books.keySet().iterator() ;
        
        while (iterator.hasNext()){
        Book key = iterator.next() ;
            if (currentYear - key.getPublishYear() > this.THRESHOLD){
                outdatedBooks.add(key) ;
                iterator.remove() ;  
            }
        }
        System.out.println("The removed Book from the Store") ;
        for (Book book : outdatedBooks){
        System.out.println(book.toString()) ;
        }
    }
    
    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        Book book = null ;
        double totalCost = 0 ;
        
        for (Book key : books.keySet()) {
            if (key.getISBN().equals(isbn)) {
                book = key ;
                break ;
            }
        }
        if (book == null) {
        throw new Exception("Quantum book store: The book is not found") ;
        }
        if (!book.isSellable()) {
        throw new Exception("Quantum book store: The book is not for sale") ;
        }
        if(books.get(book) < quantity){
            throw new Exception("Quantum book store: The book stock is not enough") ;
        }
        if(book instanceof PaperBook paperBook){
            paperBook.currentQuantity(quantity) ; 
            shippingService.shippingService(paperBook, address) ;
        }else if(book instanceof EBook ebook){
            mailService.mailService(ebook, email) ;
        }
        totalCost = quantity * book.getPrice() ;
        System.out.println("You have buy the book "+book.getTitle()+" Successully");
        System.out.println("The total cost "+quantity+" * "+book.getPrice()+" = "+totalCost);
        return totalCost ;
    }
}
