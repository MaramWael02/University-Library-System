package frontend;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Database {

    private String filename;
    private ArrayList <Record> records=new ArrayList<>();
    int c=0;
    public Database(String filename)
    {
        this.filename=filename;
    }
    public String getFilename()
    {
        return filename;
    }
    public void readFromFile(){
        try {
            File f = new File(getFilename());
            Scanner sc = new Scanner(f);
            String data;
            while (sc.hasNextLine()) {
                data = sc.nextLine();
                if(data.equals(""))
                    break;
                String[] ld = data.split(",");
                for(int i=0;i<c;i++)
                    if(records.get(i).getSearchKey().equals(ld[0]))
                    {
                        System.out.println("Duplicate ID ");
                        System.exit(0);
                    }
                Record r= createRecordFrom(data);
                records.add(r);
                c++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }


    abstract Record createRecordFrom(String line);

    public boolean contains(String key){
        for(int i=0;i< records.size();i++)
            if(key.equals(records.get(i).getSearchKey()))
                return true;
        return false;
    }
    public Record getRecord(String key){
        for(int i=0;i< records.size();i++)
            if(key.equals(records.get(i).getSearchKey()))
                return records.get(i);
        return null;
    }
    public ArrayList<Record> returnAllRecords(){
        return records;
    }

    public void insertRecord(Record record)
    {
        records.add(record);
    }

    public void deleteRecord(String key){
        for(int i=0;i<records.size();i++)
            if(key.equals(records.get(i).getSearchKey()))
                records.remove(i);
    }

    public void saveToFile(){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(getFilename(),false));

            for(int i=0;i<records.size();i++) {
                out.write(records.get(i).lineRepresentation());
                out.newLine();

            }
            out.close();

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }







}
