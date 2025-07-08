package quantumbookstore;

public class PaperBook extends Book{
    
    private int stock ;
    private boolean isShipped ;
    
    public PaperBook(String ISBN ,String title ,int publishYear ,double price ,int stock){
        super(ISBN,title,publishYear,price) ;
        this.stock = stock;
    }
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
 
    public void currentQuantity(int quantity){
        if(quantity > stock){
            System.out.println("There is no enough items");
        }else
            stock -= quantity ;
    }
    
}
