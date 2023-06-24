package frontend;


import java.time.LocalDate;
public class StudentBookDatabase extends Database {

    public StudentBookDatabase(String filename)
    {

        super(filename);
    }
    public StudentBook createRecordFrom(String line)
    {
        String [] b= line.split(",");
        return new StudentBook(b[0],b[1],LocalDate.parse(b[2]));
    }




}
