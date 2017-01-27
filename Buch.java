/**
  *
  * Beschreibung
  *
  * @version 0.8 vom 09.01.2017
  * @author Mostafa Hamied
  */
import java.util.*;
public class Buch extends BObjekt {
  
  // Anfang Attribute
  protected String isbn;
  protected String regdatum;
  protected String bin;
  ArrayList<HashMap<String,String>> liste;
  DB db = new DB();
  Codes codes = new Codes();
  // Ende Attribute
  
  public Buch(String isbn, String regdatum, String bin) {
    if (DB.isConnected()) {
      DB.executeUpdate("INSERT INTO buch(isbn,regdatum,bin); VALUES('"+isbn+"','"+regdatum+"','"+bin+"')");
      this.isbn = isbn;
      this.regdatum = regdatum;
      this.bin = bin;
    } // end of if
    else {
      DB.verbinden();
      DB.executeUpdate("INSERT INTO buch(isbn,regdatum,bin); VALUES('"+isbn+"','"+regdatum+"','"+bin+"')");
      this.isbn = isbn;
      this.regdatum = regdatum;
      this.bin = bin;
    } // end of if
  } // end of if-else
  
  
  public Buch(HashMap<String,String> hash){
    this.isbn = hash.get("isbn");
    this.regdatum = hash.get("regdatum");
    this.bin = hash.get("bin");
  }  
  
  public Buch(String bin){
    liste = new ArrayList<HashMap<String,String>>();
    if (DB.isConnected()) {
      liste = DB.getSQLResults("SELECT * FROM buch WHERE buch.bin = "+bin+";");
      this.bin = bin;
      this.isbn = liste.get(0).get("isbn");
      this.regdatum = liste.get(0).get("vin");
    } // end of if
    else {
      DB.verbinden();
      liste = DB.getSQLResults("SELECT * FROM buch WHERE buch.bin = "+bin+";");
      this.bin = bin;
      this.isbn = liste.get(0).get("isbn");
      this.regdatum = liste.get(0).get("vin");
    } // end of if-else
    
  }      
  
  public String getName(){
    return null;
  }
  
  public String getID(){
    return bin;
  }  
    
  public String getIsbn() {
    return isbn;
  }

  public void setBin(String Bin) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE buch SET bin = '"+bin+"' WHERE bin ='"+this.bin+"'");
      this.bin = bin;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE buch SET bin = '"+bin+"' WHERE bin ='"+this.bin+"'");
        this.bin = bin;
      } // end of if
      else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } // end of if-else
  }

  public String getRegdatum() {
    return regdatum;
  }

  public void setRegdatum(String regdatum) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE buch SET regdatum = '"+regdatum+"' WHERE bin ='"+this.bin+"'");
      this.regdatum = regdatum;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE buch SET regdatum = '"+regdatum+"' WHERE bin ='"+this.bin+"'");
        this.regdatum = regdatum;
      } // end of if
      else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } // end of if-else
  }

  public String getBin() {
    return bin;
  }

  public void setIsbn(String isbn) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE buch SET isbn = '"+isbn+"' WHERE bin ='"+this.bin+"'");
      DB.executeUpdate("UPDATE buchdetails SET isbn = '"+isbn+"' WHERE isbn ='"+this.isbn+"'");
      System.out.println("UPDATE buch SET isbn = '"+isbn+"' WHERE bin ='"+this.bin+"'");
      System.out.println("UPDATE buchdetails SET isbn = '"+isbn+"' WHERE isbn ='"+this.isbn+"'");
      this.isbn = isbn;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE buch SET isbn = '"+isbn+"' WHERE bin ='"+this.bin+"'");
        DB.executeUpdate("UPDATE buchdetails SET isbn = '"+isbn+"' WHERE bin ='"+this.bin+"'");
        this.isbn = isbn;
      } // end of if
      else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } // end of if-else
  }
  
  /**
   * 1 = buch
   */ 
   
  public int getKlassenID(){
    return 1;
  }
  
  public void loeschen(String bin){
    if (DB.isConnected()) {
      if (istVorhanden(bin) == true) {
        DB.executeUpdate("DELETE FROM buch WHERE bin ="+bin+";");
      } // end of if
      else {
        System.out.println("Buch nicht vorhanden.");
      } // end of if-else
    } // end of if
    else {
      DB.verbinden();
      if (istVorhanden(bin) == true) {
        DB.executeUpdate("DELETE FROM buch WHERE bin ="+bin+";");
      } // end of if
      else {
        System.out.println("Buch nicht vorhanden.");
      } // end of if-else
    } // end of if-else
    
  }
      
  public boolean istVorhanden(String pin){
    liste = new ArrayList<HashMap<String,String>>() ;
    liste = DB.getSQLResults("SELECT bin FROM buch WHERE bin="+this.bin+");");
    return liste.isEmpty() ;
    
  }
  
  public static void main(String[] args){
    Buch b1 = new Buch("97882053");
    b1.setIsbn("77777777X");
    System.out.println(b1.getIsbn());
  }
}

  