package quantumbookstore;

public class DemoBook extends Book{
  
    public DemoBook(String ISBN ,String title ,int publishYear ,double price){
        super(ISBN,title,publishYear,price) ;
    }
    
    @Override
    public boolean isSellable() {
        return false;
    }
}
