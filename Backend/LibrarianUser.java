package frontend;

public class LibrarianUser implements Record{
    private String librarianId;
    private String Name;
    private String Email;
    private String Address;
    private String PhoneNumber;
    public LibrarianUser(String librarianId, String name, String email, String address,String phoneNumber)
    {
        this.librarianId=librarianId;
        this.Name=name;
        this.Email=email;
        this.Address=address;
        this.PhoneNumber=phoneNumber;
    }

    public String lineRepresentation()
    {
        return this.librarianId+","+this.Name+","+this.Email+","+this.Address+","+this.PhoneNumber;
    }
    public String getSearchKey()
    {
        return librarianId;
    }



}
