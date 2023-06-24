package frontend;


import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.time.LocalDate;

public class LibrarianRole {

private BookDatabase booksDatabase;
private StudentBookDatabase sBDatabase;

public LibrarianRole(){
    booksDatabase=new BookDatabase("Books.txt");
    booksDatabase.readFromFile();
    sBDatabase=new StudentBookDatabase("StudentsBooks.txt");
    sBDatabase.readFromFile();

}
public void addBook(String id, String title, String authorName, String publisherName, int quantity) {
    Book b=new Book(id,title,authorName,publisherName,quantity);
    booksDatabase.insertRecord(b);
    booksDatabase.saveToFile();
}
public Book[] getListOfBooks(){
    ArrayList<Record> bl=booksDatabase.returnAllRecords();
    Book [] b=new Book[bl.size()];
    return bl.toArray(b);

}
public StudentBook[] getListOfBorrowingOperations()
{
    ArrayList<Record> sbl=sBDatabase.returnAllRecords();
    StudentBook [] sb=new StudentBook[sbl.size()];

    return sbl.toArray(sb);
}
public int borrowBook(String studentId, String bookId, LocalDate borrowDate)
{
    StudentBook s=new StudentBook(studentId,bookId,borrowDate);
    Book b= (Book) booksDatabase.getRecord(bookId);
    if(sBDatabase.contains(s.getSearchKey()))
        return 1;
    if(b.getQuantity()==0) {
        return 0;
    }
    sBDatabase.insertRecord(s);
    b.setQuantity(b.getQuantity()-1);
    return 2;
}

public double returnBook(String studentId, String bookId, LocalDate returnDate)
{
String s=studentId+","+bookId;
StudentBook sb= (StudentBook) sBDatabase.getRecord(s);
Book b= (Book) booksDatabase.getRecord(bookId);
b.setQuantity(b.getQuantity()+1);
sBDatabase.deleteRecord(s);
double difference = ChronoUnit.DAYS.between(sb.getBorrowDate(),returnDate);
if(difference<=7)
    return 0;
else
    return (difference-7)*0.5;
}
public void logout()
{
sBDatabase.saveToFile();
booksDatabase.saveToFile();
}


    }
