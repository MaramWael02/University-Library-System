package frontend;


import java.util.ArrayList;


public class AdminRole {
    private LibrarianDatabase database;

    public AdminRole(){
        database=new LibrarianDatabase("Librarians.txt");
        database.readFromFile();
    }
    public void addLibrarian(String librarianId, String name, String email, String address, String phoneNumber){
        LibrarianUser l=new LibrarianUser(librarianId,name,email,address,phoneNumber);
        database.insertRecord(l);
        database.saveToFile();
    }
    public LibrarianUser[] getListOfLibrarians() {
       ArrayList<Record> al= database.returnAllRecords();
       LibrarianUser [] l=new LibrarianUser[al.size()];
       return al.toArray(l);

    }
    public void removeLibrarian(String key)
    {
        database.deleteRecord(key);
        database.saveToFile();
    }
    public void logout()
    {
        database.saveToFile();
    }
}