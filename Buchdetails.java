/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 09.01.2017
  * @author 
  */
import java.awt.*;
import java.util.*;
public class Buchdetails extends BObjekt {
  
  // Anfang Attribute
  private String isbn;
  private String vin;
  private String titel;
  private String autor;
  private String preis;
  private String bestellnummer;
  private String fach;
  ArrayList<HashMap<String,String>> liste;
  DB db = new DB();
  public Buchdetails(String isbn,String vin, String titel, String autor, String preis, String bestellnummer, String fach) {
    if (DB.isConnected()) {
      DB.executeUpdate("INSERT INTO buchdetails(isbn,vin,titel,autor,preis,bestellnummer,fach) VALUES('"+isbn+"','"+vin+"','"+titel+"','"+autor+"','"+preis+"','"+bestellnummer+"','"+fach+"')" );
      this.isbn = isbn;
      this.vin = vin;
      this.titel = titel;
      this.autor = autor;
      this.preis = preis;
      this.bestellnummer = bestellnummer;
      this.fach = fach;
    } // end of if
    else {
      DB.verbinden();
      DB.executeUpdate("INSERT INTO buchdetails(isbn,vin,titel,autor,preis,bestellnummer,fach) VALUES('"+isbn+"','"+vin+"','"+titel+"','"+autor+"','"+preis+"','"+bestellnummer+"','"+fach+"')" );
      this.isbn = isbn;
      this.vin = vin;
      this.titel = titel;
      this.autor = autor;
      this.preis = preis;
      this.bestellnummer = bestellnummer;
      this.fach = fach;
    } // end of if-else
  }
  
  public Buchdetails(String isbn){
    liste = new ArrayList<HashMap<String,String>>();
    if (DB.isConnected()) {
      liste = DB.getSQLResults("SELECT * FROM buchdetails WHERE buchdetails.isbn = "+isbn+";");
      this.isbn = isbn;
      this.vin = liste.get(0).get("vin");
      this.titel = liste.get(0).get("titel");
      this.autor = liste.get(0).get("autor");
      this.preis = liste.get(0).get("preis");
      this.bestellnummer = liste.get(0).get("bestellnummer");
      this.fach = liste.get(0).get("fach");
    } // end of if
    else {
      DB.verbinden();
      liste = DB.getSQLResults("SELECT * FROM buchdetails WHERE buchdetails.isbn = "+isbn+";");
      this.isbn = isbn;
      this.vin = liste.get(0).get("vin");
      this.titel = liste.get(0).get("titel");
      this.autor = liste.get(0).get("autor");
      this.preis = liste.get(0).get("preis");
      this.bestellnummer = liste.get(0).get("bestellnummer");
      this.fach = liste.get(0).get("fach");
    } // end of if-else
    
  }      

  public Buchdetails(HashMap<String,String> hash){
    this.isbn = hash.get("isbn");
    this.vin = hash.get("vin");
    this.titel = hash.get("titel");
    this.autor = hash.get("autor");
    this.preis = hash.get("preis");
    this.bestellnummer = hash.get("bestellnummer");
    this.autor = hash.get("fach");
    
  }
  
  //2 = buchdetails   
  public int getKlassenID() {
    return 2;
  }

  public String getID() {
    return isbn;
  }  
  
  public String getName() {
    return titel + " -- " + autor;
  } 
   
  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE buchdetails SET isbn = '"+isbn+"' WHERE isbn ='"+this.isbn+"'");
      DB.executeUpdate("UPDATE buch SET isbn = '"+isbn+"' WHERE isbn ='"+this.isbn+"'");
      this.isbn = isbn;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE buchdetails SET isbn = '"+isbn+"' WHERE isbn ='"+this.isbn+"'"); 
        DB.executeUpdate("UPDATE buch SET isbn = '"+isbn+"' WHERE isbn ='"+this.isbn+"'");
        this.isbn = isbn;
      } // end of if
      else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } // end of if-else
  }

  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE buchdetails SET vin = '"+vin+"' WHERE isbn ='"+this.isbn+"'");
      DB.executeUpdate("UPDATE verlag SET vin = '"+vin+"' WHERE isbn ='"+this.isbn+"'");
      this.vin = vin;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE buchdetails SET vin = '"+vin+"' WHERE isbn ='"+this.isbn+"'");
        DB.executeUpdate("UPDATE verlag SET vin = '"+vin+"' WHERE isbn ='"+this.isbn+"'"); 
        this.vin = vin;
      } // end of if
      else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } // end of if-else
  }

  public String getTitel() {
    return titel;
  }

  public void setTitel(String titel) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE buchdetails SET titel = '"+titel+"' WHERE isbn ='"+this.isbn+"'");
      this.titel = titel;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE buchdetails SET titel = '"+titel+"' WHERE isbn ='"+this.isbn+"'");
        this.titel = titel;
      } // end of if
      else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } // end of if-else
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE buchdetails SET autor = '"+autor+"' WHERE isbn ='"+this.isbn+"'");
      this.autor = autor;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE buchdetails SET autor = '"+autor+"' WHERE isbn ='"+this.isbn+"'");
        this.autor = autor;
      } // end of if
      else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } // end of if-else
  }

  public String getPreis() {
    return preis;
  }

  public void setPreis(String preis) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE buchdetails SET preis = '"+preis+"' WHERE isbn ='"+this.isbn+"'");
      this.preis = preis;
      
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE buchdetails SET preis = '"+preis+"' WHERE isbn ='"+this.isbn+"'");
        this.preis = preis;
      } // end of if
      else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } // end of if-else
  }

  public String getBestellnummer() {
    return bestellnummer;
  }

  public void setBestellnummer(String bestellnummer) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE buchdetails SET bestellnummer = '"+bestellnummer+"' WHERE isbn ='"+this.isbn+"'");
      this.bestellnummer = bestellnummer;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE buchdetails SET bestellnummer = '"+bestellnummer+"' WHERE isbn ='"+this.isbn+"'");
        this.bestellnummer = bestellnummer;
      } // end of if
      else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } // end of if-else
  }

  public String getFach() {
    return fach;
  }

  public void setFach(String fach) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE buchdetails SET fach = '"+fach+"' WHERE isbn ='"+this.isbn+"'");
      this.fach = fach;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE buchdetails SET fach = '"+fach+"' WHERE isbn ='"+this.isbn+"'");
        this.fach = fach;
      } // end of if
      else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } // end of if-else
  }
  
  public static void main(String[] args){
    Buchdetails b1 = new Buchdetails("3122602407");
    b1.setTitel("Das Feuerschiff");
    System.out.println(b1.getTitel());
  }
}
