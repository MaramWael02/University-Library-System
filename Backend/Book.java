package frontend;

public class Book implements Record {
    private String bookId;
    private String title;
    private String authorName;
    private String publisherName;
    private int quantity;
    public Book(String id, String title, String authorName, String publisherName, int quantity)
    {
        this.bookId=id;
        this.title=title;
        this.authorName=authorName;
        this.publisherName=publisherName;
        this.quantity=quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity( int q)
    {
        quantity=q;
    }
    public String lineRepresentation()
    {
        return bookId+","+title+","+authorName+","+publisherName+","+ quantity;

    }
   public String getSearchKey()
   {
       return bookId;
   }

}
