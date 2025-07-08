package quantumbookstore;
public class QuantumBookStore {
    public static void main(String[] args) throws Exception {
        
        
        Book book1 = new Book("KAMMMM120","Head First Java",2017 ,150) ;
        Book book2 = new Book("mm145kmoh","Head First Python",2010 ,225.0) ;
        Book book3 = new Book("2013manbs","Head First OOD",2009 ,300) ;
        Book book4 = new Book("12520","Head First Design Patterns",2022 ,225.0) ;
        
        BookStore bookStore = new BookStore();
        
        bookStore.addBook(book1,5);
        bookStore.addBook(book2,6);
        bookStore.addBook(book3,7);
        bookStore.addBook(book4,8);
        
       // bookStore.removeBook();
        
        bookStore.buyBook("KAMMMM120",5, "kalaa8851@gmail.com", "Zagazig") ;
        
    }
    
}
