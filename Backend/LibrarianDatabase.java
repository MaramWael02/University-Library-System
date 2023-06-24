package frontend;

public class LibrarianDatabase extends Database {
    public LibrarianDatabase(String filename)
    {

        super(filename);
    }

    public LibrarianUser createRecordFrom(String line)
    {
        String [] lu= line.split(",");
        return new LibrarianUser(lu[0],lu[1],lu[2],lu[3],lu[4]);
    }


}
