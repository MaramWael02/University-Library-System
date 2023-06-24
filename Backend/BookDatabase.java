package frontend;

public class BookDatabase extends Database {

    public BookDatabase(String filename)
    {

        super(filename);
    }
    @Override
    public Book createRecordFrom(String line)
    {
        String [] b= line.split(",");
        return new Book(b[0],b[1],b[2],b[3],Integer.parseInt(b[4]));
    }






}
